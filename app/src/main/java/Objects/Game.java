package Objects;

import TurnsManager.TurnManager;
import WinCondition.WinCondition;
import builders.BoardBuilder;

import java.util.ArrayList;
import java.util.List;

public class Game implements Cloneable{
    final BoardBuilder boardBuilder;
    final WinCondition winCondition;
    final TurnManager turnManager;
    private final Player player1;
    private final Player player2;
    private Player winner = null;
    private Board board;

    private Player turn;
    private List<Piece> deadPieces;

    public Game(BoardBuilder boardBuilder, WinCondition winCondition, TurnManager turnManager, Player player1, Player player2) {
        this.boardBuilder = boardBuilder;
        this.winCondition = winCondition;
        this.turnManager = turnManager;
        this.player1 = player1;
        player1.setGame(this);
        this.player2 = player2;
        player2.setGame(this);
        turn = player1;
        deadPieces = new ArrayList<Piece>();
        board = boardBuilder.build();
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

    public Player getTurn() {
        return turn;
    }

    public List<Piece> getDeadPieces() {
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




    public void setDeadPieces(List<Piece> deadPieces){
        this.deadPieces = deadPieces;
    }

    @Override
    public Game clone() {
        try {
            return (Game) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
