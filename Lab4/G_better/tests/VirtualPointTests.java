package tests;

import src.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class VirtualPointTests
{
    @Test
    public void EqualsShouldBeTrueWhenCoordinatesAreSame()
    {
        // Arrange
        VirtualPoint p0 = new VirtualPoint(5, -12);
        VirtualPoint p1 = new VirtualPoint(5, 4);
        VirtualPoint p2 = new VirtualPoint(2, -12);
        VirtualPoint p3 = new VirtualPoint(5, -12);
        VirtualPoint p4 = p0.copy();

        // Act
        boolean isEqualsIfXisEquals = p0.equals(p1);
        boolean isEqualsIfYisEquals = p0.equals(p2);
        boolean isEqualsIfCoordinatesAreEqual = p0.equals(p3);
        boolean isEqualsIfIsCopy = p0.equals(p4);
        boolean isEqualsIfIsSame = p0.equals(p0);

        // Assert
        assertFalse(isEqualsIfXisEquals);
        assertFalse(isEqualsIfYisEquals);
        assertTrue(isEqualsIfCoordinatesAreEqual);
        assertTrue(isEqualsIfIsCopy);
        assertTrue(isEqualsIfIsSame);
    }

    @Test
    public void CopyShouldMakeDeepCopy()
    {
        // Arrange
        VirtualPoint p0 = new VirtualPoint(-3, 5);
        VirtualPoint p1 = p0.copy();
        VirtualPoint p2 = new VirtualPoint(p0);

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
        VirtualPoint[] vpArray = {
            new VirtualPoint(1, -2),
            new VirtualPoint(2, -3),
            new VirtualPoint(3, -4),
            new VirtualPoint(4, -5),
            new VirtualPoint(5, -6),
        };

        // Act
        VirtualPoint[] vpArrayCopy = VirtualPoint.copyArray(vpArray);
        vpArrayCopy[0] = new VirtualPoint(0, -1);

        // Assert
        assertFalse(vpArray[0].equals(vpArrayCopy[1]));
        for (int i = 1; i < vpArray.length; i++)
            assertTrue(vpArray[i].equals(vpArrayCopy[i]));
    }

    @Test
    public void DistanceShouldReturnCorrectDistance()
    {
        // Arrange
        VirtualPoint p0 = new VirtualPoint(0, 1);
        VirtualPoint p1 = new VirtualPoint(0, 2);
        VirtualPoint p2 = new VirtualPoint(0, -5);
        VirtualPoint p3 = new VirtualPoint(1, 0);
        VirtualPoint p4 = new VirtualPoint(2, 0);
        VirtualPoint p5 = new VirtualPoint(-5, 0);
        VirtualPoint p6 = new VirtualPoint(-2, -3);
        VirtualPoint p7 = new VirtualPoint(7, 6);
        VirtualPoint p8 = new VirtualPoint(0, 0);

        // Act
        double dist0 = p0.dist(p1);
        double expected0 = 1;
        double dist1 = p0.dist(p2);
        double expected1 = 6;
        double dist2 = p3.dist(p4);
        double expected2 = 1;
        double dist3 = p3.dist(p5);
        double expected3 = 6;
        double dist4 = p6.dist(p7);
        double expected4 = 12.7279220614;
        double dist5 = p7.dist(p6);
        double expected5 = 12.7279220614;
        double dist6 = p8.dist(p8);
        double expected6 = 0;

        // Assert
        assertTrue(MathUtil.areEqual(dist0, expected0));
        assertTrue(MathUtil.areEqual(dist1, expected1));
        assertTrue(MathUtil.areEqual(dist2, expected2));
        assertTrue(MathUtil.areEqual(dist3, expected3));
        assertTrue(MathUtil.areEqual(dist4, expected4));
        assertTrue(MathUtil.areEqual(dist5, expected5));
        assertTrue(MathUtil.areEqual(dist6, expected6));
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
        String input = "3 -1\n-12.5 -4\n";
        setIOstreams(input);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        VirtualPoint p0 = null;
        VirtualPoint p1 = null;
        VirtualPoint expected0 = new VirtualPoint(3, -1);
        VirtualPoint expected1 = new VirtualPoint(-12.5, -4);

        // Act
        try
        {
            p0 = VirtualPoint.getPointFromInput(reader);
            p1 = VirtualPoint.getPointFromInput(reader);
        }
        catch (IOException e) { }

        // Assert
        assertFalse(p0 == null);
        assertFalse(p1 == null);
        assertTrue(p0.equals(expected0));
        assertTrue(p1.equals(expected1));
    }
}
