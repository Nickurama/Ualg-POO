package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

/**
 * The class to manage the input and output
 * 
 * @author Diogo Fonseca a79858
 * @version 21/02/2024
 */
public class Client
{

    /**
     * The main method
     * @param args ignored
     */
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        Constructor<?> constructor;
        Class<?> cl;
        Polygon poly;
        String[] tokens;
        while ((input = reader.readLine()) != null)
        {
            if (input.isEmpty())
                break;

            tokens = input.split(" ", 2);

            try
            {
                cl = Class.forName(capital(tokens[0]));
                constructor = cl.getConstructor(String.class);
                poly = (Polygon) constructor.newInstance(tokens[1]);
            }
            catch (ClassNotFoundException cnfe)
            {
                System.out.println("Não foi encontrada a classe: " + cnfe.getMessage());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            reader.close();
        }
        catch (IOException e)
        {
            //Log?
        }
    }

    /**
     * Capitalizes a string
     * @param s the string to capitalize
     * @return the capitalized string
     */
    public static String capital(String s)
    {
        if (s == null || s.isEmpty())
            return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    /**
     * Gets an array of polygons read from the BufferedReader
     * @param reader the BufferedReader object where the input is gonna be read from
     * @return the array of polygons read
     */
    private static Polygon[] getPolygonsFromInput(BufferedReader reader)
    {
        try
        {
            int numPolygons = Integer.parseInt(reader.readLine());
            Polygon[] polygons = new Polygon[numPolygons];
            for (int i = 0; i < numPolygons; i++)
                polygons[i] = new Polygon(getPointsFromInput(reader));
            return polygons;
        }
        catch (IOException e)
        {
            Error.terminateProgram("Client::getPolygonsFromInput error while reading points: " + e.getMessage());
            return null; //needed because the compiler thinks the program can continue as it doesn't throw an exception
        }
    }

    /**
     * Gets an array of points read from the BufferedReader
     * @param reader the BufferedReader object where the input is gonna be read from
     * @return the array of points read
     */
    private static Point[] getPointsFromInput(BufferedReader reader)
    {
        try
        {
            Point[] points = new Point[Integer.parseInt(reader.readLine())];
            for (int i = 0; i < points.length; i++)
                points[i] = Point.getPointFromInput(reader);
            return points;
        }
        catch (IOException e)
        {
            Error.terminateProgram("Client::getPointsFromInput error while reading points: " + e.getMessage());
            return null; //needed because the compiler thinks the program can continue as it doesn't throw an exception
        }
    }
}
