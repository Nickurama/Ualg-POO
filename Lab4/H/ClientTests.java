import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClientTests
{
    @Test
    public void ShouldTakePolygonAsInput()
    {
        // Arrange
        String input = "Poligono 4 5 5 8 6 8 7 5 7\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input);
        String expected = "Polígono de 4 vértices: [(5,5), (8,6), (8,7), (5,7)]\r\n";

        // Act
        try
        {
            Client.main(null);
        }
        catch (Exception e) { }
        String output = os.toString();

        // Assert
        assertTrue(output.equals(expected));
    }

    @Test
    public void ShouldTakeTrianglesAsInput()
    {
        // Arrange
        String input = "Triangulo 3 7 1 9 1 9 3\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input);
        String expected = "Triângulo: [(7,1), (9,1), (9,3)]\r\n";

        // Act
        try
        {
            Client.main(null);
        }
        catch (Exception e) { }
        String output = os.toString();

        // Assert
        assertTrue(output.equals(expected));
    }

    @Test
    public void ShouldTakeRectanglesAsInput()
    {
        // Arrange
        String input = "Retangulo 4 1 1 1 2 4 2 4 1\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input);
        String expected = "Retângulo: [(1,1), (1,2), (4,2), (4,1)]\r\n";

        // Act
        try
        {
            Client.main(null);
        }
        catch (Exception e) { }
        String output = os.toString();

        // Assert
        assertTrue(output.equals(expected));
    }

    @Test
    public void ShouldTakeSquareAsInput()
    {
        // Arrange
        String input = "Quadrado 4 1 1 1 2 2 2 2 1\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input);
        String expected = "Quadrado: [(1,1), (1,2), (2,2), (2,1)]\r\n";

        // Act
        try
        {
            Client.main(null);
        }
        catch (Exception e) { }
        String output = os.toString();

        // Assert
        assertTrue(output.equals(expected));
    }

    @Test
    public void ShouldBeCaseInsensitive()
    {
        // Arrange
        String input = "QuAdRaDo 4 1 1 1 2 2 2 2 1\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input);
        String expected = "Quadrado: [(1,1), (1,2), (2,2), (2,1)]\r\n";

        // Act
        try
        {
            Client.main(null);
        }
        catch (Exception e) { }
        String output = os.toString();

        // Assert
        assertTrue(output.equals(expected));
    }
}
