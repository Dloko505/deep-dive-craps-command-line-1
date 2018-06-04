package edu.cnm.deepdive.craps;

/**
 * This enum implements a finite state machine (FSM) for the shooter's play in
 * a game of Craps.
 *
 * @author Nicholas Bennett &amp; Deep Dive Coding Java Cohort 4
 */
public enum State {
  /** The state in which the come-out roll occurs. */
  INITIAL {
    @Override
    public State next(int roll, int point) {
      switch (roll) {
        case 2:
        case 3:
        case 12:
          return State.LOSS;
        case 7:
        case 11:
          return State.WIN;
        default:
          return State.POINT;
      }
    }
  },
  /** The state in which the shooter rolls to match the established point. */
  POINT {
    private static final String POINT_REQUIRES_POINT_MESSAGE =
        "The next(int) method is not valid for the POINT state.";
    @Override
    public State next(int roll, int point) {
      if (roll == 7) {
        return State.LOSS;
      } else if (roll == point) {
        return State.WIN;
      } else {
        return State.POINT;
      }
    }
    @Override
    public State next(int roll) {
      throw new IllegalStateException(POINT_REQUIRES_POINT_MESSAGE);
    }
  },
  /** The state after a natural (7 or 11) on the come-out roll, or after making the point on a later roll. */
  WIN,
  /** The state after crapping out: 2, 3, or 12 on the come-out roll, or 7 while attempting to make the point. */
  LOSS;

  /**
   * Given <code>this</code> state, a roll sum, and an established point (if
   * applicable), returns the state resulting from the specified roll.
   *
   * @param roll    Total of the dice in the current roll.
   * @param point   Established point.
   * @return        Resulting state.
   */
  public State next(int roll, int point) {
    return this;
  }

  /**
   * Given <code>this</code> state and a roll sum, returns the state resulting
   * from the specified roll.
   *
   * @param roll    Total of the dice in the current roll.
   * @return        Resulting state.
   */
  public State next(int roll) {
    return next(roll, 0);
  }

}
