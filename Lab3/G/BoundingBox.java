/**
 * Creates a box of bounds, useful for knowing the bounds of a bunch of points
 * 
 * @author Diogo Fonseca a79858
 * @version 04/03/2024
 * 
 * @inv min is the minimum point of the box that bounds the points (lower left corner)
 * @inv max is the maximum point of the box that bounds the points (upper right corner)
 */
public class BoundingBox
{
    // private Point min;
    // private Point max;
    double minX, maxX, minY, maxY;

    /**
     * Initializes a bounding box
     * @param points the points to be bounded
     */
    public BoundingBox(Point[] points)
    {
        if (points.length == 0)
            Error.terminateProgram("BoundingBox::BoundingBox error: points should be greater than 0");
        
        // this.min = points[0].copy();
        // this.max = points[0].copy();
        this.minX = points[0].getX();
        this.maxX = points[0].getX();
        this.minY = points[0].getY();
        this.maxY = points[0].getY();

        for (Point p : points)
            addPoint(p);
    }

    /**
     * Adds a point to the box, ensuring that the box still bounds all points
     * @param p the point to be added
     */
    private void addPoint(Point p)
    {
        // if (p.getX() < this.min.getX())
        //     this.min = new Point(p.getX(), this.min.getY());
        // else if (p.getX() > this.max.getX())
        //     this.max = new Point(p.getX(), this.max.getY());
        
        // if (p.getY() < this.min.getY())
        //     this.min = new Point(this.min.getX(), p.getY());
        // else if (p.getY() > max.getY())
        //     this.max = new Point(this.max.getX(), p.getY());
        this.minX = Math.min(this.minX, p.getX());
        this.maxX = Math.max(this.maxX, p.getX());
        this.minY = Math.min(this.minY, p.getY());
        this.maxY = Math.max(this.maxY, p.getY());
    }

    /**
     * Checks if two bounding boxes intercept eachother
     * @param that the bounding box to check interception with
     * @return if the two bounding boxes intercept
     */
    public boolean intercepts(BoundingBox that)
    {
        // boolean minInterceptsX = ((this.min.getX() < that.max.getX()) &&
        //                         (this.min.getX() > that.min.getX()))
        //                         ||
        //                         ((that.min.getX() < this.max.getX()) &&
        //                         (that.min.getX() > this.min.getX()));
        // boolean maxInterceptsX = ((this.max.getX() < that.max.getX()) &&
        //                         (this.max.getX() > that.min.getX()))
        //                         ||
        //                         ((that.max.getX() < this.max.getX()) &&
        //                         (that.max.getX() > this.min.getX()));
        // boolean interceptsX = minInterceptsX || maxInterceptsX;

        // boolean minInterceptsY = ((this.min.getY() < that.max.getY()) &&
        //                         (this.min.getY() > that.min.getY()))
        //                         ||
        //                         ((that.min.getY() < this.max.getY()) &&
        //                         (that.min.getY() > this.min.getY()));
        // boolean maxInterceptsY = ((this.max.getY() < that.max.getY()) &&
        //                         (this.max.getY() > that.min.getY()))
        //                         ||
        //                         ((that.max.getY() < this.max.getY()) &&
        //                         (that.max.getY() > this.min.getY())); 
        // boolean interceptsY = minInterceptsY || maxInterceptsY;
        boolean minInterceptsX = ((this.minX < that.maxX) &&
                                (this.minX > that.minX))
                                ||
                                ((that.minX < this.maxX) &&
                                (that.minX > this.minX));
        boolean maxInterceptsX = ((this.maxX < that.maxX) &&
                                (this.maxX > that.minX))
                                ||
                                ((that.maxX < this.maxX) &&
                                (that.maxX > this.minX));
        boolean interceptsX = minInterceptsX || maxInterceptsX;

        boolean minInterceptsY = ((this.minY < that.maxY) &&
                                (this.minY > that.minY))
                                ||
                                ((that.minY < this.maxY) &&
                                (that.minY > this.minY));
        boolean maxInterceptsY = ((this.maxY < that.maxY) &&
                                (this.maxY > that.minY))
                                ||
                                ((that.maxY < this.maxY) &&
                                (that.maxY > this.minY)); 
        boolean interceptsY = minInterceptsY || maxInterceptsY;

        // boolean overlapsX = MathUtil.areEqual(this.min.getX(), that.min.getX()) && MathUtil.areEqual(this.max.getX(), that.max.getX());
        // boolean overlapsY = MathUtil.areEqual(this.min.getY(), that.min.getY()) && MathUtil.areEqual(this.max.getY(), that.max.getY());
        boolean overlapsX = MathUtil.areEqual(this.minX, that.minX) && MathUtil.areEqual(this.maxX, that.maxX);
        boolean overlapsY = MathUtil.areEqual(this.minY, that.minY) && MathUtil.areEqual(this.maxY, that.maxY);

        if (overlapsX)
            interceptsX = true;
        if (overlapsY)
            interceptsY = true;

        return interceptsX && interceptsY;
    }
}
