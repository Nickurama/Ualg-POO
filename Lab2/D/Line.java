public class Line
{
    private final String ERROR_MESSAGE = "Reta:vi";
    private double coefficientX;
    private double coefficientY;
    private double constant;

    public Line(Point a, Point b)
    {
        if (a.equals(b))
            Error.terminateProgram(ERROR_MESSAGE);
        
        this.coefficientX = a.getY() - b.getY();
        this.coefficientY = b.getX() - a.getX();
        this.constant = a.getX() * b.getY() - b.getX() * a.getY();
    }

    public boolean contains(Point point)
    {
        return MathUtil.areEqual(calcExpr(point), 0);
    }

    private double calcExpr(Point point)
    {
        return point.getX() * this.coefficientX + point.getY() * this.coefficientY + constant;
    }

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

    public boolean isParalel(Line that)
    {
        if (MathUtil.areEqual(this.coefficientX, that.coefficientX) &&
            MathUtil.areEqual(this.coefficientY, that.coefficientY))
            return true;
        else if (MathUtil.areEqual(this.coefficientX, - that.coefficientX) &&
                MathUtil.areEqual(this.coefficientY, - that.coefficientY))
            return true;
        return false;
    }

    public boolean equals(Line that)
    {
        return MathUtil.areEqual(this.coefficientX, that.coefficientX) &&
                MathUtil.areEqual(this.coefficientY, that.coefficientY) &&
                MathUtil.areEqual(this.constant, that.constant);
    }
}
