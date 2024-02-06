public class Ponto
{
    private double x, y;

    public Ponto(double x, double y)
    {
        if (x < 0 || y < 0)
        {
            System.out.println("iv");
            System.exit(0);
        }
        this.x = x;
        this.y = y;
    }

    public int dist(Ponto that)
    {
        double dx = this.x - that.getX();
        double dy = this.y - that.getY();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }

    public double getX() { return this.x; }

    public double getY() { return this.y; }
}
