package src;

/**
 * Represents a triangle
 * A triangle is a polygon with 3 sides
 * 
 * @author Diogo Fonseca a79858
 * @version 13/03/2024
 */
public class Triangle extends Polygon
{
    private final String ERROR_MESSAGE = "Triângulo:vi";

    /**
     * Initializes a triangle
     * @param points the points that make the triangle
     * 
     * @pre points.length = 3
     */
    public Triangle(Point[] points)
    {
        super(points);

        if (this.sides.length != 3)
            Error.terminateProgram(ERROR_MESSAGE);
    }
}
