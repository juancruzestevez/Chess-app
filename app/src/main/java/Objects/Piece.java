package Objects;

import movement.MoveValidator;

import java.util.ArrayList;
import java.util.List;

public class Piece implements Cloneable{
    final int id;
    private final TypePiece type;
    private Boolean moved = false;
    private final COLOR color;
    public List<MoveValidator> moveValidators;
    public List<MoveValidator> strictValidator;
    public Piece(int id, TypePiece type, COLOR color, List<MoveValidator> moveValidators, List<MoveValidator> strictValidator) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.moveValidators = moveValidators;
        this.strictValidator = strictValidator;
    }
    public TypePiece getType() {
        return type;
    }
    public Boolean getMoved() {
        return moved;
    }
    public COLOR getColor() {
        return color;
    }
    public int getId() {
        return id;
    }
    public List<MoveValidator> getMoveValidators() {
        return moveValidators;
    }
    public List<MoveValidator> getStrictValidator() {
        return strictValidator;
    }
    public void setMoved(Boolean moved) {
        this.moved = moved;
    }
    @Override
    public Piece clone() {
        try {
            return (Piece) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
