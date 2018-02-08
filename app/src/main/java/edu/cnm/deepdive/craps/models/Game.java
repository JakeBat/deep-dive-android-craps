package edu.cnm.deepdive.craps.models;

/**
 *
 */
public class Game {

  private Craps craps;
  private long wins;
  private long losses;

  /**
   *
   */
  public Game() {
    craps = new Craps();
    reset();
  }

  /**
   *
   * @return
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
   *
   */
  public void reset() {
    wins = 0;
    losses = 0;
    craps.reset();
  }

  /**
   *
   * @return
   */
  public Craps getCraps() {
    return craps;
  }

  /**
   *
   * @return
   */
  public long getWins() {
    return wins;
  }

  /**
   *
   * @return
   */
  public long getLosses() {
    return losses;
  }

}
