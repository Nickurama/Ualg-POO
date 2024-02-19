public class LineSegment
{
    private static final String ERROR_MESSAGE = "Segmento:vi";
    private Point point1, point2;
    private Line line;

    public LineSegment(Point a, Point b)
    {
        this.point1 = a.copy();
        this.point2 = b.copy();
        this.line = new Line(this.point1, this.point2);
        if (a.equals(b))
            Error.terminateProgram(ERROR_MESSAGE);
    }

    public boolean intersects(LineSegment that)
    {
        if (this.line.isParalel(that.line))
        {
            if (this.line.equals(that.line))
                return this.containsX(that.point1.getX()) || this.containsX(that.point2.getX()) ||
                    that.containsX(this.point1.getX()) || that.containsX(this.point2.getX());
            else
                return false;
        }
        double intersectionX = this.line.calcIntersectX(that.line);
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