import java.util.Scanner;

public class Ponto
{
    private double x, y;

    public Ponto(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public static Ponto getPointFromInput(Scanner reader)
    {
        return new Ponto(reader.nextDouble(), reader.nextDouble());
    }

    public double dist(Ponto that)
    {
        double dx = this.x - that.getX();
        double dy = this.y - that.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double getX() { return this.x; }

    public double getY() { return this.y; }
}
