package sumpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import res.BigRational;
import res.SumLibrary;

/**
 *
 * @author Devin
 */
public class HalfToTheNTimeHarmonic
   implements SumFunction
{

   Summation mHarmonic;


   public HalfToTheNTimeHarmonic()
   {
      mHarmonic = new Summation(new HarmonicNumber(), SumLibrary.ONE);
   }

   public BigRational evaluate(BigDecimal n)
   {
      BigInteger powerOfTwo = new BigInteger("2").pow(n.intValue());
      //KLUDGE: There is an off by one error in the Summation class I'm sure
      // for now I'm doing the following line at n + 1 instead of n just
      // so i can get the right output for this particular SumFunction
      BigRational h = mHarmonic.sum(n.add(SumLibrary.ONE));
      BigInteger den = h.getDenominator().multiply(powerOfTwo);
      return new BigRational(h.getNumerator(), den);
   }
}
