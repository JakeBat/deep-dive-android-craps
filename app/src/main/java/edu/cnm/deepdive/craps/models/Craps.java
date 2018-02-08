package edu.cnm.deepdive.craps.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * A class that contains the basic logic for the game of craps.
 */
public class Craps {

  private State state = State.COME_OUT;
  private Random rng = new Random();
  private List<int[]> rolls = new LinkedList<>();

  /**
   * Gets a copy of the <code>List<int[]></code> that was created by the <code>play</code>
   * method.
   *
   * @return Returns a <code>List<int[]></code>
   */
  public List<int[]> getRolls() {
    List<int[]> copy = new LinkedList<>(rolls);
    return copy;
  }

  /**
   * Resets the <code>State</code> to <code>COME_OUT</code>
   */
  protected void reset() {
    state = State.COME_OUT;
    rolls.clear();
  }

  /**
   *Returns either the <code>WIN</code> or <code>LOSS</code> state based on
   * the <code>roll</code> method.
   *
   * @return Returns a <code>State</code>
   */
  public State play() {
    reset();
    do {
      roll();
    } while (state == State.POINT);
    return state;
  }

  /**
   * Returns the sum of the two <code>dice</code> "rolls"
   *
   * @return Returns a int
   */
  protected int roll() {
    int[] dice = {
        1 + rng.nextInt(6),
        1 + rng.nextInt(6),
    };
    int sum = dice[0] + dice[1];
    rolls.add(dice);
    state = state.roll(sum);
    return sum;
  }

  /**
   * Gets the current <code>State</code>
   *
   * @return Returns the current <code>State</code>
   */
  public State getState() {
    return state;
  }

  /**
   * Enum that contains the possible <code>State</code>'s for the game.
   *
   */
  public enum State {
    COME_OUT, WIN, LOSS, POINT, TERMINAL;

    private int point = 0;

    /**
     * The actual logic the game uses when it "plays"
     *
     * @param diceSum int used to determine the <code>State</code> of the game.
     * @return Returns a <code>State</code>
     */
    public State roll(int diceSum) {
      switch (this) {
        case COME_OUT:
          switch (diceSum) {
            case 2:
            case 3:
            case 12:
              return LOSS;
            case 7:
            case 11:
              return WIN;
            default:
              POINT.point = diceSum;
              return POINT;
          }
        case POINT:
          if (diceSum == point) {
            return WIN;
          } else if (diceSum == 7) {
            return LOSS;
          } else {
            return this;
          }
        default:
          return this;
      }
    }

    /**
     * Makes the game play again
     *
     * @return Returns the current instance
     */
    public State playAgain() {
      if (this == WIN || this == LOSS) {
        return COME_OUT;
      } else {
        return this;
      }
    }

    /**
     * Gives the option to terminate a game mid play
     *
     * @return Returns the current instance
     */
    public State surrender() {
      if (this != COME_OUT) {
        return TERMINAL;
      } else {
        return this;
      }
    }

  }

}
