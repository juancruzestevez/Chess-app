package movement;

import Objects.Board;
import Objects.Point;

public class MultyJumpValidator implements MoveValidator{
    public final int fst;
    public final int snd;

    public MultyJumpValidator(int fst, int snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        int x = originPoint.getX() - pointMove.getX();
        int y = originPoint.getY() - pointMove.getY();
        return (Math.abs(x) == fst && Math.abs(y) == snd) || (Math.abs(y) == fst && Math.abs(x) == snd);
    }
}
