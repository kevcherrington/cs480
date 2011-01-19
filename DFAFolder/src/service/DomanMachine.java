package service;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Devin
 */
public class DomanMachine
   extends DFA
{
   public DomanMachine(String input)
   {
      super(input);

      State q1 = new State("q1");
      State q2 = new State("q2");
      State q3 = new State("q3");

      mFinalStates = new HashSet<State>();
      mFinalStates.add(q3);

      mNextStateMap = new HashMap<SC, State>();
      mNextStateMap.put(new SC(q1, '0'), q1);
      mNextStateMap.put(new SC(q1, '1'), q2);
      mNextStateMap.put(new SC(q2, '0'), q3);
      mNextStateMap.put(new SC(q2, '1'), q2);
      mNextStateMap.put(new SC(q3, '0'), q2);
      mNextStateMap.put(new SC(q3, '1'), q2);
  

      mCurrentState = q1;
   }
}
