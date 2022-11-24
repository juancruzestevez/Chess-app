package movement;

import Objects.Board;
import Objects.COLOR;
import Objects.Point;

public class checkValidator{
    public static boolean validate(Point origin, Point newPoint, Board board) {
        COLOR color = origin.getPiece().getColor();
        Board clonedBoard = board.clone();
        clonedBoard = new Board(clonedBoard, origin, newPoint);
        return !clonedBoard.check(color);
    }
}
