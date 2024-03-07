import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PolygonTests
{
    @Test
    public void ShouldNotInterceptWhenPolygonsAreSeparated()
    {
        // Arrange
        Polygon poly1 = new Polygon(new Point[] {
                new Point(3, 1),
                new Point(4, 1),
                new Point(4, 2),
                new Point(3, 2),
        });
        Polygon poly2 = new Polygon(new Point[] {
                new Point(1, 1),
                new Point(2, 1),
                new Point(2, 2),
                new Point(1, 2),
        });

        //Act
        boolean intercepts = poly1.intercepts(poly2);

        //Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldNotInterceptWhenPointsInPolygonsOverlap()
    {
        // Arrange
        Polygon poly1 = new Polygon(new Point[] {
                new Point(1, 1),
                new Point(2, 1),
                new Point(2, 2),
                new Point(1, 2),
        });
        Polygon poly2 = new Polygon(new Point[] {
                new Point(1, 3),
                new Point(3, 1),
                new Point(3, 3),
        });

        //Act
        boolean intercepts = poly1.intercepts(poly2);

        //Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldNotInterceptWhenPolygonSegmentsOverlap()
    {
        // Arrange
        Polygon poly1 = new Polygon(new Point[] {
                new Point(1, 1),
                new Point(3, 1),
                new Point(1, 3),
        });
        Polygon poly2 = new Polygon(new Point[] {
                new Point(1, 3),
                new Point(3, 1),
                new Point(3, 3),
        });

        //Act
        boolean intercepts = poly1.intercepts(poly2);

        //Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldInterceptWhenSegmentOfPolygonIntercepts()
    {
        // Arrange
        Polygon poly1 = new Polygon(new Point[] {
                new Point(1, 1),
                new Point(4, 1),
                new Point(4, 4),
                new Point(1, 4),
        });
        Polygon poly2 = new Polygon(new Point[] {
                new Point(3, 3),
                new Point(5, 3),
                new Point(5, 5),
                new Point(3, 5),
        });

        //Act
        boolean intercepts = poly1.intercepts(poly2);

        //Assert
        assertTrue(intercepts);
    }

    @Test
    public void ShouldInterceptWhenSegmentIntercepts()
    {
        //Arrange
        Polygon poly = new Polygon(new Point[] {
            new Point(1, 1),
            new Point(3, 1),
            new Point(2, 3),
        });
        LineSegment segment = new LineSegment(new Point(2, 2), new Point(3, 3));

        //Act
        boolean intercepts = poly.intercepts(segment);

        //Assert
        assertTrue(intercepts);
    }

    @Test
    public void ShouldNotInterceptWhenSegmentOverlaps()
    {
        //Arrange
        Polygon poly = new Polygon(new Point[] {
            new Point(2, 1),
            new Point(4, 1),
            new Point(4, 3),
            new Point(2, 3),
        });
        LineSegment segment = new LineSegment(new Point(1, 3), new Point(5, 3));

        //Act
        boolean intercepts = poly.intercepts(segment);

        //Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldNotInterceptWhenPointsOnSegmentOverlap()
    {
        //Arrange
        Polygon poly = new Polygon(new Point[] {
            new Point(2, 1),
            new Point(4, 1),
            new Point(4, 3),
            new Point(2, 3),
        });
        LineSegment segment = new LineSegment(new Point(5, 4), new Point(4, 3));

        //Act
        boolean intercepts = poly.intercepts(segment);

        //Assert
        assertFalse(intercepts);
    }

    @Test
    public void ShouldCalculatePerimeter()
    {
        //Arrange
        Polygon poly0 = new Polygon(new Point[] {
            new Point(0, 0),
            new Point(0, 1),
            new Point(1, 1),
            new Point(1, 0),
        });
        double expected0 = 4;

        Polygon poly1 = new Polygon(new Point[] {
            new Point(0, 0),
            new Point(2, 2),
            new Point(0, 4),
            new Point(0, 3),
            new Point(1, 2),
            new Point(0, 1),
        });
        double expected1 = 10.4852813742;

        Polygon poly2 = new Polygon(new Point[] {
            new Point(0, 2),
            new Point(2, 2),
            new Point(6, 6),
            new Point(6, 8),
            new Point(8, 6),
            new Point(2, 0),
        });
        double expected2 = 23.7989898732;

        Polygon poly3 = new Polygon(new Point[] {
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

        Polygon poly4 = new Polygon(new Point[] {
            new Point(0, 0),
            new Point(1, 1),
            new Point(2, 1),
            new Point(0, 2),
        });
        double expected4 = 6.65028153987;

        //Act
        double obtained0 = poly0.perimeter();
        double obtained1 = poly1.perimeter();
        double obtained2 = poly2.perimeter();
        double obtained3 = poly3.perimeter();
        double obtained4 = poly4.perimeter();

        //Assert
        assertTrue(MathUtil.areEqual(obtained0, expected0));
        assertTrue(MathUtil.areEqual(obtained1, expected1));
        assertTrue(MathUtil.areEqual(obtained2, expected2));
        assertTrue(MathUtil.areEqual(obtained3, expected3));
        assertTrue(MathUtil.areEqual(obtained4, expected4));
    }
}
