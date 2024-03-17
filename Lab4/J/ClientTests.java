import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClientTests
{
    @Test
    public void ShouldTakePolygonAsInput()
    {
        // Arrange
        String input0 = "Poligono 5 1 1 1 3 3 3 2 2 3 1\n";
        String input1 = "-90 2 2";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Poligono de 5 vertices: [(1,3), (3,3), (3,1), (2,2), (1,1)]";

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
        String input1 = "180\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Triangulo: [(4,3), (2,3), (3,0)]";

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
        String input1 = "90\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Retangulo: [(4,2), (4,4), (0,4), (0,2)]";

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
    public void ShouldTakeAnchorPoint()
    {
        // Arrange
        String input0 = "Retangulo 1 1 3 1 3 5 1 5\n";
        String input1 = "-90 3 1\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Retangulo: [(3,3), (3,1), (7,1), (7,3)]";

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
        String input1 = "90\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Quadrado: [(2,1), (1,1), (1,2), (2,2)]";

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
        String input0 = "ReTaNgUlO 1 1 3 1 3 5 1 5\n";
        String input1 = "-90 3 1\n";
        ByteArrayOutputStream os = TestUtil.setIOstreams(input0 + input1);
        String expected = "Retangulo: [(3,3), (3,1), (7,1), (7,3)]";

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
