import java.math.BigInteger;
import java.math.BigDecimal;

class ExplorationOne
{
   private static final BigDecimal ONE = new BigDecimal(1);
   private static final BigDecimal UPPER_BOUND = new BigDecimal(new BigInteger("10000000000000000000000000"));
   private static final BigDecimal ZERO = new BigDecimal(0);
   private static final BigInteger BI_ZERO = new BigInteger("0");
   private static final BigInteger TEN_MILLION = new BigInteger("10000000");
   private static final int INT_ZERO = 0;
   private static final int PRECISION = 100;

   public ExplorationOne()
   {

   }
   
   private BigDecimal compute(BigDecimal n)
   {
      return new BigDecimal(n.toBigInteger().bitCount()).
                     divide(n.multiply((n.add(ONE))),PRECISION,BigDecimal.ROUND_HALF_DOWN);
   }
   public void run()
   {
      BigDecimal total = ZERO;

      for (BigDecimal i = ONE; 0 != i.compareTo(UPPER_BOUND); i = i.add(ONE))
      {
         total = total.add(compute(i));

         if (i.toBigInteger().mod(TEN_MILLION).equals(BI_ZERO))     
            System.out.println(total);
      }
   }
   public static void main(String[] args)
   {
      new ExplorationOne().run();
   }
}
