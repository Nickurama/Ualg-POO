import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Point[] points = getPointsFromInput();
        Polygon poly = new Polygon(points);
        System.out.println((int)poly.perimeter());
    }

    private static Point[] getPointsFromInput()
    {
        Scanner reader = new Scanner(System.in);
        
        int n = reader.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++)
            points[i] = Point.getPointFromInput(reader);

        reader.close();
        return points;
    }
}
