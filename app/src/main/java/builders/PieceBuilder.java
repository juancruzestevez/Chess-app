package builders;

import Objects.COLOR;
import Objects.Piece;
import Objects.TypePiece;
import movement.*;

import java.util.ArrayList;
import java.util.List;

public class PieceBuilder {
    public static Piece pawnBuilder(int id, COLOR color){
        List<MoveValidator> strictvalidators = new ArrayList<>();
        List<MoveValidator> validators = new ArrayList<>();
        strictvalidators.add(new SameColorValidator());
        validators.add(new pawnValidator());
        return new Piece(id, TypePiece.PAWN, color, validators, strictvalidators);
    }
    public static Piece kingBuilder(int id,COLOR color){
        List<MoveValidator> strictvalidators = new ArrayList<>();
        List<MoveValidator> validators = new ArrayList<>();
        strictvalidators.add(new SameColorValidator());
        strictvalidators.add(new LimitValidator(1));
        validators.add(new HorizontalValidator());
        validators.add(new DiagonalValidator());
        validators.add(new VerticalValidator());
        return new Piece(id, TypePiece.KING, color, validators, strictvalidators);
    }
    public static Piece suicideKingBuilder(int id,COLOR color){
        List<MoveValidator> strictvalidators = new ArrayList<>();
        List<MoveValidator> validators = new ArrayList<>();
        strictvalidators.add(new LimitValidator(1));
        validators.add(new HorizontalValidator());
        validators.add(new DiagonalValidator());
        validators.add(new VerticalValidator());
        return new Piece(id, TypePiece.KING, color, validators, strictvalidators);
    }
    public static Piece queenBuilder(int id,COLOR color){
        List<MoveValidator> strictvalidators = new ArrayList<>();
        List<MoveValidator> validators = new ArrayList<>();
        strictvalidators.add(new SameColorValidator());
        strictvalidators.add(new LimitValidator(8));
        validators.add(new HorizontalValidator());
        validators.add(new VerticalValidator());
        validators.add(new DiagonalValidator());
        return new Piece(id, TypePiece.QUEEN, color, validators, strictvalidators);
    }
    public static Piece towerBuilder(int id,COLOR color){
        List<MoveValidator> strictvalidators = new ArrayList<>();
        List<MoveValidator> validators = new ArrayList<>();
        strictvalidators.add(new SameColorValidator());
        strictvalidators.add(new LimitValidator(8));
        validators.add(new HorizontalValidator());
        validators.add(new VerticalValidator());
        return new Piece(id, TypePiece.ROOK, color, validators, strictvalidators);
    }
    public static Piece bishopBuilder(int id, COLOR color){
        List<MoveValidator> strictvalidators = new ArrayList<>();
        List<MoveValidator> validators = new ArrayList<>();
        strictvalidators.add(new SameColorValidator());
        strictvalidators.add(new LimitValidator(8));
        validators.add(new DiagonalValidator());
        return new Piece(id, TypePiece.BISHOP, color, validators, strictvalidators);
    }
    public static Piece horseBuilder(int id, COLOR color){
        List<MoveValidator> strictvalidators = new ArrayList<>();
        List<MoveValidator> validators = new ArrayList<>();
        strictvalidators.add(new SameColorValidator());
        validators.add(new MultyJumpValidator(1,2));
        return new Piece(id, TypePiece.KNIGHT, color, validators, strictvalidators);
    }
    public static Piece horseJediBuilder(int id, COLOR color){
        List<MoveValidator> strictvalidators = new ArrayList<>();
        List<MoveValidator> validators = new ArrayList<>();
        strictvalidators.add(new SameColorValidator());
        strictvalidators.add(new LimitValidator(3));
        validators.add(new DiagonalValidator());
        validators.add(new HorizontalValidator());
        validators.add(new MultyJumpValidator(1,2));
        return new Piece(id, TypePiece.KNIGHT, color, validators, strictvalidators);
    }
}
