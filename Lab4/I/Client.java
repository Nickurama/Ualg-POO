import java.lang.reflect.Constructor;
import java.util.Scanner;

/**
 * The class to manage the input and output
 * 
 * @author Diogo Fonseca a79858
 * @version 16/03/2024
 */
public class Client
{

    /**
     * The main method
     * @param args ignored
     */
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Constructor<?> constructor;
        Class<?> cl;
        UniquePolygons polys = new UniquePolygons();
        Poligono currPoly;
        String input;
        String[] tokens;
        while (sc.hasNextLine())
        {
            input = sc.nextLine();
            if (input.isEmpty())
                break;
            tokens = input.split(" ", 2);

            try
            {
                cl = Class.forName(capital(tokens[0]));
                constructor = cl.getConstructor(String.class);
                currPoly = (Poligono) constructor.newInstance(tokens[1]);
                polys.add(currPoly);
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
        sc.close();

        String[] strings = polys.toStrings();
        for (String s : strings)
            System.out.println(s);
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
}
