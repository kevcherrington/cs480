package sumpackage;

import java.math.BigDecimal;

import res.SumLibrary;

/**
 *
 * @author Devin
 */
public class ProofProblem
   implements SumFunction
{
   public BigDecimal evaluate(BigDecimal n)
   {
      return new BigDecimal(n.toBigInteger().bitCount()).
                     divide(n.multiply((n.add(SumLibrary.ONE))),SumLibrary.PRECISION,BigDecimal.ROUND_HALF_DOWN);
   }
}
