import java.util.Scanner;

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
    public static void main(String[] args)
    {
        Point[] points = getPointsFromInput();
        Polygon poly = new Polygon(points);
        System.out.println((int)poly.perimeter());
    }

    /**
     * Gets an array of points from the standard input
     * @return the array of points read
     */
    private static Point[] getPointsFromInput()
    {
        Scanner reader = new Scanner(System.in);
        
        int n = reader.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++)
            points[i] = Point.getPointFromInput(reader);

        reader.close();
        return points;
    }
}
