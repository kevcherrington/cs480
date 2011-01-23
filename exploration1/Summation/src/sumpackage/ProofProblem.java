package sumpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import res.BigRational;

import res.SumLibrary;

/**
 *
 * @author Devin
 */
public class ProofProblem
   implements SumFunction
{
   public BigRational evaluate(BigDecimal n)
   {
      BigInteger num;
      BigInteger den;

      num = SumLibrary.popCount(n);
      den = n.multiply((n.add(SumLibrary.ONE))).toBigInteger();

      return new BigRational(num, den);
   }
}
