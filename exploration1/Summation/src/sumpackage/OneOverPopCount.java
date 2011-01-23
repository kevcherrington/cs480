package sumpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import res.BigRational;
import res.SumLibrary;
/**
 *
 * @author Sir Devin
 */
public class OneOverPopCount
   implements SumFunction
{

   public BigRational evaluate(BigDecimal n)
   {
      BigInteger num;
      BigInteger den;
      num = SumLibrary.ONE.toBigInteger();
      den = SumLibrary.popCount(n);
      return new BigRational(num, den);
   }
}
