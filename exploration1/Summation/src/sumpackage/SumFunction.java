package sumpackage;

import java.math.BigDecimal;

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
   BigDecimal evaluate(BigDecimal n);
}
