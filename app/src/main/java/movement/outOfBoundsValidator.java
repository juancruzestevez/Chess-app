package movement;

import Objects.Board;
import Objects.Point;

public class outOfBoundsValidator implements MoveValidator{
    public outOfBoundsValidator() {
    }

    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        return originPoint != null && pointMove != null;
    }
}
