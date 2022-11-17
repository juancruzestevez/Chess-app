package builders;

import GameMode.Original;
import Objects.COLOR;
import Objects.Game;
import Objects.Player;

public class GameBuilder {
    public static Game originalGame(){
        return new Game(new Player(COLOR.WHITE, "player1"), new Player(COLOR.WHITE, "player2"), new Original()) {
        };
    }
}
