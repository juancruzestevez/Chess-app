package movement;

import Objects.Board;
import Objects.Point;

public class HorizontalValidator implements MoveValidator{


    public HorizontalValidator() {

    }
    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        if (originPoint.getY() == pointMove.getY()){
            int x =pointMove.getX() - originPoint.getX();
            for (int i = 1; i < Math.abs(x); i++) {
                if (board.indexOf((originPoint.getX() + (i * (x/Math.abs(x)))), pointMove.getY()).getPiece() != null){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
