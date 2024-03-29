/**
 * Represents an immutable vector
 * 
 * @author Diogo Fonseca a79858
 * @version 17/03/2024
 */
public class Vector
{
    private static final VirtualPoint origin = new VirtualPoint(0, 0);
    private VirtualPoint point;
    private double length;
    
    /**
     * Initializes a vector
     * @param p parses a point to a vector
     */
    public Vector(VirtualPoint p)
    {
        this.point = p;
        this.length = (origin.dist(p));
    }

    /**
     * Initializes a vector
     * @param x the x of the vector
     * @param y the y of the vector
     */
    public Vector(double x, double y)
    {
        this(new VirtualPoint(x, y));
    }

    /**
     * Gets the vector's length
     * @return the vector's length
     */
    public double length()
    {
        return this.length;
    }

    /**
     * Calculates the dot product between two vectors
     * @param that the other vector to calculate the dot product with
     * @return the dot product of the two vectors
     */
    public double dotProduct(Vector that)
    {
        return this.point.X() * that.point.X() + this.point.Y() * that.point.Y();
    }

    // public double angle(Vector that)
    // {
    //     return Math.acos(this.dotProduct(that) / (this.length() * that.length()));
    // }

    /**
     * calculates if the two vectors produce a right angle
     * @param that the other vector to calculate the angle with
     * @return if the two vectors produce a right angle
     */
    public boolean hasRightAngle(Vector that)
    {
        return MathUtil.areEqual(this.dotProduct(that), 0);
    }

    /**
     * Acessor method for x variable
     */
    public double X() { return this.point.X(); }

    /**
     * Acessor method for y variable
     */
    public double Y() { return this.point.Y(); }
}
