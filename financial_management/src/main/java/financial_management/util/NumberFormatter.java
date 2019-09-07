package financial_management.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberFormatter {
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private static final int ROUNDING_DIGITS = 2;

    public static float formatFloat2Float(float f){
        return new BigDecimal(f).setScale(ROUNDING_DIGITS,ROUNDING_MODE).floatValue();
    }

    public static String formatFloat2String(float f){
        return String.valueOf(formatFloat2Float(f));
    }

    public static RoundingMode getRoundingMode() {
        return ROUNDING_MODE;
    }

    public static int getRoundingDigits() {
        return ROUNDING_DIGITS;
    }
}
