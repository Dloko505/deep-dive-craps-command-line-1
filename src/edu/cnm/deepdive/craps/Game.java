package edu.cnm.deepdive.craps;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game {

  private State currentState = State.INITIAL;
  private List<Roll> rolls = new LinkedList<>();

  public State play(Random rng) {
    if (currentState == State.INITIAL) {
      Roll roll = new Roll(rng);
      currentState = currentState.next(roll);
      rolls.add(roll);
      while (currentState == State.POINT) {
        roll = new Roll(rng);
        rolls.add(roll);
        currentState = currentState.next(roll);
      }
    }
    return currentState;
  }

  public State getCurrentState() {
    return currentState;
  }

  public Roll[] getRolls() {
    return rolls.toArray(new Roll[rolls.size()]);
  }

}















