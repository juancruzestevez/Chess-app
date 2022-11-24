package builders;

import Objects.COLOR;
import Objects.Game;
import Objects.Player;
import TurnsManager.OriginalTurnManager;
import WinCondition.OriginalWinCondition;
import WinCondition.threeCheckWinCondition;

public class GameBuilder {
    public static Game originalGame(){
        return new Game(new OriginalBoardBuilder(), new OriginalWinCondition(), new OriginalTurnManager(), new Player(COLOR.WHITE, "player1"), new Player(COLOR.BLACK, "player2")) {
        };
    }

    public static Game threeCheckChess(){
        return new Game(new OriginalBoardBuilder(), new threeCheckWinCondition(), new OriginalTurnManager(), new Player(COLOR.WHITE, "player1"), new Player(COLOR.BLACK, "player2")) {
        };
    }

    public static Game Jedi(){
        return new Game(new JediBoardBuilder(), new OriginalWinCondition(), new OriginalTurnManager(), new Player(COLOR.WHITE, "player1"), new Player(COLOR.BLACK, "player2")) {
        };
    }
}
