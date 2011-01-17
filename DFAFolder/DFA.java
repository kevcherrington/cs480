
import java.util.*;

enum State
{
    q, q0, q00, q001;
}

class SC
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
      return (100 * mState.ordinal() + mChar);
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
      return mState.name() + "," + mChar;
   }
}

public class DFA
   implements Runnable
{
   static Set<State> cFinalStates;

   static Map<SC, State> cNextStateMap;

   static
   {
      cFinalStates = new HashSet<State>();
      cFinalStates.add(State.q001);

      cNextStateMap = new HashMap<SC, State>();
      cNextStateMap.put(new SC(State.q,    '0'), State.q0);
      cNextStateMap.put(new SC(State.q,    '1'), State.q);
      cNextStateMap.put(new SC(State.q0,   '0'), State.q00);
      cNextStateMap.put(new SC(State.q0,   '1'), State.q);
      cNextStateMap.put(new SC(State.q00,  '0'), State.q00);
      cNextStateMap.put(new SC(State.q00,  '1'), State.q001);
      cNextStateMap.put(new SC(State.q001, '0'), State.q001);
      cNextStateMap.put(new SC(State.q001, '1'), State.q001);
   }

   public static void main(String[] args)
   {
      for (String input : args)
      {
         new DFA(input).run();
      }
   }

   String mInput;
   int mNextInputIndex;
   State mCurrentState;
   Set<State> mFinalStates;
   Map<SC, State> mNextStateMap;

   DFA(String input)
   {
      this(input, 0, State.q, cFinalStates, cNextStateMap);
   }

   DFA(String input, int nextInputIndex,
       State currentState, Set<State> finalStates,
       Map<SC, State> nextStateMap)
   {
      mInput = input;
      mNextInputIndex = nextInputIndex;
      mCurrentState = currentState;
      mFinalStates = finalStates;
      mNextStateMap = nextStateMap;
      System.out.print(mCurrentState);
   }

   public void run()
   {
      while (hasMoreInput())
      {
         consumeInput();
      }
      returnAndReport();
   }

   private boolean hasMoreInput()
   {
      return (mNextInputIndex < mInput.length());
   }

   private void consumeInput()
   {
      char nextChar = mInput.charAt(mNextInputIndex);
      State nextState =
         mNextStateMap.get(new SC(mCurrentState, nextChar));
                                  
      if (nextState != null)
      {
         System.out.print("--" + nextChar + "-->" + nextState);
         mCurrentState = nextState;
         mNextInputIndex++;
      }
      else
      {
         // force exit from while loop in run()
         mNextInputIndex = mInput.length();
      }
   }

   private void returnAndReport()
   {
      if (mFinalStates.contains(mCurrentState))
      {
         System.out.println(", a final state, so ACCEPT.\n");
      }
      else
      {
         System.out.println(", NOT a final state, so REJECT.\n");
      }
   }
}
