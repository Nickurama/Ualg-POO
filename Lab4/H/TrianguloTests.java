import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrianguloTests
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

    @Test
    public void ShouldTakeStringInConstructor()
    {
        // Arrange
        String str = "7 1 9 1 9 3";
        String expected = "Triângulo: [(7,1), (9,1), (9,3)]";

        // Act
        Triangulo t = new Triangulo(str);
        String gen = t.toString();

        // Assert
        assertTrue(gen.equals(expected));

    }
}
