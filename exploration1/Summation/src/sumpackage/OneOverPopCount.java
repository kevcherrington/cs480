package sumpackage;

import java.math.BigDecimal;
import res.SumLibrary;
/**
 *
 * @author Sir Devin
 */
public class OneOverPopCount
   implements SumFunction
{

   public BigDecimal evaluate(BigDecimal n)
   {
      return SumLibrary.ONE.divide(new BigDecimal(n.toBigInteger().bitCount()), SumLibrary.PRECISION,BigDecimal.ROUND_HALF_DOWN);
   }
}
