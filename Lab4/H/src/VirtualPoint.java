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
     * Performs a deep copy of the point
     * @return a deep copy of the point
     */
    public VirtualPoint copy()
    {
        return new VirtualPoint(this);
    }

    /**
     * Performs a deep copy of an array of points
     * @param array the array to copy
     * @return a deep copy of the array
     */
    public static VirtualPoint[] copyArray(VirtualPoint[] array)
    {
        VirtualPoint[] result = new VirtualPoint[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = array[i].copy();
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
    public boolean equals(VirtualPoint that)
    {
        return MathUtil.areEqual(this.x, that.x) && MathUtil.areEqual(this.y, that.y);
    }

    /**
     * Acessor method to return the x coordinate
     */
    public double getX() { return this.x; }

    /**
     * Accessor method to return the y coordinate
     */
    public double getY() { return this.y; }
}
