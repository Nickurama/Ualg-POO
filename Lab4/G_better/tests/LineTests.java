package tests;

import src.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class LineTests
{
    @Test
    public void isCollinearShouldBeTrueWithHorizontalCollinearity()
    {
        // Arrange
        Line horizontal = new Line(new Point(1, 1), new Point(2, 1));
        Point horizontalCollinear = new Point(3, 1);

        // Act
        boolean horizontalIsCollinear = horizontal.isCollinear(horizontalCollinear);

        // Assert
        assertTrue(horizontalIsCollinear);
    }

    @Test
    public void isCollinearShouldBeTrueWithVerticalCollinearity()
    {
        // Arrange
        Line vertical = new Line(new Point(1, 1), new Point(1, 2));
        Point verticalCollinear = new Point(1, 3);

        // Act
        boolean verticalIsCollinear = vertical.isCollinear(verticalCollinear);

        // Assert
        assertTrue(verticalIsCollinear);
    }

    @Test
    public void isCollinearShouldBeTrueWithDiagonalCollinearity()
    {
        // Arrange
        Line diagonal = new Line(new Point(1, 1), new Point(2, 2));
        Point diagonalCollinear = new Point(3, 3);

        // Act
        boolean diagonalIsCollinear = diagonal.isCollinear(diagonalCollinear);

        // Assert
        assertTrue(diagonalIsCollinear);
    }

    @Test void isCollinearShouldBeFalseWhenPointIsntCollinear()
    {
       // Arrange
        Line vertical = new Line(new Point(1, 1), new Point(1, 2));
        Point verticalCollinear = new Point(1, 3);
        Line diagonal = new Line(new Point(1, 1), new Point(2, 2));
        Point horizontalCollinear = new Point(3, 1);

        // Act
        boolean verticalIsCollinearWithHorizontal = vertical.isCollinear(horizontalCollinear);
        boolean diagonalIsCollinearWithVertical = diagonal.isCollinear(verticalCollinear);

        // Assert
        assertFalse(verticalIsCollinearWithHorizontal);
        assertFalse(diagonalIsCollinearWithVertical);
    }

    @Test
    public void calcIntersectShouldWorkForHorizontalIntersection()
    {
        // Assert
        Line l0 = new Line(new Point(1, 1), new Point(2, 1));
        Line l1 = new Line(new Point(5, 3), new Point(5, 4));
        VirtualPoint expected = new VirtualPoint(5, 1);

        // Act
        VirtualPoint vp = l0.calcIntersect(l1);

        // Arrange
        assertTrue(vp.equals(expected));
    }

    @Test
    public void calcIntersectShouldWorkForVerticalIntersection()
    {
        // Assert
        Line l0 = new Line(new Point(1, 1), new Point(1, 2));
        Line l1 = new Line(new Point(3, 5), new Point(4, 5));
        VirtualPoint expected = new VirtualPoint(1, 5);

        // Act
        VirtualPoint vp = l0.calcIntersect(l1);

        // Arrange
        assertTrue(vp.equals(expected));
    }

    @Test
    public void calcIntersectShouldWorkForNonIntegerIntersections()
    {
        // Arrange
        Line l0 = new Line(new Point(0, 5), new Point(1, 0));
        Line l1 = new Line(new Point(0, 4), new Point(10, 0));
        VirtualPoint expected = new VirtualPoint(0.21739130434, 3.91304347826);

        // Act
        VirtualPoint vp = l0.calcIntersect(l1);

        // Assert
        assertTrue(vp.equals(expected));
    }

    @Test
    public void calcIntersectShouldWorkWhenIntersectionIsNegative()
    {
        // Arrange
        Line l0 = new Line(new Point(0, 6), new Point(1, 8));
        Line l1 = new Line(new Point(4, 0), new Point(6, 1));
        VirtualPoint expected = new VirtualPoint(-5.3333333333, -4.6666666666);

        // Act
        VirtualPoint vp = l0.calcIntersect(l1);

        // Assert
        assertTrue(vp.equals(expected));
    }

    @Test
    public void isParalelShouldBeTrueWhenHorizontalParalelism()
    {
        // Arrange
        Line l0 = new Line(new Point(1, 1), new Point(2, 1));
        Line l1 = new Line(new Point(2, 2), new Point(4, 2));

        // Act
        boolean isParalel = l0.isParalel(l1);

        // Arrange
        assertTrue(isParalel);
    }

    @Test
    public void isParalelShouldBeTrueWhenVerticalParalelism()
    {
        // Arrange
        Line l0 = new Line(new Point(1, 1), new Point(1, 2));
        Line l1 = new Line(new Point(2, 2), new Point(2, 4));

        // Act
        boolean isParalel = l0.isParalel(l1);

        // Arrange
        assertTrue(isParalel);
    }

    @Test
    public void isParalelShouldBeTrueWhenDiagonalParalelism()
    {
        // Arrange
        Line l0 = new Line(new Point(4, 0), new Point(14, 2));
        Line l1 = new Line(new Point(6, 0), new Point(16, 2));

        // Act
        boolean isParalel = l0.isParalel(l1);

        // Arrange
        assertTrue(isParalel);
    }

    @Test
    public void isParalelShouldBeFalseWhenNotParalel()
    {
        // Arrange
        Line l0 = new Line(new Point(4, 0), new Point(14, 2));
        Line l1 = new Line(new Point(5, 0), new Point(16, 2));

        // Act
        boolean isParalel = l0.isParalel(l1);

        // Arrange
        assertFalse(isParalel);
    }

    @Test
    public void equalsShouldBeTrueWithExactSameLine()
    {
        // Arrange
        Line l = new Line(new Point(0, 0), new Point(1, 1));

        // Act
        boolean isEqual = l.equals(l);

        // Arrange
        assertTrue(isEqual);
    }

    @Test
    public void equalsShouldBeTrueWithEqualLines()
    {
        // Arrange
        Line l0 = new Line(new Point(0, 0), new Point(1, 1));
        Line l1 = new Line(new Point(0, 0), new Point(1, 1));

        // Act
        boolean isEqual = l0.equals(l1);

        // Arrange
        assertTrue(isEqual);
    }

    @Test
    public void equalsShouldBeTrueWithEquivalentLines()
    {
        // Arrange
        Line l0 = new Line(new Point(2, 2), new Point(3, 3));
        Line l1 = new Line(new Point(1, 1), new Point(4, 4));

        Line l2 = new Line(new Point(2, 2), new Point(3, 3));
        Line l3 = new Line(new Point(4, 4), new Point(1, 1));

        // Act
        boolean isEqual0 = l0.equals(l1);
        boolean isEqual1 = l2.equals(l3);

        // Arrange
        assertTrue(isEqual0);
        assertTrue(isEqual1);
    }

    @Test
    public void equalsShouldBeFalseWhenLinesAreParalel()
    {
        // Arrange
        Line l0 = new Line(new Point(0, 0), new Point(1, 0));
        Line l1 = new Line(new Point(0, 1), new Point(1, 1));

        // Act
        boolean isEqual = l0.equals(l1);

        // Arrange
        assertFalse(isEqual);
    }

    @Test
    public void equalsShouldBeFalseWhenLinesAreNotEqual()
    {
        // Arrange
        Line l0 = new Line(new Point(0, 0), new Point(1, 1));
        Line l1 = new Line(new Point(0, 1), new Point(1, 1));

        // Act
        boolean isEqual = l0.equals(l1);

        // Arrange
        assertFalse(isEqual);
    }
}
