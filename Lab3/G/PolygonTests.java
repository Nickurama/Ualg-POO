import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PolygonTests
{
    static private Point[][][] interceptPolygonsTestPoints = {
        {
            {
                new Point(3, 1),
                new Point(4, 1),
                new Point(4, 2),
                new Point(3, 2),
            },
            {
                new Point(1, 1),
                new Point(2, 1),
                new Point(2, 2),
                new Point(1, 2),
            }
        },
        {
            {
                new Point(1, 1),
                new Point(2, 1),
                new Point(2, 2),
                new Point(1, 2),
            },
            {
                new Point(1, 3),
                new Point(3, 1),
                new Point(3, 3),
            }
        },
        {
            {
                new Point(1, 1),
                new Point(3, 1),
                new Point(1, 3),
            },
            {
                new Point(1, 3),
                new Point(3, 1),
                new Point(3, 3),
            }
        },
        {
            {
                new Point(1, 1),
                new Point(4, 1),
                new Point(4, 4),
                new Point(1, 4),
            },
            {
                new Point(3, 3),
                new Point(5, 3),
                new Point(5, 5),
                new Point(3, 5),
            }
        },
    };

    @Test
    public void interceptsPolygonTests_ShouldNotInterceptWhenSeparated()
    {
        // Arrange
        Polygon poly1 = new Polygon(interceptPolygonsTestPoints[0][0]);
        Polygon poly2 = new Polygon(interceptPolygonsTestPoints[0][1]);

        //Act
        boolean intercepts = poly1.intercepts(poly2);

        //Assert
        assertFalse(intercepts);
    }

    @Test
    public void interceptsPolygonTests_ShouldNotInterceptWhenPointOverlaps()
    {
        // Arrange
        Polygon poly1 = new Polygon(interceptPolygonsTestPoints[1][0]);
        Polygon poly2 = new Polygon(interceptPolygonsTestPoints[1][1]);

        //Act
        boolean intercepts = poly1.intercepts(poly2);

        //Assert
        assertFalse(intercepts);
    }

    @Test
    public void interceptsPolygonTests_ShouldNotInterceptWhenLineOverlaps()
    {
        // Arrange
        Polygon poly1 = new Polygon(interceptPolygonsTestPoints[2][0]);
        Polygon poly2 = new Polygon(interceptPolygonsTestPoints[2][1]);

        //Act
        boolean intercepts = poly1.intercepts(poly2);

        //Assert
        assertFalse(intercepts);
    }

    @Test
    public void interceptsPolygonTests_ShouldInterceptWhenSideIntercepts()
    {
        // Arrange
        Polygon poly1 = new Polygon(interceptPolygonsTestPoints[3][0]);
        Polygon poly2 = new Polygon(interceptPolygonsTestPoints[3][1]);

        //Act
        boolean intercepts = poly1.intercepts(poly2);

        //Assert
        assertTrue(intercepts);
    }
}
