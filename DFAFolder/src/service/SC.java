package service;

/**
 *
 * @author Devin
 */
public class SC
{
   State mState;
   char mChar;

   SC(State state, char ch)
   {
      mState = state;
      mChar = ch;
   }

   public int hashCode()
   {
      return (100 * mState.hashCode() + mChar);
   }

   public boolean equals(Object object)
   {
      if (object instanceof SC)
      {
         SC sc = (SC) object;
         return ((mState == sc.mState) && (mChar == sc.mChar));
      }
      return false;
   }

   public String toString()
   {
      return mState.toString() + "," + mChar;
   }
}
