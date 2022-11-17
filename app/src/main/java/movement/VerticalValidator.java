package movement;

import Objects.Board;
import Objects.Point;

public class VerticalValidator implements MoveValidator{

    public VerticalValidator() {

    }

    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        if (originPoint.getX() == pointMove.getX()){
            if (pointMove.getY() - originPoint.getY() > 0) {
                for (int i = originPoint.getY() + 1; i < pointMove.getY(); i++) {
                    if (board.indexOf(pointMove.getX(), i).getPiece() != null) {
                        return false;
                    }
                }
                return true;
            }else{
                for (int i = originPoint.getY() - 1; i > pointMove.getY(); i--) {
                    if (board.indexOf(pointMove.getX(), i).getPiece() != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
