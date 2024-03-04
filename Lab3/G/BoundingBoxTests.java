// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.Test;

// public class BoundingBoxTests
// {
//     Point[] test0_0 =
//     {
//         new Point(1, 1),
//         new Point(2, 1),
//         new Point(1, 2),
//     };

//     Point[] test0_1 =
//     {
//         new Point(4, 3),
//         new Point(3, 4),
//         new Point(3, 3),
//     };

//     Point[] test1_0 =
//     {
//         new Point(1, 6),
//         new Point(2, 9),
//         new Point(3, 6),
//         new Point(2, 8),
//     };

//     Point[] test1_1 =
//     {
//         new Point(1, 4),
//         new Point(2, 7),
//         new Point(3, 4),
//         new Point(2, 6),
//     };

//     Point[] test2_0 =
//     {
//         new Point(1, 1),
//         new Point(2, 1),
//         new Point(2, 2),
//         new Point(1, 2),
//     };

//     Point[] test2_1 =
//     {
//         new Point(1, 2),
//         new Point(2, 2),
//         new Point(2, 3),
//         new Point(1, 3),
//     };

//     @Test
//     public void test0_ShouldNotInterceptWhenBoxesDontIntercept()
//     {
//         // Arrange
//         BoundingBox bb0 = new BoundingBox(test0_0);
//         BoundingBox bb1 = new BoundingBox(test0_1);

//         // Act
//         boolean intercepts = bb0.intercepts(bb1);

//         // Assert
//         assertFalse(intercepts);
//     }

//     @Test
//     public void test1_ShouldInterceptWhenBoxesDontInterceptButAreClose()
//     {
//         // Arrange
//         BoundingBox bb0 = new BoundingBox(test1_0);
//         BoundingBox bb1 = new BoundingBox(test1_1);

//         // Act
//         boolean intercepts = bb0.intercepts(bb1);

//         // Assert
//         assertTrue(intercepts);
//     }

//     @Test
//     public void test2_ShouldNotInterceptWhenSideOverlaps()
//     {
//         // Arrange
//         BoundingBox bb0 = new BoundingBox(test2_0);
//         BoundingBox bb1 = new BoundingBox(test2_1);

//         // Act
//         boolean intercepts = bb0.intercepts(bb1);

//         // Assert
//         assertTrue(intercepts);
//     }
// }
