import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TriangleTests
{
    @Test
    public void ShouldIncludeNameInString()
    {
        // Arrange
        Triangulo s = new Triangulo(new Point[] {
            new Point(1, 1),
            new Point(3, 1),
            new Point(2, 2),
        });
        String expected = "Triângulo: [(1,1), (3,1), (2,2)]";

        // Act
        String str = s.toString();

        // Assert
        assertTrue(str.equals(expected));
    }
}
