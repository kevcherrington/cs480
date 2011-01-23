package sumpackage;

import java.math.BigDecimal;
import res.BigRational;

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
      mHarmonic = new Summation(new HarmonicNumber());
   }

   public BigRational evaluate(BigDecimal n)
   {

      return new BigRational(1,1);
   }
}
