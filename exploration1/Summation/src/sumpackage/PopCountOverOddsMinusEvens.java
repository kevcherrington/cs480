package sumpackage;

import java.math.BigDecimal;
import res.SumLibrary;

/**
 *
 * @author Sir Devin
 */
public class PopCountOverOddsMinusEvens
   implements SumFunction
{

   public BigDecimal evaluate(BigDecimal n)
   {
      BigDecimal twoN = n.multiply(new BigDecimal(2));
      BigDecimal divisor = twoN.multiply(twoN.add(new BigDecimal(1)));
      BigDecimal result = new BigDecimal(n.toBigInteger().bitCount()).divide(divisor,  SumLibrary.PRECISION,BigDecimal.ROUND_HALF_DOWN);
      return result;
   }
}
