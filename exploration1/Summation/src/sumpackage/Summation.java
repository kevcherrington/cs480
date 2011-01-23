package sumpackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import res.SumLibrary;
import res.BigRational;

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
   /** 
    * The header to print at the top of the file.
    */
   private String mHeader;
   /** 
    * The file path to write to.
    */
   private String mFileName;
   private BigDecimal mStart;
   private BigDecimal mEnd;
   private BigInteger mSegment;
   private BigRational mLastSum;

   public Summation(SumFunction pFunction)
   {
      this(pFunction, SumLibrary.ZERO, SumLibrary.UPPER_BOUND,
         SumLibrary.TEN_MILLION);
   }

   public Summation(SumFunction pFunction, BigDecimal pStart)
   {
      this(pFunction, pStart, SumLibrary.UPPER_BOUND, SumLibrary.TEN_MILLION);
   }

   public Summation(SumFunction pFunction, BigDecimal pStart, BigDecimal pEnd)
   {
      this(pFunction, pStart, pEnd, SumLibrary.TEN_MILLION);
   }

   public Summation(SumFunction pFunction, BigDecimal pStart, BigDecimal pEnd,
      BigInteger pSegment)
   {
      this(pFunction, pStart, pEnd, pSegment, "sum");
   }

   public Summation(SumFunction pFunction, BigDecimal pStart, BigDecimal pEnd,
      BigInteger pSegment, String pFileName)
   {
      mHeader = "\\documentclass{article}\n"
         + "\\usepackage{times,amssymb,amsmath}\n"
         + "\\begin{document}\n";
      mFileName = pFileName + ".tex";
      mFunction = pFunction;
      mStart = pStart;
      mEnd = pEnd;
      mSegment = pSegment;
   }

   public BigRational sum()
   {
      return sum(mStart, mEnd, mEnd.toBigInteger());
   }

   public BigRational sumShow()
   {
      return sum(mStart, mEnd, mSegment);
   }

   public void show()
   {
      show(mStart, mEnd);
   }

   public void print()
   {
      print(mStart, new BigDecimal(250));
   }

   public BigRational sum(BigDecimal pEnd)
   {
      return sum(mStart, pEnd, pEnd.toBigInteger());
   }

   public void show(BigDecimal pEnd)
   {
      show(mStart, pEnd);
   }

   public void print(BigDecimal pEnd)
   {
      print(mStart, pEnd);
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
   public BigRational sum(BigDecimal pStart, BigDecimal pEnd,
      BigInteger pSegment)
   {
      BigRational total = new BigRational(0, 1);
      for (BigDecimal i = pStart; 0 != i.compareTo(pEnd); i = i.add(
            SumLibrary.ONE))
      {
         total = total.add(mFunction.evaluate(i));
         

         if (i.toBigInteger().mod(pSegment).equals(SumLibrary.BI_ZERO))
         {
            System.out.println(total.toBigDecimal());
         }
      }
      return total;
   }

   public void show(BigDecimal pStart, BigDecimal pEnd)
   {
      for (BigDecimal i = pStart; 0 != i.compareTo(pEnd); i = i.add(
            SumLibrary.ONE))
      {
         System.out.println(mFunction.evaluate(i).toFraction());
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
         output.write("$$" + mFunction.evaluate(pStart).toLatex() + " ");
         pStart = pStart.add(SumLibrary.ONE);

         //output the summation to the file
         for (BigDecimal i = pStart; 0 != i.compareTo(pEnd); i = i.add(
               SumLibrary.ONE))
         {
            output.write("+ " + mFunction.evaluate(i).toLatex() + " ");

            //when to print a new line
            if (i.toBigInteger().mod(line).equals(SumLibrary.BI_ZERO))
            {
               output.write("$$");
               output.newLine();
               output.write("$$");
            }
         }
         output.write("$$");
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
      print();
   }
}
