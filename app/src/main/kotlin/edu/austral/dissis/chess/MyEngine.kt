package edu.austral.dissis.chess

import GameMode.Original
import Objects.COLOR
import Objects.Game
import Objects.Player
import edu.austral.dissis.chess.gui.*
import java.time.Clock
import java.util.*
import kotlin.collections.ArrayList

class MyEngine() : GameEngine {
    private val game: Game = Game(Player(COLOR.WHITE, "player1"), Player(COLOR.BLACK, "player2"), Original())
    override fun applyMove(move: Move): MoveResult {
        return try {
            if (game.winner != null){
                if(game.winner.color == COLOR.WHITE){
                    GameOver(PlayerColor.BLACK)
                }else{
                    GameOver(PlayerColor.WHITE)
                }
            }else{
                if (game.turn.color == COLOR.WHITE){
                    game.player1.MovePiece(game.board.indexOf(move.from.column,move.from.row), game.board.indexOf(move.to.column,move.to.row))
                    return NewGameState(chessPieces(),  PlayerColor.BLACK);
                }else{
                    game.player2.MovePiece(game.board.indexOf(move.from.column,move.from.row), game.board.indexOf(move.to.column,move.to.row))
                    return NewGameState(chessPieces(), PlayerColor.WHITE);
                }
            }
        }catch (e: Exception){
            InvalidMove(e.localizedMessage)
        }
    }

    override fun init(): InitialState {
        return InitialState(BoardSize(8, 8), chessPieces(), PlayerColor.WHITE)
    }

    fun chessPieces(): List<ChessPiece>{
        val listChessPieces = ArrayList<ChessPiece>()
        for (i in game.board.getSquare()){
            if (i.piece != null){
                if (i.piece.color == COLOR.WHITE){
                    listChessPieces.add(ChessPiece(i.piece.id.toString(), PlayerColor.WHITE , Position(i.y, i.x),
                        i.piece.type.toString().lowercase(Locale.getDefault())
                    ))
                }else{
                    listChessPieces.add(ChessPiece(i.piece.id.toString(), PlayerColor.BLACK , Position(i.y , i.x),
                        i.piece.type.toString().lowercase(Locale.getDefault())
                    ))
                }
            }
        }
        return listChessPieces
    }
}