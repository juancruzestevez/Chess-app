package WinCondition;

import Objects.Board;
import Objects.COLOR;
import Objects.Game;
import Objects.Point;

public class threeCheckWinCondition implements WinCondition{
    private int checkWhite = 0;
    private int checkBlack = 0;

    public threeCheckWinCondition() {
    }

    public void checkmate(COLOR color, Board board, Game game){
        for (Point point: board.getSquare()) {
            if (!point.isEmpty() && point.getPiece().getColor() == color && !board.getPosibleMovement(point).isEmpty()){
                return;
            }
        }
        game.setWinner(game.getOtherPlayer(color));
    }

    public void add(COLOR color, Game game){
        if (color == COLOR.WHITE){
            checkWhite += 1;
        }else{
            checkBlack += 1;
        }
    }

    public boolean threeCheck(COLOR color){
        if (color == COLOR.WHITE){
            return checkWhite == 3;
        }else{
            return checkBlack == 3;
        }
    }


    @Override
    public void hasWon(COLOR color, Game game) {
        if (game.getBoard().check(color)){
            add(color, game);
            if (threeCheck(color)){
                game.setWinner(game.getOtherPlayer(color));
                return;
            }
            checkmate(color, game.getBoard(), game);
        }
    }
}
