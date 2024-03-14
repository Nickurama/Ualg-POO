package tests;

import src.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SquareTests
{
    @Test
    public void ShouldIncludeNameInString()
    {
        // Arrange
        Square s = new Square(new Point[] {
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
}
