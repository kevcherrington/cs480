package sumpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import res.SumLibrary;

/**
 *
 * @author Devin
 */
public class Summation
   implements Runnable
{
   /**
    * The closed form function to run through a summation
    */
   private SumFunction mFunction;

   public BigDecimal sum(BigDecimal pStart, BigDecimal pEnd)
   {
      return sum(pStart, pEnd, pEnd.toBigInteger());
   }

   /**
    * Evaluate the summation of mFunction from pStart to pEnd, printing
    * to the console every pPrint sums.
    * 
    * @param pStart
    * @param pEnd
    * @param pPrint
    * @return
    */
   public BigDecimal sum(BigDecimal pStart, BigDecimal pEnd, BigInteger pPrint)
   {
      BigDecimal total = new BigDecimal(0);

      for (BigDecimal i = pStart; 0 != i.compareTo(pEnd); i = i.add(SumLibrary.ONE))
      {
         total = total.add(mFunction.evaluate(i));

         if (i.toBigInteger().mod(pPrint).equals(SumLibrary.BI_ZERO))
         {
            System.out.println(total);
         }
      }     
      return total;
   }

   public void show()
   {
   }

   public void print()
   {
   }

   public void run()
   {
      mFunction = new ProofProblem();
      sum(SumLibrary.ONE, SumLibrary.UPPER_BOUND, SumLibrary.TEN_MILLION);
   }

   public static void main(String[] args)
   {
      new Summation().run();
   }
}
