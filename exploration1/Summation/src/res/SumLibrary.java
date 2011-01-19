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
   public static final BigDecimal UPPER_BOUND = new BigDecimal(new BigInteger(
      "10000000000000000000000000"));
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
      BigDecimal numerator;
      BigDecimal denominator;
      BigDecimal gcd;
      BigDecimal left;
      BigDecimal right;
      BigDecimal ten = new BigDecimal(10);

      //Get the scale of the number of places past the decimal: 10 ^ n
      denominator = ten.pow(mVal.scale());

      //Get the value to the left of the decimal
      left = new BigDecimal(mVal.toBigInteger());

      //Pull out the numbers to the right of the decimal
      right = mVal.subtract(left);
      right = right.multiply(denominator);

      //Combine everything into one numerator and denominator
      numerator = left.multiply(denominator).add(right);

      //Compute the gcd and use it to simplify the numerator and denominator
      gcd = gcdBigDecimal(numerator, denominator);
      numerator = numerator.divide(gcd);
      denominator = denominator.divide(gcd);
      
      return numerator.toString() + "/" + denominator.toString();
   }

   public static String toLatex(BigDecimal mVal)
   {
      return "Not yet implemented";
   }

   public static BigDecimal gcdBigDecimal(BigDecimal pM, BigDecimal pN)
   {
      //while pM is not equal to pN
      while (0 != pM.compareTo(pN))
		{
         //if pM is greater than pN
         if (1 == pM.compareTo(pN))
			{
				pM = pM.subtract(pN);
			}

         //if pN is greater than pM
			if (1 == pN.compareTo(pM))
			{
				pN = pN.subtract(pM);
			}
		}
		return pM;
   }
}
