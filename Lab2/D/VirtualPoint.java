import java.util.Scanner;

public class VirtualPoint
{
    double x, y;
    public VirtualPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public VirtualPoint copy()
    {
        return new VirtualPoint(this.x, this.y);
    }

    public static VirtualPoint[] copyArray(VirtualPoint[] array)
    {
        VirtualPoint[] result = new VirtualPoint[array.length];
        for (int i = 0; i < array.length; i++)
            result[i] = array[i].copy();
        return result;
    }

    public static VirtualPoint getPointFromInput(Scanner reader)
    {
        return new VirtualPoint(reader.nextDouble(), reader.nextDouble());
    }

    public double dist(VirtualPoint that)
    {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean equals(VirtualPoint that)
    {
        return MathUtil.areEqual(this.x, that.x) && MathUtil.areEqual(this.y, that.y);
    }

    public double getX() { return this.x; }

    public double getY() { return this.y; }
}
