import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectangleTests
{
    @Test
    public void ShouldIncludeNameInString()
    {
        // Arrange
        Retangulo s = new Retangulo(new Point[] {
            new Point(1, 1),
            new Point(1, 2),
            new Point(5, 2),
            new Point(5, 1),
        });
        String expected = "Retângulo: [(1,1), (1,2), (5,2), (5,1)]";

        // Act
        String str = s.toString();

        // Assert
        assertTrue(str.equals(expected));
    }
}
