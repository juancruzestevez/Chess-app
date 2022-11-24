package TurnsManager;

import Objects.COLOR;
import Objects.Game;
import Objects.Player;

public interface TurnManager {
    Player nextTurn(Game game, COLOR color);
}
