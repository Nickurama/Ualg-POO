package src;

public class Rectangle extends Polygon
{
    private static final String ERROR_MESSAGE = "Poligono:vi";

    public Rectangle(Point[] points)
    {
        super(points);

        if (points.length != 4)
            Error.terminateProgram(ERROR_MESSAGE);
        
        if (!allAnglesAreRightAngles())
            Error.terminateProgram(ERROR_MESSAGE);
    }

    private boolean allAnglesAreRightAngles()
    {
        if (this.sides[0].line().isPerpendicular(this.sides[1].line()) &&
            this.sides[0].line().isPerpendicular(this.sides[3].line()) &&
            this.sides[1].line().isPerpendicular(this.sides[2].line()))
            return true;
        return false;
    }
}
