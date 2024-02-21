public class Path 
{
    private final String ERROR_MESSAGE = "Trajetoria:vi";
    private LineSegment[] segments;
    private Point[] points;

    public Path(Point[] points)
    {
        if (points.length < 2)
            Error.terminateProgram(ERROR_MESSAGE);
        this.points = Point.copyArray(points);
        segments = generateSegments(points);
    }

    private LineSegment[] generateSegments(Point[] points)
    {
        LineSegment[] segments = new LineSegment[points.length - 1];
        for (int i = 1; i < points.length; i++)
            segments[i - 1] = new LineSegment(points[i - 1], points[i]);
        return segments;
    }

    public double dist()
    {
        double result = 0;
        for (int i = 1; i < points.length; i++)
            result += points[i - 1].dist(points[i]);
        return result;
    }

    public boolean intersects(Polygon[] polygons)
    {
        for(Polygon poly : polygons)
            for (LineSegment segment : segments)
                if (poly.isInterceptedBy(segment))
                    return true;
        return false;
    }
}
