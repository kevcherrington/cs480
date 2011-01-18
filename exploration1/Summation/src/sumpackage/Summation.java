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

   public BigDecimal evaluate(BigDecimal pStart, BigDecimal pEnd)
   {
      BigDecimal total = new BigDecimal(0);

      for (BigDecimal i = pStart; 0 != i.compareTo(pEnd); i = i.add(SumLibrary.ONE))
      {
         total = total.add(mFunction.evaluate(i));
      }
      return total;
   }

   public BigDecimal evaluate(BigDecimal pStart, BigDecimal pEnd, BigInteger pPrint)
   {
      BigDecimal total = new BigDecimal(0);

      for (BigDecimal i = pStart; 0 != i.compareTo(pEnd); i = i.add(SumLibrary.ONE))
      {
         total = total.add(mFunction.evaluate(i));

         if (i.toBigInteger().mod(SumLibrary.TEN_MILLION).equals(SumLibrary.BI_ZERO))
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
      evaluate(SumLibrary.ONE, SumLibrary.UPPER_BOUND, SumLibrary.TEN_MILLION);
   }

   public static void main(String[] args)
   {
      new Summation().run();
   }
}
