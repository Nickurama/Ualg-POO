public class Polygon
{
    private static final String ERROR_MESSAGE = "Poligono:vi";
    private LineSegment[] sides;
    private Point[] points;

    public Polygon(Point[] points)
    {
        this.points = points;
        if (points.length < 3)
            Error.terminateProgram(ERROR_MESSAGE);
        
        sides = new LineSegment[points.length];

        for (int i = 1; i < points.length; i++)
            addSide(points[i - 1], points[i], i - 1);
        addSide(points[points.length - 1], points[0], points.length - 1);
    }

    private void addSide(Point lastPoint, Point newPoint, int index)
    {
        if (index < 1)
        {
            sides[index] = new LineSegment(lastPoint, newPoint);
            return;
        }

        Line lastLine = new Line(sides[index - 1]);
        if (lastLine.intersects(newPoint))
            Error.terminateProgram(ERROR_MESSAGE);
        
        LineSegment segment = new LineSegment(lastPoint, newPoint);
        if (this.isInterceptedBy(segment))
            Error.terminateProgram(ERROR_MESSAGE);
        
        sides[index] = segment;
    }

    public boolean isInterceptedBy(LineSegment that)
    {
        for (LineSegment side : sides) // does it work when the rest of the array is empty?
        {
            if (side == null)
                return false;

            if (side.intersects(that))
                return true;
        }
        return false;
    }

    public double perimeter()
    {
        double result = 0;
        for (LineSegment side : sides)
            result += side.dist();
        return result;
    }

    public Point[] getPoints() { return this.points; }
    
    public LineSegment[] getSides() { return this.sides; }
}
