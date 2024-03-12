package tests;

import src.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import org.junit.jupiter.api.Test;


public class PointTests
{
    @Test
    public void CopyShouldMakeDeepCopy()
    {
        // Arrange
        Point p0 = new Point(3, 5);
        Point p1 = p0.copy();
        Point p2 = new Point(p0);

        // Act
        boolean areEqual0 = p0.equals(p1);
        boolean areSame0 = p0 == p1;

        boolean areEqual1 = p0.equals(p2);
        boolean areSame1 = p0 == p2;

        // Assert
        assertTrue(areEqual0);
        assertFalse(areSame0);

        assertTrue(areEqual1);
        assertFalse(areSame1);
    }

    @Test
    public void CopyArrayShouldMakeDeepCopy()
    {
        // Arrange
        Point[] vpArray = {
            new Point(1, 2),
            new Point(2, 3),
            new Point(3, 4),
            new Point(4, 5),
            new Point(5, 6),
        };

        // Act
        Point[] vpArrayCopy = Point.copyArray(vpArray);
        vpArrayCopy[0] = new Point(0, 1);

        // Assert
        assertFalse(vpArray[0].equals(vpArrayCopy[1]));
        for (int i = 1; i < vpArray.length; i++)
            assertTrue(vpArray[i].equals(vpArrayCopy[i]));
    }
    static private ByteArrayOutputStream setIOstreams(String input)
    {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        System.setOut(ps);
        return output;
    }

    @Test
    public void GetPointFromInputShouldGetInputFromSTDIN()
    {
        // Arrange
        String input = "3 1\n12.5 4\n";
        setIOstreams(input);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Point p0 = null;
        Point p1 = null;
        Point expected0 = new Point(3, 1);
        Point expected1 = new Point(12.5, 4);

        // Act
        try
        {
            p0 = Point.getPointFromInput(reader);
            p1 = Point.getPointFromInput(reader);
        }
        catch (IOException e) { }

        // Assert
        assertFalse(p0 == null);
        assertFalse(p1 == null);
        assertTrue(p0.equals(expected0));
        assertTrue(p1.equals(expected1));
    }
}
