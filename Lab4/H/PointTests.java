import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PointTests
{
    @Test
    public void ShouldMakeDeepCopyWhenCopying()
    {
        // Arrange
        Point p0 = new Point(3, 5);
        // Point p1 = (Point) p0.copy();
        Point p2 = new Point(p0);

        // Act
        // boolean areEqual0 = p0.equals(p1);
        // boolean areSame0 = p0 == p1;

        boolean areEqual1 = p0.equals(p2);
        boolean areSame1 = p0 == p2;

        // Assert
        // assertTrue(areEqual0);
        // assertFalse(areSame0);

        assertTrue(areEqual1);
        assertFalse(areSame1);
    }

    @Test
    public void ShouldMakeDeepCopyWhenCopyingArray()
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
        Point[] vpArrayCopy = (Point[]) Point.copyArray(vpArray);
        vpArrayCopy[0] = new Point(0, 1);

        // Assert
        assertFalse(vpArray[0].equals(vpArrayCopy[1]));
        for (int i = 1; i < vpArray.length; i++)
            assertTrue(vpArray[i].equals(vpArrayCopy[i]));
    }

    @Test
    public void ShouldTurnArrayOfPointsToString()
    {
        // Arrange
        Point[] vps = new Point[] {
            new Point(3, 5),
            new Point(9, 312),
            new Point(512, 1024),
            new Point(7, 1.5),
            new Point(0, 0),
            new Point(0, 12),
        };
        String expected = "[(3,5), (9,312), (512,1024), (7,1), (0,0), (0,12)]";

        // Act
        String str = Point.arrayToString(vps);

        // Arrange
        assertTrue(str.equals(expected));
    }
    
    @Test
    public void ShouldTurnStringToPoints()
    {
        // Arrange
        String str0 = "4 1 1 1 2 2 2 2 1";
        String str1 = "1 1 1 2 2 2 2 1";
        String expected = "[(1,1), (1,2), (2,2), (2,1)]";

        // Act
        Point[] points0 = Point.parseToArray(str0);
        Point[] points1 = Point.parseToArray(str1, 4);

        // Assert
        assertTrue(Point.arrayToString(points0).equals(expected));
        assertTrue(Point.arrayToString(points1).equals(expected));
    }

    // @Test
    // public void ShouldGetInput()
    // {
    //     // Arrange
    //     String input = "3 1\n12.5 4\n";
    //     TestUtil.setIOstreams(input);
    //     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //     Point p0 = null;
    //     Point p1 = null;
    //     Point expected0 = new Point(3, 1);
    //     Point expected1 = new Point(12.5, 4);

    //     // Act
    //     try
    //     {
    //         p0 = Point.getPointFromInput(reader);
    //         p1 = Point.getPointFromInput(reader);
    //     }
    //     catch (IOException e) { }

    //     // Assert
    //     assertFalse(p0 == null);
    //     assertFalse(p1 == null);
    //     assertTrue(p0.equals(expected0));
    //     assertTrue(p1.equals(expected1));
    // }
}
