public class Vector
{
    private static final VirtualPoint origin = new VirtualPoint(0, 0);
    private VirtualPoint point;
    private double length;
    
    public Vector(VirtualPoint p)
    {
        this.point = p;
        this.length = (origin.dist(p));
    }

    public Vector(double x, double y)
    {
        this(new VirtualPoint(x, y));
    }

    public double length()
    {
        return this.length;
    }

    public double dotProduct(Vector that)
    {
        return this.point.X() * that.point.X() + this.point.Y() * that.point.Y();
    }

    // public double angle(Vector that)
    // {
    //     return Math.acos(this.dotProduct(that) / (this.length() * that.length()));
    // }

    public boolean hasRightAngle(Vector that)
    {
        return MathUtil.areEqual(this.dotProduct(that), 0);
    }

    public double X() { return this.point.X(); }

    public double Y() { return this.point.Y(); }
}
