package GameMode;

import Objects.Board;
import Objects.COLOR;
import Objects.Game;
import Objects.Player;

public interface GameMode {
    Board generateBoard();
    Player netxTurn(Game game, COLOR color);
    void hasWon(Player player, Board board, Game game);
}
