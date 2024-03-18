import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClientTests
{
    @Test
    public void ShouldTakePolygonAsInput()
    {
        // Arrange
        String input0 = "Poligono 4 1 2 5 6 8 7 12 14\n";
        String input1 = "-1 3";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Poligono de 4 vertices: [(0,5), (4,9), (7,10), (11,17)]";

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
        String input0 = "Triangulo 2 1 4 1 3 4\n";
        String input1 = "2 -1\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Triangulo: [(4,0), (6,0), (5,3)]";

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
        String input0 = "Retangulo 1 1 3 1 3 5 1 5\n";
        String input1 = "5 7\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Retangulo: [(6,8), (8,8), (8,12), (6,12)]";

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
        String input0 = "Quadrado 1 1 1 2 2 2 2 1\n";
        String input1 = "10 10\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Quadrado: [(11,11), (11,12), (12,12), (12,11)]";

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
        String input0 = "QuAdRaDo 1 1 1 2 2 2 2 1\n";
        String input1 = "10 10\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Quadrado: [(11,11), (11,12), (12,12), (12,11)]";

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
