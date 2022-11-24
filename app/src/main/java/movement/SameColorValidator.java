package movement;

import Objects.Board;
import Objects.Point;

public class SameColorValidator implements MoveValidator{
    public SameColorValidator() {
    }

    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        if (pointMove.getPiece() == null){
            return true;
        }else{
            return !(originPoint.getPiece().getColor() == pointMove.getPiece().getColor());
        }
    }
}
