package edu.cnm.deepdive.craps;

import java.util.Random;

public class Roll {

  private static Random defaultRng;
  private int[] dice;

  public Roll() {
    // TODO Make thread-safe.
    this((defaultRng == null) ? (defaultRng = new Random()) : defaultRng);
  }

  public Roll(Random rng) {
    dice = new int[] {
        rng.nextInt(6) + 1,
        rng.nextInt(6) + 1
    };
  }

  public int[] getDice() {
    return new int[] {
        dice[0],
        dice[1]
    };
  }

  public int getSum() {
    return dice[0] + dice[1];
  }

  @Override
  public String toString() {
    return String.format("[%d-%d]", dice[0], dice[1]);
  }

}
