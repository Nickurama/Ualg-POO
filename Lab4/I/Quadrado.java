/**
 * Represents a square
 * A square is a rectangle whose sides are
 * all the same length
 * 
 * @author Diogo Fonseca a79858
 * @version 16/03/2024
 */
public class Quadrado extends Retangulo
{
    private final String ERROR_MESSAGE = "Quadrado:vi";

    /**
     * Initializes a square
     * @param points the points that make the square
     * @pre all sides must have equal length
     */
    public Quadrado(Point[] points)
    {
        super(points);

        if (!areAllSidesSameLength())
            Error.terminateProgram(ERROR_MESSAGE);
    }

    /**
     * Initializes a square
     * parses a string to a square
     * @param str the string to parse into a square
     * @pre all sides must have equal length
     */
    public Quadrado(String str)
    {
        this(Point.parseToArray(str, NUM_SIDES));
    }

    /**
     * Checks if all the sides have the same length
     * @return if all the sides have the same length
     */
    private boolean areAllSidesSameLength()
    {
        double len = this.sides[0].length();
        for (int i = 1; i < sides.length; i++)
            if (!MathUtil.areEqual(this.sides[i].length(), len))
                return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "Quadrado: " + VirtualPoint.arrayToString(this.vertices);
    }
}
