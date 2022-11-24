package TurnsManager;

import Objects.COLOR;
import Objects.Game;
import Objects.Player;

public class OriginalTurnManager implements TurnManager{

    public Player nextTurn(Game game, COLOR color) {
        if (game.getPlayer1().getColor() == color){
            return game.getPlayer2();
        }else{
            return game.getPlayer1();
        }
    }
}
