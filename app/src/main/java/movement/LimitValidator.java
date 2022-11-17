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
        return (-limit <= pointMove.getX() - originPoint.getX() && pointMove.getX() - originPoint.getX() <= limit) || (-limit <= pointMove.getY() - originPoint.getY() && pointMove.getY() - originPoint.getY() <= limit);
    }
}
