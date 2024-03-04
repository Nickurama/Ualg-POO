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
    private Point min;
    private Point max;

    /**
     * Initializes a bounding box
     * @param points the points to be bounded
     */
    public BoundingBox(Point[] points)
    {
        if (points.length == 0)
            Error.terminateProgram("BoundingBox::BoundingBox error: points should be greater than 0");
        
        min = points[0].copy();
        max = points[0].copy();

        for (Point p : points)
            addPoint(p);
    }

    /**
     * Adds a point to the box, ensuring that the box still bounds all points
     * @param p the point to be added
     */
    private void addPoint(Point p)
    {
        if (p.getX() < this.min.getX())
            this.min = new Point(p.getX(), this.min.getY());
        else if (p.getX() > this.max.getX())
            this.max = new Point(p.getX(), this.max.getY());
        
        if (p.getY() < this.min.getY())
            this.min = new Point(this.min.getX(), p.getY());
        else if (p.getY() > max.getY())
            this.max = new Point(this.max.getX(), p.getY());
    }

    /**
     * Checks if two bounding boxes intercept eachother
     * @param that the bounding box to check interception with
     * @return if the two bounding boxes intercept
     */
    public boolean intercepts(BoundingBox that)
    {
        boolean interceptsX = MathUtil.isLessOrEqualThan(this.min.getX(), that.max.getX()) &&
                                MathUtil.isGreaterOrEqualThan(this.min.getX(), that.min.getX())
                                ||
                                (MathUtil.isLessOrEqualThan(this.max.getX(), that.max.getX()) &&
                                MathUtil.isGreaterOrEqualThan(this.max.getX(), that.min.getX()));

        boolean interceptsY = (MathUtil.isLessOrEqualThan(this.min.getY(), that.max.getY()) &&
                                MathUtil.isGreaterOrEqualThan(this.min.getY(), that.min.getY()))
                                ||
                                (MathUtil.isLessOrEqualThan(this.max.getY(), that.max.getY()) &&
                                MathUtil.isGreaterOrEqualThan(this.max.getY(), that.min.getY())); 
        
        return interceptsX && interceptsY;
    }
}
