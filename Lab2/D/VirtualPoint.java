import java.util.Scanner;

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
     * Initializes the point
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public VirtualPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Performs a deep copy of the point
     * @return a deep copy of the point
     */
    public VirtualPoint copy()
    {
        return new VirtualPoint(this.x, this.y);
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
     * Initializes a point from the input of a scanner
     * @param reader the scanner to read the point from
     * @return the initialized point
     */
    public static VirtualPoint getPointFromInput(Scanner reader)
    {
        return new VirtualPoint(reader.nextDouble(), reader.nextDouble());
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
