/**
 * Represents an immutable line described in euclidean space.
 * Uses the general equation for a line in 2D space: ax + by + c = 0
 * 
 * @author Diogo Fonseca a79858
 * @version 23/02/2024
 * 
 * @inv coefficientX is immutable and set when line is created (represents the "a" coefficient)
 * @inv coefficientY is immutable and set when line is created (represents the "b" coefficient)
 * @inv constant is immutable and set when line is created (represents the "c" constant)
 * @inv containedPoint is a point contained in the line
 */
public class Line
{
    private final String ERROR_MESSAGE = "Reta:vi";
    private double coefficientX;
    private double coefficientY;
    private double constant;
    private Point containedPoint;

    /**
     * Initializes a line 
     * @param a first point contained in the line
     * @param b second point contained in the line
     * 
     * @pre a != b
     */
    public Line(Point a, Point b)
    {
        if (a.equals(b))
            Error.terminateProgram(ERROR_MESSAGE);
        
        this.coefficientX = a.getY() - b.getY();
        this.coefficientY = b.getX() - a.getX();
        this.constant = a.getX() * b.getY() - b.getX() * a.getY();
        this.containedPoint = a.copy();
    }

    /**
     * Checks if a point is contained within a line
     * @param point the point to be checked if the line contains
     * @return if the point is contained within the line
     */
    public boolean isCollinear(Point point)
    {
        return MathUtil.areEqual(calcExpr(point), 0);
    }

    /**
     * Plugs a point into the line equation
     * @param point the point to plug into the line equation
     * @return the result of the equation
     */
    private double calcExpr(Point point)
    {
        return point.getX() * this.coefficientX + point.getY() * this.coefficientY + constant;
    }

    /**
     * Calculates the point of intersection between the two lines
     * @param that the other line to check the intersection with
     * @pre the lines must not be paralel
     * @return the point that intersects the two lines
     */
    public VirtualPoint calcIntersect(Line that)
    {
        if (isParalel(that))
            Error.terminateProgram("Line.java tried to calculate the intersection of parallel lines (division by 0)");
        
        double x = (this.coefficientY * that.constant - that.coefficientY * this.constant) /
                    (this.coefficientX * that.coefficientY - that.coefficientX * this.coefficientY);
        double y = (that.coefficientX * this.constant - this.coefficientX * that.constant) /
                    (this.coefficientX * that.coefficientY - that.coefficientX * this.coefficientY);
        return new VirtualPoint(x, y);
    }

    /**
     * Checks if the lines are paralel
     * @param that the other line to check if is paralel with the current one
     * @return if the lines are paralel
     */
    public boolean isParalel(Line that)
    {
        return MathUtil.areEqual(this.coefficientX * that.coefficientY - that.coefficientX * this.coefficientY, 0);
    }

    /**
     * Checks if two lines are equivalent (if they describe the same line in space)
     * @param that the other line to compare with the current one
     * @return if the two lines are equivalent
     */
    public boolean equals(Line that)
    {
        return this.isParalel(that) && this.isCollinear(that.containedPoint);
    }
}
