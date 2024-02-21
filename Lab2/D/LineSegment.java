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

    public boolean isCollinear(Point that)
    {
        return this.line.contains(that);
    }

    public boolean intersects(LineSegment that)
    {
        if (this.line.isParalel(that.line))
        {
            if (this.line.equals(that.line))
                return this.containsPointOnSegment(that.point1) || this.containsPointOnSegment(that.point2) ||
                        that.containsPointOnSegment(this.point1) || that.containsPointOnSegment(this.point2);
            return false;
        }
        VirtualPoint intersection = this.line.calcIntersect(that.line);

        return this.containsPointOnSegment(intersection) && that.containsPointOnSegment(intersection);
    }

    private boolean containsPointOnSegment(VirtualPoint pointOnSegment)
    {
        double minX = Math.min(this.point1.getX(), this.point2.getX());
        double maxX = Math.max(this.point1.getX(), this.point2.getX());
        double minY = Math.min(this.point1.getY(), this.point2.getY());
        double maxY = Math.max(this.point1.getY(), this.point2.getY());
        boolean containsX = (pointOnSegment.getX() > minX && pointOnSegment.getX() < maxX) ||
                            (MathUtil.areEqual(pointOnSegment.getX(), minX) ||
                            MathUtil.areEqual(pointOnSegment.getX(), maxX));
        boolean containsY = (pointOnSegment.getY() > minY && pointOnSegment.getY() < maxY) ||
                            (MathUtil.areEqual(pointOnSegment.getY(), minY) ||
                            MathUtil.areEqual(pointOnSegment.getY(), maxY));
        return containsX && containsY;
    }

    public double dist()
    {
        return point1.dist(point2);
    }

    public Point getFirstPoint() { return this.point1; }

    public Point getSecondPoint() { return this.point2; }
}