package src;

public class Triangle extends Polygon
{
    private final String ERROR_MESSAGE = "Triângulo:vi";

    public Triangle(Point[] points)
    {
        super(points);

        if (this.sides.length != 3)
            Error.terminateProgram(ERROR_MESSAGE);
    }
}
