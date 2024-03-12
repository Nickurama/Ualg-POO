package src;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Represents an immutable point in two dimensional space, in the first quadrant only
 * 
 * @author Diogo Fonseca a79858
 * @version 21/02/2024
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
        this.x = x;
        this.y = y;
    }

    /**
     * Initializes a point from a virtualPoint
     * @param p the virtual point to instanciate the point from
     * @pre p.x >= 0
     * @pre p.y >= 0
     */
    public Point(VirtualPoint p)
    {
        this(p.getX(), p.getY());
    }

    /**
     * Performs a deep copy of the point
     * @return a copy of the point
     */
    public Point copy()
    {
        return new Point(this.x, this.y);
    }

    /**
     * Performs a deep copy of an array of points
     * @param array
     * @return
     */
    public static Point[] copyArray(Point[] array)
    {
        Point[] result = new Point[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = array[i].copy();
        return result;
    }

    /**
     * Initializes a point from a scanner input
     * @param reader scanner from where the point is gonna be read
     * @return the initialized point
     */
    public static Point getPointFromInput(BufferedReader reader) throws IOException
    {
        VirtualPoint p = VirtualPoint.getPointFromInput(reader);
        return new Point(p);
    }
}
