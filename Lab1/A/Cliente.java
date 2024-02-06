import java.util.Scanner;

public class Cliente
{
    public static void main(String[] args) throws Exception
    {
        Scanner reader = new Scanner(System.in);

        Ponto p1 = new Ponto(reader.nextDouble(), reader.nextDouble());
        Ponto p2 = new Ponto(reader.nextDouble(), reader.nextDouble());

        reader.close();

        System.out.println(p1.dist(p2));
    }
}
