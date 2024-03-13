package src;

/**
 * Represents a square
 * A square is a rectangle whose sides are
 * all the same length
 * 
 * @author Diogo Fonseca a79858
 * @version 13/03/2024
 */
public class Square extends Rectangle
{
    private final String ERROR_MESSAGE = "Quadrado:vi";

    /**
     * Initializes a square
     * @param points the points that make the square
     * 
     * @pre all sides must have equal length
     */
    public Square(Point[] points)
    {
        super(points);

        if (!areAllSidesSameLength())
            Error.terminateProgram(ERROR_MESSAGE);
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
}
