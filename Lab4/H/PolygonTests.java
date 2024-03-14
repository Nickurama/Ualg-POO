import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PolygonTests
{
    @Test
    public void ShouldNotInterceptWhenPolygonsAreSeparated()
    {
        // Arrange
        Poligono poly1 = new Poligono(new Point[] {
                new Point(3, 1),
                new Point(4, 1),
                new Point(4, 2),
                new Point(3, 2),
        });
        Poligono poly2 = new Poligono(new Point[] {
                new Point(1, 1),
                new Point(2, 1),
                new Point(2, 2),
                new Point(1, 2),
        });

        // Act
        boolean intercepts = poly1.intercepts(poly2);

        // Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldNotInterceptWhenPointsInPolygonsOverlap()
    {
        // Arrange
        Poligono poly1 = new Poligono(new Point[] {
                new Point(1, 1),
                new Point(2, 1),
                new Point(2, 2),
                new Point(1, 2),
        });
        Poligono poly2 = new Poligono(new Point[] {
                new Point(1, 3),
                new Point(3, 1),
                new Point(3, 3),
        });

        // Act
        boolean intercepts = poly1.intercepts(poly2);

        // Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldNotInterceptWhenPolygonSegmentsOverlap()
    {
        // Arrange
        Poligono poly1 = new Poligono(new Point[] {
                new Point(1, 1),
                new Point(3, 1),
                new Point(1, 3),
        });
        Poligono poly2 = new Poligono(new Point[] {
                new Point(1, 3),
                new Point(3, 1),
                new Point(3, 3),
        });

        // Act
        boolean intercepts = poly1.intercepts(poly2);

        // Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldInterceptWhenSegmentOfPolygonIntercepts()
    {
        // Arrange
        Poligono poly1 = new Poligono(new Point[] {
                new Point(1, 1),
                new Point(4, 1),
                new Point(4, 4),
                new Point(1, 4),
        });
        Poligono poly2 = new Poligono(new Point[] {
                new Point(3, 3),
                new Point(5, 3),
                new Point(5, 5),
                new Point(3, 5),
        });

        // Act
        boolean intercepts = poly1.intercepts(poly2);

        // Assert
        assertTrue(intercepts);
    }

    @Test
    public void ShouldInterceptWhenSegmentIntercepts()
    {
        // Arrange
        Poligono poly = new Poligono(new Point[] {
            new Point(1, 1),
            new Point(3, 1),
            new Point(2, 3),
        });
        LineSegment segment = new LineSegment(new Point(2, 2), new Point(3, 3));

        // Act
        boolean intercepts = poly.intercepts(segment);

        // Assert
        assertTrue(intercepts);
    }

    @Test
    public void ShouldNotInterceptWhenSegmentOverlaps()
    {
        // Arrange
        Poligono poly = new Poligono(new Point[] {
            new Point(2, 1),
            new Point(4, 1),
            new Point(4, 3),
            new Point(2, 3),
        });
        LineSegment segment = new LineSegment(new Point(1, 3), new Point(5, 3));

        // Act
        boolean intercepts = poly.intercepts(segment);

        // Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldNotInterceptWhenPointsOnSegmentOverlap()
    {
        // Arrange
        Poligono poly = new Poligono(new Point[] {
            new Point(2, 1),
            new Point(4, 1),
            new Point(4, 3),
            new Point(2, 3),
        });
        LineSegment segment = new LineSegment(new Point(5, 4), new Point(4, 3));

        // Act
        boolean intercepts = poly.intercepts(segment);

        // Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldInterceptOnLastSide()
    {
        // Arrange
        Poligono poly = new Poligono(new Point[] {
            new Point(2, 4),
            new Point(2, 1),
            new Point(5, 1),
        });
        LineSegment segment = new LineSegment(new Point(3, 0), new Point(3, 2));

        // Act
        boolean intercepts = poly.intercepts(segment);

        // Assert
        assertTrue(intercepts);
    }

    @Test
    public void ShouldCalculatePerimeter()
    {
        // Arrange
        Poligono poly0 = new Poligono(new Point[] {
            new Point(0, 0),
            new Point(0, 1),
            new Point(1, 1),
            new Point(1, 0),
        });
        double expected0 = 4;

        Poligono poly1 = new Poligono(new Point[] {
            new Point(0, 0),
            new Point(2, 2),
            new Point(0, 4),
            new Point(0, 3),
            new Point(1, 2),
            new Point(0, 1),
        });
        double expected1 = 10.4852813742;

        Poligono poly2 = new Poligono(new Point[] {
            new Point(0, 2),
            new Point(2, 2),
            new Point(6, 6),
            new Point(6, 8),
            new Point(8, 6),
            new Point(2, 0),
        });
        double expected2 = 23.7989898732;

        Poligono poly3 = new Poligono(new Point[] {
            new Point(0, 0),
            new Point(2, 0),
            new Point(1, 1),
            new Point(1, 2),
            new Point(2, 5),
            new Point(0, 5),
            new Point(1, 4),
            new Point(1, 3),
        });
        double expected3 = 15.1529824451;

        Poligono poly4 = new Poligono(new Point[] {
            new Point(0, 0),
            new Point(1, 1),
            new Point(2, 1),
            new Point(0, 2),
        });
        double expected4 = 6.65028153987;

        // Act
        double obtained0 = poly0.perimeter();
        double obtained1 = poly1.perimeter();
        double obtained2 = poly2.perimeter();
        double obtained3 = poly3.perimeter();
        double obtained4 = poly4.perimeter();

        // Assert
        assertTrue(MathUtil.areEqual(obtained0, expected0));
        assertTrue(MathUtil.areEqual(obtained1, expected1));
        assertTrue(MathUtil.areEqual(obtained2, expected2));
        assertTrue(MathUtil.areEqual(obtained3, expected3));
        assertTrue(MathUtil.areEqual(obtained4, expected4));
    }

    @Test
    public void ShouldBeImmutable()
    {
        // Arrange
        Point p0 = new Point(1, 1);
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(2, 1);
        Poligono poly = new Poligono(new Point[] { p0, p1, p2, p3 });
        LineSegment segment = new LineSegment(new Point(0, 4), new Point(3, 0));

        // Act
        p0 = new Point(0, 0);
        p1 = new Point(0, 0);
        p2 = new Point(0, 0);
        p3 = new Point(0, 0);

        // Assert
        assertTrue(poly.intercepts(segment));
    }

    @Test
    public void ShouldIncludeAllVerticesInString()
    {
        Poligono poly = new Poligono(new Point[] {
            new Point(3, 5),
            new Point(9, 312),
            new Point(512, 1024),
            new Point(7, 1.5),
            new Point(0, 0),
            new Point(0, 12),
        });
        String expected = "Polígono de 6 vértices: [(3,5), (9,312), (512,1024), (7,1), (0,0), (0,12)]";

        // Act
        String str = poly.toString();

        // Arrange
        assertTrue(str.equals(expected));
    }

    @Test
    public void ShouldTakeConstructorWithString()
    {
        // Arrange
        Poligono poly = new Poligono("5 1 1 1 3 2 5 7 2 5 1");
        String expected = "Polígono de 5 vértices: [(1,1), (1,3), (2,5), (7,2), (5,1)]";

        // Act
        String polyString = poly.toString();

        // Assert
        assertTrue(polyString.equals(expected));
    }

    @Test
    public void ShouldEquals()
    {
        // Arrange
        Poligono p0 = new Poligono(new Point[] {
            new Point(4, 5),
            new Point(7, 8),
            new Point(10, 12),
            new Point(16, 16),
            new Point(16, 0),
        });
        Poligono p1 = new Poligono(new Point[] {
            new Point(4, 5),
            new Point(7, 8),
            new Point(10, 12),
            new Point(16, 16),
            new Point(16, 0),
        });
        System.out.println(-1 % 5);

        // Act
        boolean equals = p0.equals(p1);

        // Arrange
        assertTrue(equals);
    }

    @Test
    public void ShouldEqualsWhenSamePolygonButInvertedOrderOfVertices()
    {
        // Arrange
        Poligono p0 = new Poligono(new Point[] {
            new Point(4, 5),
            new Point(7, 8),
            new Point(10, 12),
            new Point(16, 16),
            new Point(16, 0),
        });
        Poligono p1 = new Poligono(new Point[] {
            new Point(16, 0),
            new Point(16, 16),
            new Point(10, 12),
            new Point(7, 8),
            new Point(4, 5),
        });
        System.out.println(-1 % 5);

        // Act
        boolean equals = p0.equals(p1);

        // Arrange
        assertTrue(equals);

    }

    @Test
    public void ShouldEqualsWhenSamePolygonButOffset()
    {
        // Arrange
        Poligono p0 = new Poligono(new Point[] {
            new Point(4, 5),
            new Point(7, 8),
            new Point(10, 12),
            new Point(16, 16),
            new Point(16, 0),
        });
        Poligono p1 = new Poligono(new Point[] {
            new Point(7, 8),
            new Point(4, 5),
            new Point(16, 0),
            new Point(16, 16),
            new Point(10, 12),
        });
        System.out.println(-1 % 5);

        // Act
        boolean equals = p0.equals(p1);

        // Arrange
        assertTrue(equals);

    }

    @Test
    public void ShouldNotEqualsWhenDifferentValues()
    {
        // Arrange
        Poligono p0 = new Poligono(new Point[] {
            new Point(4, 5),
            new Point(7, 8),
            new Point(10, 16),
            new Point(16, 16),
            new Point(16, 0),
        });
        Poligono p1 = new Poligono(new Point[] {
            new Point(4, 5),
            new Point(7, 8),
            new Point(10, 12),
            new Point(16, 12),
            new Point(16, 0),
        });

        // Act
        boolean equals = p0.equals(p1);

        // Arrange
        assertFalse(equals);
    }

    @Test
    public void ShouldNotEqualsWhenDifferentNumberOfVertices()
    {
        // Arrange
        Poligono p0 = new Poligono(new Point[] {
            new Point(4, 5),
            new Point(7, 8),
            new Point(10, 12),
            new Point(16, 16),
            new Point(16, 0),
        });
        Poligono p1 = new Poligono(new Point[] {
            new Point(4, 5),
            new Point(7, 8),
            new Point(10, 12),
            new Point(16, 16),
        });

        // Act
        boolean equals = p0.equals(p1);

        // Arrange
        assertFalse(equals);
    }
}
