public class BoundingBox
{
    Point min;
    Point max;

    public BoundingBox(Point[] points)
    {
        if (points.length == 0)
            Error.terminateProgram("BoundingBox::BoundingBox error: points should be greater than 0");
        
        min = points[0];
        max = points[0];

        for (Point p : points)
            addPoint(p);
        System.out.println("(" + min.getX() + "," + min.getY() + "), (" + max.getX() + "," + max.getY() + ")");
    }

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

    public boolean intercepts(BoundingBox that)
    {
        boolean interceptsX = (this.min.getX() < that.max.getX() &&
                                this.min.getX() > that.min.getX())
                                ||
                                (this.max.getX() < that.max.getX() &&
                                this.max.getX() > that.min.getX());
        
        boolean interceptsY = (this.min.getY() < that.max.getY() &&
                                this.min.getY() > that.min.getY())
                                ||
                                (this.max.getY() < that.max.getY() &&
                                this.max.getY() > that.min.getY());
        
        return interceptsX && interceptsY;
    }
}
