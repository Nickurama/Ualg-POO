public class Line
{
    private final String ERROR_MESSAGE = "Reta:vi";
    // private Point point1, point2;
    private double slope;
    private double offset;

    public Line(Point a, Point b)
    {
        if (a.equals(b))
            Error.terminateProgram(ERROR_MESSAGE);
        // this.point1 = a;
        // this.point2 = b;
        this.slope = (b.getY() - a.getY()) / (b.getX() - a.getX());
        this.offset = a.getY() - this.slope * a.getX();
    }

    public Line(LineSegment segment)
    {
        this(segment.getFirstPoint(), segment.getSecondPoint());
    }

    public boolean intersects(Point that)
    {
        double fy = this.slope * that.getX() + this.offset;
        return MathUtil.areEqual(fy, that.getY());
    }

    public double calcIntersectX(Line that)
    {
        if (isParalel(that))
            Error.terminateProgram("Line.java tried to calculate the intersection of parallel lines (division by 0)");
        return (that.offset - this.offset) / (this.slope - that.slope);
    }

    public boolean isParalel(Line that)
    {
        return MathUtil.areEqual(this.slope, that.slope);
    }

    public boolean equals(Line that)
    {
        return MathUtil.areEqual(this.slope, that.slope) && MathUtil.areEqual(this.offset, that.offset);
    }
}
