package tests;

import src.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PathTests
{
    @Test
    public void ShouldCalculateDistance()
    {
        // Arrange
        Path p = new Path(new Point[] {
            new Point(1, 1),
            new Point(1, 2),
            new Point(2, 2),
            new Point(3, 4),
        });
        double expected = 4.2360679775;

        // Act
        double len = p.dist();

        // Assert
        assertTrue(MathUtil.areEqual(len, expected));
    }

    @Test
    public void ShouldInterceptPolygon()
    {
        // Arrange
        Path path = new Path(new Point[] {
            new Point(0, 0),
            new Point(0, 2),
            new Point(1, 1),
            new Point(3, 4),
            new Point(4, 4),
        });
        Polygon poly = new Polygon(new Point[] {
            new Point(2, 3),
            new Point(2, 1),
            new Point(4, 1),
        });

        // Act
        boolean intercepts = path.intercepts(poly);

        // Assert
        assertTrue(intercepts);
    }

    @Test
    public void ShouldNotInterceptPolygon()
    {
        // Arrange
        Path path = new Path(new Point[] {
            new Point(0, 0),
            new Point(0, 2),
            new Point(1, 1),
            new Point(1, 4),
            new Point(4, 4),
        });
        Polygon poly = new Polygon(new Point[] {
            new Point(2, 3),
            new Point(2, 1),
            new Point(4, 1),
        });

        // Act
        boolean intercepts = path.intercepts(poly);

        // Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldNotInterceptPolygonIfVerticeOverlaps()
    {
        // Arrange
        Path path = new Path(new Point[] {
            new Point(0, 0),
            new Point(0, 2),
            new Point(1, 1),
            new Point(3, 5),
            new Point(4, 4),
        });
        Polygon poly = new Polygon(new Point[] {
            new Point(2, 3),
            new Point(2, 1),
            new Point(4, 1),
        });

        // Act
        boolean intercepts = path.intercepts(poly);

        // Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldNotInterceptPolygonIfSideOverlaps()
    {
        // Arrange
        Path path = new Path(new Point[] {
            new Point(0, 0),
            new Point(0, 2),
            new Point(2, 1),
            new Point(2, 4),
            new Point(4, 4),
        });
        Polygon poly = new Polygon(new Point[] {
            new Point(2, 3),
            new Point(2, 1),
            new Point(4, 1),
        });

        // Act
        boolean intercepts = path.intercepts(poly);

        // Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldInterceptPolygons()
    {
        // Arrange
        Polygon poly0 = new Polygon(new Point[] {
            new Point(1, 2),
            new Point(1, 4),
            new Point(3, 4),
            new Point(1, 2),
        });
        Polygon poly1 = new Polygon(new Point[] {
            new Point(2, 1),
            new Point(4, 1),
            new Point(4, 3),
            new Point(2, 1),
        });
        Polygon[] polys = new Polygon[] { poly0, poly1 };
        Path path0 = new Path(new Point[] {
            new Point(1, 1),
            new Point(5, 3),
        });
        Path path1 = new Path(new Point[] {
            new Point(1, 1),
            new Point(3, 5),
        });

        // Act
        boolean intercepts0 = path0.intercepts(polys);
        boolean intercepts1 = path0.intercepts(polys);

        // Assert
        assertTrue(intercepts0);
        assertTrue(intercepts1);
    }

    @Test
    public void ShouldNotInterceptPolygons()
    {
        // Arrange
        Polygon poly0 = new Polygon(new Point[] {
            new Point(1, 2),
            new Point(1, 4),
            new Point(3, 4),
            new Point(1, 2),
        });
        Polygon poly1 = new Polygon(new Point[] {
            new Point(2, 1),
            new Point(4, 1),
            new Point(4, 3),
            new Point(2, 1),
        });
        Polygon[] polys = new Polygon[] { poly0, poly1 };
        Path path = new Path(new Point[] {
            new Point(1, 1),
            new Point(4, 4),
        });

        // Act
        boolean intercepts = path.intercepts(polys);

        // Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldBeImmutable()
    {
        // Arrange
        Point p0 = new Point(1, 1);
        Point p1 = new Point(4, 4);
        Path path = new Path(new Point[] { p0, p1 });
        Polygon poly = new Polygon(new Point[] {
            new Point(2, 3),
            new Point(2, 1),
            new Point(4, 1),
        });

        // Act
        p0 = new Point(0, 0);
        p1 = new Point(0, 0);
        boolean intercepts = path.intercepts(poly);

        // Assert
        assertTrue(intercepts);
    }
}
