package edu.austral.dissis.chess

import Objects.COLOR
import Objects.Game
import Objects.Player
import TurnsManager.OriginalTurnManager
import WinCondition.OriginalWinCondition
import WinCondition.threeCheckWinCondition
import builders.GameBuilder
import builders.OriginalBoardBuilder
import edu.austral.dissis.chess.gui.*
import java.util.*
import kotlin.collections.ArrayList

class MyEngine() : GameEngine {
    private val game: Game = GameBuilder.Jedi()

    fun nextTurn(game:Game): PlayerColor{
        if (game.turn.color == COLOR.WHITE){
            return PlayerColor.WHITE
        }else{
            return PlayerColor.BLACK
        }
    }

    override fun applyMove(move: Move): MoveResult {
        return try {
            if (game.turn.color == COLOR.WHITE){
                game.player1.MovePiece(game.board.indexOf(move.from.column,move.from.row), game.board.indexOf(move.to.column,move.to.row))
                if (game.winner != null){
                    GameOver(PlayerColor.WHITE)
                }else{
                    return NewGameState(chessPieces(),  nextTurn(game));
                }
            }else{
                game.player2.MovePiece(game.board.indexOf(move.from.column,move.from.row), game.board.indexOf(move.to.column,move.to.row))
                if (game.winner != null){
                    GameOver(PlayerColor.BLACK)
                }else{
                    return NewGameState(chessPieces(),  nextTurn(game));
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