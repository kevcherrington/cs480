package service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class DFA
   implements Runnable
{
   String mInput;
   int mNextInputIndex;
   State mCurrentState;
   Set<State> mFinalStates;
   Map<SC, State> mNextStateMap;

   DFA(String input)
   {
      this(input, 0, new State(), new HashSet<State>(), new HashMap<SC, State>());
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

   }

   public void run()
   {
      System.out.print(mCurrentState);
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
