package edu.cnm.deepdive.craps.models;

/**
 * Class that implement the logic from the <code>Craps</code> class to simulate a game of Craps
 */
public class Game {

  private Craps craps;
  private long wins;
  private long losses;

  /**
   * Creates a new instance of the <code>Craps</code> class
   */
  public Game() {
    craps = new Craps();
    reset();
  }

  /**
   * "Plays" a  game of Craps
   *
   * @return Returns a State
   */
  public Craps.State play() {
    Craps.State result = craps.play();
    if (result == Craps.State.WIN) {
      wins++;
    } else {
      losses++;
    }
    return result;
  }

  /**
   * Resets the wins and losses tallies as well as call the <code>reset</code> method
   */
  public void reset() {
    wins = 0;
    losses = 0;
    craps.reset();
  }

  /**
   * Gets an instance of the <code>Craps</code> class
   *
   * @return Returns an instance of the <code>Craps</code> class
   */
  public Craps getCraps() {
    return craps;
  }

  /**
   * Gets the current <code>wins</code> tally.
   *
   * @return Returns the current <code>wins</code> tally.
   */
  public long getWins() {
    return wins;
  }

  /**
   * Gets the current <code>losses</code> tally.
   *
   * @return Returns the current <code>losses</code> tally.
   */
  public long getLosses() {
    return losses;
  }

}
