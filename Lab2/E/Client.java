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
        Scanner reader = new Scanner(System.in);
        Point[] trajectoryPoints = getPointsFromInput(reader);
        Path path = new Path(trajectoryPoints);
        Polygon[] obstacles = getPolygonsFromInput(reader);
        reader.close();
        if (path.intersects(obstacles))
            System.out.println("1");
        else
            System.out.println("0");
    }

    /**
     * Gets an array of polygons from the input read from the scanner
     * @param reader the Scanner where the input is gonna be read from
     * @return the array of polygons read
     */
    private static Polygon[] getPolygonsFromInput(Scanner reader)
    {
        int numPolygons = reader.nextInt();
        Polygon[] polygons = new Polygon[numPolygons];
        for (int i = 0; i < numPolygons; i++)
            polygons[i] = new Polygon(getPointsFromInput(reader));
        return polygons;
    }

    /**
     * Gets an array of points from the input read from the scanner
     * @param reader the Scanner where the input is gonna be read from
     * @return the array of points read
     */
    private static Point[] getPointsFromInput(Scanner reader)
    {
        int n = reader.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++)
            points[i] = Point.getPointFromInput(reader);
        return points;
    }
}
