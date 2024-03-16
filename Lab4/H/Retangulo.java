/**
 * Represents a rectangle
 * A rectangle is a polygon with 4 sides and every side has
 * an inner angle of 90 degrees
 * 
 * @author Diogo Fonseca a79858
 * @version 16/03/2024
 */
public class Retangulo extends Poligono
{
    private static final String ERROR_MESSAGE = "Retangulo:vi";
    public static final int NUM_SIDES = 4;

    /**
     * Initializes a rectangle
     * @param points the points that make the rectangle
     * 
     * @pre points.length = 4
     * @pre all angles are right angles
     */
    public Retangulo(Point[] points)
    {
        super(points);

        if (points.length != NUM_SIDES)
            Error.terminateProgram(ERROR_MESSAGE);
        
        if (!allAnglesAreRightAngles())
            Error.terminateProgram(ERROR_MESSAGE);
    }

    /**
     * Initializes a rectangle
     * parses a string into a rectangle
     * @param str the string to parse into a rectangle
     * 
     * @pre must have 4 points
     * @pre all angles are right angles
     */
    public Retangulo(String str)
    {
        this(Point.parseToArray(str, NUM_SIDES));
    }

    /**
     * Checks if all inner angles of the rectangle are right angles
     * @return if all the inner angles of the rectangle are right angles
     */
    private boolean allAnglesAreRightAngles()
    {
        if (this.sides[0].line().isPerpendicular(this.sides[1].line()) &&
            this.sides[0].line().isPerpendicular(this.sides[3].line()) &&
            this.sides[1].line().isPerpendicular(this.sides[2].line()))
            return true;
        return false;
    }

    @Override
    public String toString()
    {
        return "Retângulo: " + VirtualPoint.arrayToString(this.vertices);
    }
}
