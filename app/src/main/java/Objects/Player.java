package Objects;

import builders.PieceBuilder;
import movement.MoveValidator;
import movement.checkValidator;

import java.util.Objects;

public class Player {
    private final COLOR color;
    private String name;
    private Game game;

    public Player(COLOR color, String name) {
        this.color = color;
        this.name = name;
        this.game = null;
    }

    public COLOR getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public void MovePiece(Point origin, Point newPoint){
        if (game.getTurn() == this && origin.getPiece().getColor() == color && game.getBoard().canMove(origin, newPoint)){
            origin.getPiece().setMoved(true);
            if (newPoint.getPiece() != null){
                game.getDeadPieces().add(newPoint.getPiece());
            }
            game.setBoard(new Board(game.getBoard(), origin, newPoint));
            if (game.getBoard().getPosibleMovement(newPoint).isEmpty() && (newPoint.getY() == 1 || newPoint.getY() == 8)){
                newPoint.setPiece(PieceBuilder.queenBuilder(newPoint.getPiece().getId(), newPoint.getPiece().getColor()));
            }
            game.setTurn(game.turnManager.nextTurn(game, color));
            game.winCondition.hasWon(game.getOtherPlayer(color).getColor(), game);
        }
    }
}


