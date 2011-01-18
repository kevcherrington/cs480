package res;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Devin
 */
public class SumLibrary
{
   public static final BigDecimal ONE = new BigDecimal(1);
   public static final BigDecimal UPPER_BOUND = new BigDecimal(new BigInteger("10000000000000000000000000"));
   public static final BigDecimal ZERO = new BigDecimal(0);
   public static final BigInteger BI_ZERO = new BigInteger("0");
   public static final BigInteger TEN_MILLION = new BigInteger("10000000");
   public static final int INT_ZERO = 0;
   public static final int PRECISION = 100;


   /**
    * Converts a BigDecimal into a String containing the fractional form
    * of the value.
    *
    * @param mVal The value to convert
    * @return A String containing the fractional form of the value.
    */
   public static String toFraction(BigDecimal mVal)
   {
      return "Not yet implemented";
   }

   public static String toLatex(BigDecimal mVal)
   {
      return "Not yet implemented";
   }
}
