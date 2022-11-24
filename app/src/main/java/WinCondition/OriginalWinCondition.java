package WinCondition;

import Objects.*;

public class OriginalWinCondition implements WinCondition{

    public OriginalWinCondition() {
    }

    public void checkmate(COLOR color, Board board, Game game){
        for (Point point: board.getSquare()) {
            if (!point.isEmpty() && point.getPiece().getColor() == color && !board.getPosibleMovement(point).isEmpty()){
                return;
            }
        }
        game.setWinner(game.getOtherPlayer(color));
    }

    public void hasWon(COLOR color, Game game) {
        if (game.getBoard().check(color)){
            checkmate(color, game.getBoard(), game);
        }
    }
}
