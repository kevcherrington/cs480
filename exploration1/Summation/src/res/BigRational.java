package res;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Devin
 */
public class BigRational
{
   private BigInteger mNumerator;
   private BigInteger mDenominator;

   public BigRational(int pNumerator, int pDenominator)
   {
      mNumerator = new BigDecimal(pNumerator).toBigInteger();
      mDenominator = new BigDecimal(pDenominator).toBigInteger();
   }

   public BigRational(BigInteger pNumerator, BigInteger pDenominator)
   {
      mNumerator = pNumerator;
      mDenominator = pDenominator;
   }

   public BigDecimal toBigDecimal()
   {
      BigDecimal num = new BigDecimal(mNumerator);
      BigDecimal den = new BigDecimal(mDenominator);
      return SumLibrary.bigDivide(num, den);
   }

   /**
    * (ad + bc) / bd = (a/b) + (c/d)
    *
    * @param pAugend
    * @return
    */
   public BigRational add(BigRational pAugend)
   {
      BigInteger ad = mNumerator.multiply(pAugend.getDenominator());
      BigInteger bc = mDenominator.multiply(pAugend.getNumerator());
      BigInteger bd = mDenominator.multiply(pAugend.getDenominator());
      
      return new BigRational(ad.add(bc), bd);
   }

   public String toFraction()
   {
      return mNumerator.toString() + "/" + mDenominator.toString();
   }

   public String toLatex()
   { 
      return "\\frac{" + mNumerator.toString() + "}{" + mDenominator.toString() + "}";
   }

   public BigInteger getNumerator()
   {
      return mNumerator;
   }

   public BigInteger getDenominator()
   {
      return mDenominator;
   }
}
