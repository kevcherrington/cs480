package service;

/**
 *
 * @author Devin
 */
public class State
{
   String mName;

   State()
   {
      this("");
   }
   
   State(String pName)
   {
      mName = pName;
   }

   public String toString()
   {
      return mName;
   }

   public int hashCode()
   {
      return mName.hashCode();
   }
}
