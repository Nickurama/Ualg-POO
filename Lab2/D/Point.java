import java.util.Scanner;

public class Point extends VirtualPoint
{
    private static final String ERROR_MESSAGE = "Ponto:vi";

    public Point(double x, double y)
    {
        super(x, y);
        if (x < 0 || y < 0)
            Error.terminateProgram(ERROR_MESSAGE);
        this.x = x;
        this.y = y;
    }

    public Point copy()
    {
        return new Point(this.x, this.y);
    }

    public static Point[] copyArray(Point[] array)
    {
        Point[] result = new Point[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = array[i].copy();
        return result;
    }

    public static Point getPointFromInput(Scanner reader)
    {
        return new Point(reader.nextDouble(), reader.nextDouble());
    }
}
