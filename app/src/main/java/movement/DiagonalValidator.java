package movement;

import Objects.Board;
import Objects.Point;

public class DiagonalValidator implements MoveValidator{

    public DiagonalValidator() {
    }

    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        int x = pointMove.getX() - originPoint.getX();
        int y = pointMove.getY() - originPoint.getY();
        if (Math.abs(x) == Math.abs(y)){
            for (int i = 1; i < Math.abs(x); i++) {
                if (board.indexOf(originPoint.getX() + (i * (x/Math.abs(x)) ), originPoint.getY() + (i * (y/Math.abs(y)))) != null){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }
}
