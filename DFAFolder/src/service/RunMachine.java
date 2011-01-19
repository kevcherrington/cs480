package service;

/**
 *
 * @author Devin
 */
public class RunMachine
{
    public static void main(String[] args)
   {
      for (String input : args)
      {
         new NeffMachine(input).run();
      }
   }
}
