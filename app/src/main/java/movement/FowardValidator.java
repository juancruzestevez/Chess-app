package movement;

import Objects.Board;
import Objects.COLOR;
import Objects.Point;

public class FowardValidator implements MoveValidator{

    public FowardValidator() {

    }

    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        if (originPoint.getPiece().getColor() == COLOR.WHITE){
            return originPoint.getY() - pointMove.getY() < 0;
        }else {
            return originPoint.getY() - pointMove.getY() > 0;
        }
    }
}
