import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RetanguloTests
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

    @Test
    public void ShouldTakeStringInConstructor()
    {
        // Arrange
        String str = "4 1 1 1 2 4 2 4 1";
        String expected = "Retângulo: [(1,1), (1,2), (4,2), (4,1)]";

        // Act
        Retangulo r = new Retangulo(str);
        String gen = r.toString();

        // Assert
        assertTrue(gen.equals(expected));
    }
}
