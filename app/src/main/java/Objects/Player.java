package Objects;

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
    public void setCheck(boolean check){
    }

    public void MovePiece(Point origin, Point newPoint){
        if (game.getTurn() == this && origin.getPiece().getColor() == color){
            if (origin.getPiece().getType().equals(TypePiece.KING) && origin.equals(newPoint)){
                game.setWinner(game.getOtherPlayer(color));
            }else{
                if (game.getBoard().canMove(origin, newPoint)){
                    origin.getPiece().setMoved(true);
                    if (newPoint.getPiece() != null){
                        game.getDeadPieces().add(newPoint.getPiece());
                    }
                    game.setBoard(new Board(game.getBoard(), origin, newPoint));
                    game.getHistory().put(game.getHistory().size(), new History(game.getBoard(), game.getDeadPieces(), game.getTurn()));
                    game.setTurn(game.getGameMode().netxTurn(game, color));
                    game.check(game.getOtherPlayer(color));
                }
            }
        }
    }
}
