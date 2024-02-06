public class Path 
{
    Ponto[] pontos;
    public Path(Ponto[] pontos)
    {
        if (pontos.length < 2)
        {
            System.out.println("iv");
            System.exit(0);
        }
        this.pontos = pontos;
    }

    public double dist()
    {
        double result = 0;
        for (int i = 1; i < pontos.length; i++)
            result += pontos[i - 1].dist(pontos[i]);
        return result;
    }
}
