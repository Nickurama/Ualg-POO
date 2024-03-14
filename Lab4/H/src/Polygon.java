package src;

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
    protected LineSegment[] sides;
    protected Point[] vertices;

    /**
     * Initializes a polygon
     * @param vertices the vertices of the polygon
     * @pre points must contain at least 3 points
     * @pre points must generate valid sides (that don't collide)
     */
    public Polygon(Point[] points)
    {
        if (points.length < 3)
            Error.terminateProgram(ERROR_MESSAGE);
        
        Point[] verticesGen = Point.copyArray(points);  
        LineSegment[] segments = generateSegments(verticesGen);

        if (isAnyGeneratedPointCollinear(verticesGen, segments) || doSegmentsCollide(segments))
            Error.terminateProgram(ERROR_MESSAGE);
        
        this.vertices = verticesGen;
        this.sides = segments;
    }

    // public Polygon(String str)
    // {
    //     this(VirtualPoint.stringToArray(str));
    // }

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
    private static boolean isAnyGeneratedPointCollinear(Point[] points, LineSegment[] segments)
    {
        for (int i = 0; i < points.length; i++)
            if (segments[i].line().isCollinear(points[(i + 2) % points.length]))
                return true;
        return false;        
    }

    /**
     * Checks if any segments are colliding (intersecting eachother)
     * @param segments the segments to check the intersections of
     * @return if there is any collision within the segments
     */
    private static boolean doSegmentsCollide(LineSegment[] segments)
    {
        for (int i = 2; i < segments.length - 1; i++)
            for (int j = 0; j < (i - 1); j++)
                if (segments[i].intercepts(segments[j]))
                    return true;
        for (int j = 1; j < segments.length - 2; j++)
            if (segments[segments.length - 1].intercepts(segments[j]))
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
            if (side.intercepts(that))
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

    @Override
    public String toString()
    {
        return "Polígono de " + this.vertices.length + " vértices: " + VirtualPoint.arrayToString(this.vertices);
    }

    @Override
    public final boolean equals(Object other)
    {
        if (other == this) return true;
        if (other == null) return false;
        if (!Polygon.class.isInstance(other)) return false; // if not Polygon or child of Polygon
        Polygon that = (Polygon) other;
        return this.isPolygonEqual(that);
    }
    
    private boolean isPolygonEqual(Polygon that)
    {
        // linear Algorithm that checks if two polygons are equal
        if (this.vertices.length != that.vertices.length) return false;
        int startInd = that.findPoint(this.vertices[0]);
        if (startInd < 0) return false;

        int direction = 1;
        Point next = that.vertices[Math.floorMod((startInd + 1), that.vertices.length)];
        Point previous = that.vertices[Math.floorMod((startInd - 1), that.vertices.length)];

        if (this.vertices[1].equals(next)) direction = 1;
        else if (this.vertices[1].equals(previous)) direction = -1;
        else return false;

        for (int i = 2; i < this.vertices.length; i++)
            if (!this.vertices[i].equals(that.vertices[Math.floorMod((startInd + (i * direction)), that.vertices.length)]))
                return false;
        return true;
    }

    private int findPoint(Point p)
    {
        for (int i = 0; i < this.sides.length; i++)
            if (p.equals(this.vertices[i]))
                return i;
        return -1;
    }
}
