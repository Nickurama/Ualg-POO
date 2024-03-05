import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Point[] points0 = getPointsFromInput(reader);
        Point[] points1 = getPointsFromInput(reader);

        BoundingBox bounds0 = new BoundingBox(points0);
        BoundingBox bounds1 = new BoundingBox(points1);

        if (!bounds0.intercepts(bounds1))
            System.out.println("false");
        else
        {
            Polygon poly1 = new Polygon(points0);
            Polygon poly2 = new Polygon(points1);

            String result = poly1.intercepts(poly2) ? "true" : "false";
            System.out.println(result);
        }

        reader.close();
    }

    /**
     * Gets an array of polygons read from the BufferedReader
     * @param reader the BufferedReader object where the input is gonna be read from
     * @return the array of polygons read
     */
    private static Polygon[] getPolygonsFromInput(BufferedReader reader) throws IOException
    {
        int numPolygons = Integer.parseInt(reader.readLine());
        Polygon[] polygons = new Polygon[numPolygons];
        for (int i = 0; i < numPolygons; i++)
            polygons[i] = new Polygon(getPointsFromInput(reader));
        return polygons;
    }

    /**
     * Gets an array of points read from the BufferedReader
     * @param reader the BufferedReader object where the input is gonna be read from
     * @return the array of points read
     */
    private static Point[] getPointsFromInput(BufferedReader reader) throws IOException
    {
        Point[] points = new Point[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < points.length; i++)
            points[i] = Point.getPointFromInput(reader);
        return points;
    }
}
