package movement;

import Objects.Board;
import Objects.Point;

public class LimitValidator implements MoveValidator{

    int limit;

    public LimitValidator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        int x = pointMove.getX() - originPoint.getX();
        int y = pointMove.getY() - originPoint.getY();
        return Math.abs(x) <= limit && Math.abs(y) <= limit;
    }
}
