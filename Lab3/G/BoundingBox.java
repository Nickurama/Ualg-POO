/**
 * Creates a box of bounds, useful for knowing the bounds of a bunch of points
 * 
 * @author Diogo Fonseca a79858
 * @version 04/03/2024
 * 
 * @inv minX the minimum x value of the box
 * @inv maxX the maximum x value of the box
 * @inv minY the minimum y value of the box
 * @inv maxY the maximum y value of the box
 */
public class BoundingBox
{
    double minX, maxX, minY, maxY;

    /**
     * Initializes a bounding box
     * @param points the points to be bounded
     */
    public BoundingBox(Point[] points)
    {
        if (points.length == 0)
            Error.terminateProgram("BoundingBox::BoundingBox error: points should be greater than 0");
        
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
        boolean interceptsX = true;
        boolean interceptsY = true;

        if (MathUtil.isLessOrEqualThan(this.maxX, that.minX) || MathUtil.isGreaterOrEqualThan(this.minX, that.maxX))
            interceptsX = false;

        if (MathUtil.isLessOrEqualThan(this.maxY, that.minY) || MathUtil.isGreaterOrEqualThan(this.minY, that.maxY))
            interceptsY = false;

        return interceptsX && interceptsY;
    }
}
