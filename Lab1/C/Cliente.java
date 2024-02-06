import java.util.Scanner;

public class Cliente
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        
        int n = reader.nextInt();
        Ponto[] pontos = new Ponto[n];
        for (int i = 0; i < n; i++)
            pontos[i] = Ponto.getPointFromInput(reader);

        reader.close();
            
        Path path = new Path(pontos);
        System.out.println(String.format("%.2f", path.dist()));
    }
}
