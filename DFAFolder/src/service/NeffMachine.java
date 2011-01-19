package service;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Devin
 */
public class NeffMachine
   extends DFA
{
   public NeffMachine(String input)
   {
      super(input);
      State q = new State("q");
      State q0 = new State("q0");
      State q00 = new State("q00");
      State q001 = new State("q001");

      mFinalStates = new HashSet<State>();
      mFinalStates.add(q001);

      mNextStateMap = new HashMap<SC, State>();
      mNextStateMap.put(new SC(q, '0'), q0);
      mNextStateMap.put(new SC(q, '1'), q);
      mNextStateMap.put(new SC(q0, '0'), q00);
      mNextStateMap.put(new SC(q0, '1'), q);
      mNextStateMap.put(new SC(q00, '0'), q00);
      mNextStateMap.put(new SC(q00, '1'), q001);
      mNextStateMap.put(new SC(q001, '0'), q001);
      mNextStateMap.put(new SC(q001, '1'), q001);

      mCurrentState = q;
   }
}
