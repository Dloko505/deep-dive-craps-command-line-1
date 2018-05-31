package edu.cnm.deepdive.craps;

public enum State {
  INITIAL {
    @Override
    public State next(Roll roll) {
      switch (roll.getSum()) {
        case 2:
        case 3:
        case 12:
          return State.LOSS;
        case 7:
        case 11:
          return State.WIN;
        default:
          State.POINT.point = roll.getSum();
          return State.POINT;
      }
    }
  },
  POINT {
    @Override
    public State next(Roll roll) {
      if (roll.getSum() == 7) {
        return State.LOSS;
      } else if (roll.getSum() == point) {
        return State.WIN;
      } else {
        return State.POINT;
      }
    }
  },
  WIN,
  LOSS,
  TERMINAL;

  protected int point;

  public State next(Roll roll) {
    return this;
  }

}



