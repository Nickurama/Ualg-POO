public class Polygon
{
    private static final String ERROR_MESSAGE = "Poligono:vi";
    private LineSegment[] sides;
    private Point[] points;

    public Polygon(Point[] points)
    {
        if (points.length < 3)
            Error.terminateProgram(ERROR_MESSAGE);
        
        Point[] vertices = Point.copyArray(points);  
        LineSegment[] segments = generateSegments(vertices);

        if (arePointsCollinear(vertices, segments) || doSegmentsCollide(segments))
            Error.terminateProgram(ERROR_MESSAGE);
        
        this.points = vertices;
        this.sides = segments;
    }

    private LineSegment[] generateSegments(Point[] points)
    {
        LineSegment[] segments = new LineSegment[points.length];
        for (int i = 1; i < points.length; i++)
            segments[i - 1] = new LineSegment(points[i - 1], points[i]);
        segments[points.length - 1] = new LineSegment(points[points.length - 1], points[0]);
        return segments;
    }

    private boolean arePointsCollinear(Point[] points, LineSegment[] segments)
    {
        for (int i = 0; i < points.length; i++)
            if (segments[i].isCollinear(points[(i + 2) % points.length]))
                return true;
        return false;        
    }

    private boolean doSegmentsCollide(LineSegment[] segments)
    {
        for (int i = 2; i < segments.length - 1; i++)
            for (int j = 0; j < (i - 1); j++)
                if (segments[i].intersects(segments[j]))
                    return true;
        for (int j = 1; j < segments.length - 2; j++)
            if (segments[segments.length - 1].intersects(segments[j]))
                return true;
        
        return false;
    }

    public boolean isInterceptedBy(LineSegment that)
    {
        for (LineSegment side : sides)
            if (side.intersects(that))
                return true;
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
