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
        String polyStr = sc.nextLine();
        String rotationStr = sc.nextLine();
        String[] polyTokens = polyStr.split(" ", 2);
        String[] rotationTokens = rotationStr.split(" ");
        
        try
        {
            Class<?> cl = Class.forName(capital(polyTokens[0]));
            Constructor<?> constructor = cl.getConstructor(String.class);
            Poligono poly = (Poligono) constructor.newInstance(polyTokens[1]);
            double angle = Double.parseDouble(rotationTokens[0]);
            if (rotationTokens.length == 1)
            {
                System.out.print(poly.rotateDegrees(angle).toString());
            }
            else
            {
                VirtualPoint anchor = new VirtualPoint(Double.parseDouble(rotationTokens[1]), Double.parseDouble(rotationTokens[2]));
                System.out.print(poly.rotateDegrees(angle, anchor).toString());
            }
        }
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("Não foi encontrada a classe: " + cnfe.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        sc.close();
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
