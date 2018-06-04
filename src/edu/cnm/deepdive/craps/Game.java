package edu.cnm.deepdive.craps;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {

  private State state;
  private List<Roll> rolls;

  public Game() {
    rolls = new LinkedList<>();
    reset();
  }

  public State play(Random rng) {
    if (state != State.INITIAL) {
      throw new IllegalStateException("Game.play() may only be invoked in State.INITIAL.");
    }
    Roll roll = new Roll(rng);
    int point = roll.getSum();
    rolls.add(roll);
    state = state.next(roll.getSum(), point);
    while (state == State.POINT) {
      roll = new Roll(rng);
      rolls.add(roll);
      state = state.next(roll.getSum(), point);
    }
    return state;
  }

  public State getState() {
    return state;
  }

  public Roll[] getRolls() {
    return rolls.toArray(new Roll[rolls.size()]);
  }

  public void reset() {
    state = State.INITIAL;
    rolls.clear();
  }

}
