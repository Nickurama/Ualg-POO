import java.util.Scanner;

public class Point
{
    private static final String ERROR_MESSAGE = "Ponto:vi";
    private double x, y;

    public Point(double x, double y)
    {
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

    public double dist(Point that)
    {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean equals(Point that)
    {
        return MathUtil.areEqual(this.x, that.x) && MathUtil.areEqual(this.y, that.y);
    }

    public double getX() { return this.x; }

    public double getY() { return this.y; }
}
