package movement;

import Objects.Board;
import Objects.Point;

public class pawnValidator implements MoveValidator{

    private final MoveValidator limitv1;
    private final MoveValidator limitv2;
    private final MoveValidator fowardv;
    private final MoveValidator verticalv;
    private final MoveValidator diagonalv;

    public pawnValidator() {
        limitv1 = new LimitValidator(1);
        limitv2 = new LimitValidator(2);
        fowardv = new FowardValidator();
        verticalv = new VerticalValidator();
        diagonalv = new DiagonalValidator();
    }

    @Override
    public boolean validate(Point originPoint, Point pointMove, Board board) {
        if(fowardv.validate(originPoint, pointMove, board)){
            if(pointMove.getPiece() != null){
                return diagonalv.validate(originPoint, pointMove, board) && limitv1.validate(originPoint, pointMove, board);
            }else{
                if (!originPoint.getPiece().getMoved()){
                    return verticalv.validate(originPoint, pointMove, board) && limitv2.validate(originPoint, pointMove, board);
                }else{
                    return verticalv.validate(originPoint, pointMove, board) && limitv1.validate(originPoint, pointMove, board);
                }
            }
        }else{
            return false;
        }
    }
}
