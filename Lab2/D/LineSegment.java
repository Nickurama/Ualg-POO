public class LineSegment
{
    private static final String ERROR_MESSAGE = "Segmento:vi";
    private Point point1, point2;

    public LineSegment(Point a, Point b)
    {
        if (a.equals(b))
            Error.terminateProgram(ERROR_MESSAGE);
        this.point1 = a;
        this.point2 = b;
    }

    public boolean intersects(LineSegment that)
    {
        Line a = new Line(this);
        Line b = new Line(that);
        if (a.isParalel(b))
        {
            if (a.equals(b))
                return this.containsX(that.point1.getX()) || this.containsX(that.point2.getX()) ||
                    that.containsX(this.point1.getX()) || that.containsX(this.point2.getX());
            else
                return false;
        }
        double intersectionX = a.calcIntersectX(b);
        return this.containsX(intersectionX) && that.containsX(intersectionX);
    }

    private boolean containsX(double x)
    {
        return x > Math.min(this.point1.getX(), this.point2.getX()) &&
            x < Math.max(this.point1.getX(), this.point2.getX());
    }

    public double dist()
    {
        return point1.dist(point2);
    }

    public Point getFirstPoint() { return this.point1; }

    public Point getSecondPoint() { return this.point2; }
}