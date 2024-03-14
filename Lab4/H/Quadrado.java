

/**
 * Represents a square
 * A square is a rectangle whose sides are
 * all the same length
 * 
 * @author Diogo Fonseca a79858
 * @version 13/03/2024
 */
public class Quadrado extends Retangulo
{
    private final String ERROR_MESSAGE = "Quadrado:vi";

    /**
     * Initializes a square
     * @param points the points that make the square
     * 
     * @pre all sides must have equal length
     */
    public Quadrado(Point[] points)
    {
        super(points);

        if (!areAllSidesSameLength())
            Error.terminateProgram(ERROR_MESSAGE);
    }

    public Quadrado(String str)
    {
        this(Point.stringToArray(str));
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
