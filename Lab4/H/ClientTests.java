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
        String expected = "Poligono de 4 vertices: [(5,5), (8,6), (8,7), (5,7)]\r\n";

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
        String input = "Triangulo 7 1 9 1 9 3\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input);
        String expected = "Triangulo: [(7,1), (9,1), (9,3)]\r\n";

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
        String input = "Retangulo 1 1 1 2 4 2 4 1\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input);
        String expected = "Retangulo: [(1,1), (1,2), (4,2), (4,1)]\r\n";

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
        String input = "Quadrado 1 1 1 2 2 2 2 1\n";
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
        String input = "QuAdRaDo 1 1 1 2 2 2 2 1\n";
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
