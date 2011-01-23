package sumpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import res.BigRational;
import res.SumLibrary;

/**
 *
 * @author Sir Devin
 */
public class PopCountOverOddsMinusEvens
   implements SumFunction
{

   public BigRational evaluate(BigDecimal n)
   {
      BigDecimal twoN = n.multiply(new BigDecimal(2));
      BigInteger num = SumLibrary.popCount(n);
      BigInteger den = twoN.multiply(twoN.add(new BigDecimal(1))).toBigInteger();
      return new BigRational(num, den);
   }
}
