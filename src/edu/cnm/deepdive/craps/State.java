package edu.cnm.deepdive.craps;

public enum State {
  INITIAL,
  WIN,
  LOSS,
  POINT,
  TERMINAL;

  private int point;

  public State next(Roll roll) {
    switch (this) {
      case INITIAL:
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
      case POINT:
        if (roll.getSum() == 7) {
          return State.LOSS;
        } else if (roll.getSum() == point) {
          return State.WIN;
        } else {
          return State.POINT;
        }
      default:
        return this;
    }
  }

}



