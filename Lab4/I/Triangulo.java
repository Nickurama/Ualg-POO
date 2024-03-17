/**
 * Represents a triangle
 * A triangle is a polygon with 3 sides
 * 
 * @author Diogo Fonseca a79858
 * @version 16/03/2024
 */
public class Triangulo extends Poligono
{
    private static final String ERROR_MESSAGE = "Triangulo:vi";
    public static final int NUM_SIDES = 3;

    /**
     * Initializes a triangle
     * @param points the points that make the triangle
     * 
     * @pre points.length = 3
     */
    public Triangulo(Point[] points)
    {
        super(points);

        if (this.sides.length != NUM_SIDES)
            Error.terminateProgram(ERROR_MESSAGE);
    }

    /**
     * Initializes a triangle
     * Parses a string into a triangle
     * @param str the string to turn into a triangle
     * 
     * @pre must have 3 points
     */
    public Triangulo(String str)
    {
        this(Point.parseToArray(str, NUM_SIDES));
    }

    @Override
    public String toString()
    {
        return "Triangulo: " + VirtualPoint.arrayToString(this.vertices);
    }
}
