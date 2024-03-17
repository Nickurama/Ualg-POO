/**
 * Represents an immutable point in two dimensional space, in the first quadrant only
 * 
 * @author Diogo Fonseca a79858
 * @version 16/03/2024
 */
public class Point extends VirtualPoint
{
    private static final String ERROR_MESSAGE = "Ponto:vi";

    /**
     * Initializes a point
     * @param x the x coordinate
     * @param y the y coordinate
     * @pre x >= 0
     * @pre y >= 0
     */
    public Point(double x, double y)
    {
        super(x, y);
        if (x < 0 || y < 0)
            Error.terminateProgram(ERROR_MESSAGE);
    }

    /**
     * Initializes the point, performing a deep copy
     * over the other point
     * @param p the point to copy from
     */
    public Point(Point p)
    {
        super(p);
    }
    
    /**
     * Performs a deep copy of an array of points
     * @param array the array to copy
     * @return the copy of the array
     */
    public static Point[] copyArray(Point[] array) //! Issue: if not implemented, could use the parent class's implementation which will break
    {
        Point[] result = new Point[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = new Point(array[i]);
        return result;
    }

    /**
     * Creates array of points from a string with the format:
     * num_points x0 y0 x1 y1 x2 y2 ...
     * @param str the string to read the points from
     * @return the points extracted form the string
     */
    public static Point[] parseToArray(String str)
    {
        //! unhandled exception
        String[] tokens = str.split(" ");
        if (tokens.length < 3)
            return null;
        
        int numVertices = Integer.parseInt(tokens[0]);
        Point[] result = new Point[numVertices];
        for (int i = 1; i < tokens.length; i += 2)
        {
            double x = Double.parseDouble(tokens[i]);
            double y = Double.parseDouble(tokens[i + 1]);
            result[i / 2] = new Point(x, y);
        }

        return result;
    }

    /**
     * Creates array of points from a string with the format:
     * x0 y0 x1 y1 x2 y2 ...
     * @param str the string to read the points from
     * @param numPoints how many points are to be read from the string
     * @return the points extracted from the string
     */
    public static Point[] parseToArray(String str, int numPoints)
    {
        return parseToArray(String.valueOf(numPoints) + " " + str);
    }
}