package movement;

import Objects.Board;

import Objects.Point;

public interface MoveValidator {
    boolean validate(Point originPoint, Point pointMove, Board board);

}
