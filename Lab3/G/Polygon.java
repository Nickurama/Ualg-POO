/**
 * Represents an immutable simple polygon
 * 
 * @author Diogo Fonseca a79858
 * @version 21/02/2024
 *  
 * @inv sides are the sides of the polygon
 * @inv points are the vertices of the polygon
 */
public class Polygon
{
    private static final String ERROR_MESSAGE = "Poligono:vi";
    private LineSegment[] sides;
    private Point[] points;

    /**
     * Initializes a polygon
     * @param points the vertices of the polygon
     * @pre points must contain at least 3 points
     * @pre points must generate valid sides (that don't collide)
     */
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

    /**
     * generates the segments from the given points, representing the sides of the polygon
     * @param points the points that contain the vertices of the polygon
     * @return segments generated from the order of the given points
     */
    private LineSegment[] generateSegments(Point[] points)
    {
        LineSegment[] segments = new LineSegment[points.length];
        for (int i = 1; i < points.length; i++)
            segments[i - 1] = new LineSegment(points[i - 1], points[i]);
        segments[points.length - 1] = new LineSegment(points[points.length - 1], points[0]);
        return segments;
    }

    /**
     * Checks if there are any collinear points in the generated segments
     * @param points the points that contain the vertices of the polygon
     * @param segments the segments generated from the vertices
     * @return if there are any collinear (invalid) points
     */
    private boolean arePointsCollinear(Point[] points, LineSegment[] segments)
    {
        for (int i = 0; i < points.length; i++)
            if (segments[i].isCollinear(points[(i + 2) % points.length]))
                return true;
        return false;        
    }

    /**
     * Checks if any segments are colliding (intersecting eachother)
     * @param segments the segments to check the intersections of
     * @return if there is any collision within the segments
     */
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

    /**
     * Checks if the polygon is intercected by a segment
     * @param that the segment to check intercection with
     * @return if the polygon is intercected by the segment
     */
    public boolean intercepts(LineSegment that)
    {
        for (LineSegment side : sides)
            if (side.intersects(that))
                return true;
        return false;
    }

    /**
     * Returns true if a polygon intercepts another one
     * @param that the polygon to test collision with
     * @return if the polygon intercepts the other
     */
    public boolean intercepts(Polygon that)
    {
        for (LineSegment segment : this.sides)
            if (that.intercepts(segment))
                return true;
        return false;
    }

    /**
     * Calculates the perimeter of the polygon
     * @return the perimeter of the polygon
     */
    public double perimeter()
    {
        double result = 0;
        for (LineSegment side : sides)
            result += side.length();
        return result;
    }
}
