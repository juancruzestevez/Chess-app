package Objects;

import GameMode.GameMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private final Player player1;
    private final Player player2;
    private Player winner = null;
    private Board board;
    private final GameMode gameMode;
    private final Map<Integer, History> history;
    private Player turn;
    private final ArrayList<Piece> deadPieces;

    public Game(Player player1, Player player2, GameMode gameMode) {
        this.player1 = player1;
        player1.setGame(this);
        this.player2 = player2;
        player2.setGame(this);
        turn = player1;
        history = new HashMap<Integer,History>();
        deadPieces = new ArrayList<Piece>();
        this.gameMode = gameMode;
        board = gameMode.generateBoard();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getWinner() {
        return winner;
    }

    public Board getBoard() {
        return board;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public Map<Integer, History> getHistory() {
        return history;
    }

    public Player getTurn() {
        return turn;
    }

    public ArrayList<Piece> getDeadPieces() {
        return deadPieces;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setTurn(Player turn) {
        this.turn = turn;
    }

    public Player getOtherPlayer(COLOR color){
        if (player1.getColor() == color){
            return player2;
        }else{
            return player1;
        }
    }

    public void check(Player player){
        Point kingPoint = board.findPointByPiece(player.getColor(), TypePiece.KING);
        for (int i = 0; i < board.getSquare().size(); i++) {
            if (board.getSquare().get(i).getPiece() == null){
                continue;
            }else{
                if (board.getSquare().get(i).getPiece().getColor() != player.getColor()){
                    if (board.canMove(board.getSquare().get(i), kingPoint)){
                        player.setCheck( true);
                        gameMode.hasWon(player, board, this);
                    }
                }
            }
        }
    }
}
