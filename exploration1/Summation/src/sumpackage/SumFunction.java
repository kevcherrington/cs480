package sumpackage;

import java.math.BigDecimal;
import res.BigRational;

/**
 *
 * @author Devin
 */
public interface SumFunction
{
   /**
    * Evaluate this closed form function at the value n
    * 
    * @param n
    * @return f(n)
    */
   public BigRational evaluate(BigDecimal n);
}
