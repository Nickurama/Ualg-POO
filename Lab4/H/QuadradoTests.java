import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuadradoTests
{
    @Test
    public void ShouldIncludeNameInString()
    {
        // Arrange
        Quadrado s = new Quadrado(new Point[] {
            new Point(1, 1),
            new Point(1, 2),
            new Point(2, 2),
            new Point(2, 1),
        });
        String expected = "Quadrado: [(1,1), (1,2), (2,2), (2,1)]";

        // Act
        String str = s.toString();

        // Assert
        assertTrue(str.equals(expected));
    }

    @Test
    public void ShouldTakeStringInConstructor()
    {
        // Arrange
        String str = "1 1 1 2 2 2 2 1";
        String expected = "Quadrado: [(1,1), (1,2), (2,2), (2,1)]";

        // Act
        Quadrado s = new Quadrado(str);
        String gen = s.toString();

        // Assert
        assertTrue(gen.equals(expected));
    }
}
