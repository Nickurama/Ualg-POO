package tests;

import src.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MathUtilTests
{
    @Test
    public void areEqualShouldReturnTrueWithinErrorLimit()
    {
        // Arrange
        double d0 = 0.0000000000;
        double d1 = 0.0000000009;
        double d2 = -0.0000000009;
        double d3 = 0.0000000010;
        double d4 = -0.0000000010;
        double d5 = 0.000000000501;
        double d6 = 0.0000000001001;

        // Act
        boolean shouldBeEqualsIfGreaterButWithinErrorLimit = MathUtil.areEqual(d0, d1);
        boolean shouldBeEqualsIfLesserButWithinErrorLimit = MathUtil.areEqual(d0, d2);
        boolean shouldNotBeEqualsIfGreaterButOutsideErrorLimit = MathUtil.areEqual(d0, d3);
        boolean shouldNotBeEqualsIfLesserButOutsideErrorLimit = MathUtil.areEqual(d0, d4);
        boolean shouldBeEqualsIfWithinErrorLimit = MathUtil.areEqual(d5, d6);

        // Arrange
        assertTrue(shouldBeEqualsIfGreaterButWithinErrorLimit);
        assertTrue(shouldBeEqualsIfLesserButWithinErrorLimit);
        assertFalse(shouldNotBeEqualsIfGreaterButOutsideErrorLimit);
        assertFalse(shouldNotBeEqualsIfLesserButOutsideErrorLimit);
        assertTrue(shouldBeEqualsIfWithinErrorLimit);
    }

    @Test
    public void ShouldBeGreaterOrEqualIfGreaterOrWithinErrorLimit()
    {
        double d0 = 0.0000000000;
        double d1 = 0.0000000009;
        double d2 = -0.0000000009;
        double d3 = 0.0000000010;
        double d4 = -0.0000000010;
        double d5 = 0.000000000501;
        double d6 = 0.0000000001001;

        // Act
        boolean shouldBeTrueIfGreater = MathUtil.isGreaterOrEqualThan(d1, d0);
        boolean shouldBeTrueIfLesserButWithinErrorLimit = MathUtil.isGreaterOrEqualThan(d2, d0);
        boolean shouldBeTrueIfGreaterAndOutsideErrorLimit = MathUtil.isGreaterOrEqualThan(d3, d0);
        boolean shouldBeFalseIfLesserButOutsideErrorLimit = MathUtil.isGreaterOrEqualThan(d4, d0);
        boolean shouldBeTrueIfWithinErrorLimit = MathUtil.isGreaterOrEqualThan(d5, d6);

        // Arrange
        assertTrue(shouldBeTrueIfGreater);
        assertTrue(shouldBeTrueIfLesserButWithinErrorLimit);
        assertTrue(shouldBeTrueIfGreaterAndOutsideErrorLimit);
        assertFalse(shouldBeFalseIfLesserButOutsideErrorLimit);
        assertTrue(shouldBeTrueIfWithinErrorLimit);
    }
   
    @Test
    public void ShouldBeLessOrEqualIfLessOrWithinErrorLimit()
    {
        double d0 = 0.0000000000;
        double d1 = 0.0000000009;
        double d2 = -0.0000000009;
        double d3 = 0.0000000010;
        double d4 = -0.0000000010;
        double d5 = 0.000000000501;
        double d6 = 0.0000000001001;

        // Act
        boolean shouldBeTrueIfGreaterButWithinErrorLimit = MathUtil.isLessOrEqualThan(d1, d0);
        boolean shouldBeTrueIfLesser = MathUtil.isLessOrEqualThan(d2, d0);
        boolean shouldBeFalseIfGreaterAndOutsideErrorLimit = MathUtil.isLessOrEqualThan(d3, d0);
        boolean shouldBeTrueIfLesserAndOutsideErrorLimit = MathUtil.isLessOrEqualThan(d4, d0);
        boolean shouldBeTrueIfWithinErrorLimit = MathUtil.isLessOrEqualThan(d5, d6);

        // Arrange
        assertTrue(shouldBeTrueIfGreaterButWithinErrorLimit);
        assertTrue(shouldBeTrueIfLesser);
        assertFalse(shouldBeFalseIfGreaterAndOutsideErrorLimit);
        assertTrue(shouldBeTrueIfLesserAndOutsideErrorLimit);
        assertTrue(shouldBeTrueIfWithinErrorLimit);
    }
}
