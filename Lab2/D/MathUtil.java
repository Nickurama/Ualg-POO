public class MathUtil
{
    private static final double CALC_ERROR_MARGIN = 0.0000000005;

    public static boolean areEqual(double a, double b)
    {
        return b < a + CALC_ERROR_MARGIN && b > a - CALC_ERROR_MARGIN;
    }
}
