package WinCondition;

import Objects.Board;
import Objects.COLOR;
import Objects.Game;
import Objects.Player;

public interface WinCondition {
    public void hasWon(COLOR color, Game game);
}
