package sumpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
   /** The header to print at the top of the file. */
   protected String mHeader;
   /** The file path to write to. */
   private String mFileName;

   public Summation()
   {
      mHeader = "\\documentclass{article}\n"
         + "\\usepackage{times,amssymb,amsmath}\n"
         + "\\begin{document}\n";
      mFileName = "sum.tex";
   }

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

      for (BigDecimal i = pStart; 0 != i.compareTo(pEnd); i = i.add(
            SumLibrary.ONE))
      {
         total = total.add(mFunction.evaluate(i));

         if (i.toBigInteger().mod(pPrint).equals(SumLibrary.BI_ZERO))
         {
            System.out.println(total);
         }
      }
      return total;
   }

   public void show(BigDecimal pStart, BigDecimal pEnd)
   {
      for (BigDecimal i = pStart; 0 != i.compareTo(pEnd); i = i.add(
            SumLibrary.ONE))
      {
         System.out.println(SumLibrary.toFraction(mFunction.evaluate(i)));
      }
   }

   /**
    * Writes the summation as a latex file
    * 
    * @param pStart
    * @param pEnd
    */
   public void print(BigDecimal pStart, BigDecimal pEnd)
   {
      try
      {
         boolean isFile = new File(mFileName).exists();

         //
         // The file to open is mFileName, true sets to append mode
         //

         BufferedWriter output = new BufferedWriter(new FileWriter(mFileName,
            true));
         BigInteger line = new BigInteger("10");

         //if the file doesn't exist print a header
         if (!isFile)
         {
            output.write(mHeader);
            output.newLine();
         }

         //output the summation to the file
         for (BigDecimal i = pStart; 0 != i.compareTo(pEnd); i = i.add(
               SumLibrary.ONE))
         {
            output.write(SumLibrary.toLatex(mFunction.evaluate(i)) + " ");

            //when to print a new line
            if (i.toBigInteger().mod(line).equals(SumLibrary.BI_ZERO))
            {
               output.newLine();
            }
         }
         output.newLine();
         output.write("\\end{document}");
         output.close();
      }
      catch (IOException e)
      {
         System.err.println(e.getLocalizedMessage());
      }
   }

   public void run()
   {
      mFunction = new ProofProblem();
      //sum(SumLibrary.ONE, SumLibrary.UPPER_BOUND, SumLibrary.TEN_MILLION);
      show(SumLibrary.ONE, new BigDecimal(10));

      //System.out.println(SumLibrary.toFraction(new BigDecimal(1.5)));

   }

   public static void main(String[] args)
      throws IOException
   {
      new Summation().run();
      
   }
}
