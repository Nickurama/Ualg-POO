package src;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Represents an immutable point in two dimensional space
 * 
 * @author Diogo Fonseca a79858
 * @version 21/02/2024
 * 
 * @inv x the x coordinate
 * @inv y the y coordinate
 */
public class VirtualPoint
{
    protected double x, y;

    /**
     * Initializes the virtual point
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public VirtualPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Initializes the virtual point, performing a deep copy
     * over the other virtual point
     * @param p the virtual point to copy from
     */
    public VirtualPoint(VirtualPoint p)
    {
        this(p.x, p.y);
    }

    /**
     * Performs a deep copy of an array of points
     * @param array the array to copy
     * @return a deep copy of the array
     */
    public static VirtualPoint[] copyArray(VirtualPoint[] array) //! Can cause errors
    {
        VirtualPoint[] result = new VirtualPoint[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = new VirtualPoint(array[i]);
        return result;
    }

    /**
     * Initializes a virtual point from the input of a scanner
     * @param reader the scanner to read the point from
     * @return the initialized point
     */
    public static VirtualPoint getPointFromInput(BufferedReader reader) throws IOException
    {
        String[] tokens = reader.readLine().split(" ");
        return new VirtualPoint(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]));
    }

    /**
     * Calculates the distance between the current point and the other
     * @param that the point to calculate the distance with
     * @return the distance between the points
     */
    public double dist(VirtualPoint that)
    {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Checks if the two points are equivalent (occupy the same coordinates)
     * @param that the point to compare to
     * @return if the two points are equivalent
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == this) return true;
        if (other == null) return false;
        if (!VirtualPoint.class.isInstance(other)) return false; // if not VirtualPoint or child of VirtualPoint
        VirtualPoint that = (VirtualPoint) other;
        return MathUtil.areEqual(this.x, that.x) && MathUtil.areEqual(this.y, that.y);
    }

    @Override
    public String toString()
    {
        return "(" + (int)this.x + "," + (int)this.y + ")";
    }

    public static String arrayToString(VirtualPoint[] points)
    {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < points.length - 1; i++)
        {
            str.append(points[i].toString());
            str.append(", ");
        }
        str.append(points[points.length - 1].toString());
        str.append("]");

        return str.toString();
    }

    public static VirtualPoint[] stringToArray(String str)
    {
        //! unhandled exception
        String[] tokens = str.split(" ");
        if (tokens.length < 3)
            return null;
        
        int numVertices = Integer.parseInt(tokens[0]);
        VirtualPoint[] result = new VirtualPoint[numVertices];
        for (int i = 1; i < tokens.length; i += 2)
        {
            double x = Double.parseDouble(tokens[i]);
            double y = Double.parseDouble(tokens[i + 1]);
            result[i / 2] = new VirtualPoint(x, y);
        }

        return result;
    }

    /**
     * Acessor method to return the x coordinate
     */
    public double X() { return this.x; }

    /**
     * Accessor method to return the y coordinate
     */
    public double Y() { return this.y; }
}
