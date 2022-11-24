package movement;

import Objects.Board;
import Objects.Point;

public class VerticalValidator implements MoveValidator{

    public VerticalValidator() {

    }

    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        if (originPoint.getX() == pointMove.getX()){
            int y =pointMove.getY() - originPoint.getY();
            for (int i = 1; i < Math.abs(y); i++) {
                if (board.indexOf(pointMove.getX(), originPoint.getY() + (i * (y/Math.abs(y)))).getPiece() != null){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
