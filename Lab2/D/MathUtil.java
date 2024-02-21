public class MathUtil
{
    private static final double CALC_ERROR_MARGIN = 0.000000001;

    public static boolean areEqual(double a, double b)
    {
        return Math.abs(b - a) < CALC_ERROR_MARGIN;
    }
}
