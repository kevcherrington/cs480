package sumpackage;

import java.math.BigDecimal;
import res.BigRational;
import res.SumLibrary;
/**
 *
 * @author Devin
 */
public class HarmonicNumber 
   implements SumFunction
{
   public BigRational evaluate(BigDecimal n)
   {
      return new BigRational(SumLibrary.ONE.toBigInteger(), n.toBigInteger());
   }
}
