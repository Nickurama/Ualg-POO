package src;

public class Square extends Rectangle
{
    private final String ERROR_MESSAGE = "Quadrado:vi";

    public Square(Point[] points)
    {
        super(points);

        if (!areAllSidesSameLength())
            Error.terminateProgram(ERROR_MESSAGE);
    }

    private boolean areAllSidesSameLength()
    {
        double len = this.sides[0].length();
        for (int i = 1; i < sides.length; i++)
            if (!MathUtil.areEqual(this.sides[i].length(), len))
                return false;
        return true;
    }
}
