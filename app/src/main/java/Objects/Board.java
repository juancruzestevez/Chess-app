package Objects;

import movement.checkValidator;

import java.util.ArrayList;
import java.util.List;

public class Board{
    private final List<Point> square;
    private List<Piece> pieces;
    public Board() {
        square = new ArrayList<>();
        pieces = new ArrayList<>();
    }
    public Board(Board board, Point beforeChange, Point afterChange){
        square = board.getSquare();
        indexOf(afterChange.getX(),afterChange.getY()).setPiece(beforeChange.getPiece().clone());
        indexOf(beforeChange.getX(),beforeChange.getY()).setPiece(null);
    }
    public void add(Point point){
        square.add(point);
        if (point.getPiece() != null){
            pieces.add(point.getPiece());
        }
    }
    public Point indexOf(int x, int y){
        for (Point point : square) {
            if (point.getX() == x && point.getY() == y) {
                return point;
            }
        }
        return null;
    }
    public Point findKing(COLOR color){
        for (Point point : square) {
            if (point.getPiece() == null){
                continue;
            }else{
                if (point.getPiece().getColor() == color && point.getPiece().getType() == TypePiece.KING) {
                    return point;
                }
            }
        }
        return null;
    }

    public List<Point> getSquare() {
        return square;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public boolean canMove(Point origin, Point newPoint){
        try {
            if (origin == newPoint){
                return false;
            }
            for (int i = 0; i < origin.getPiece().getStrictValidator().size(); i++){
                if (!origin.getPiece().getStrictValidator().get(i).validate(origin, newPoint, this)){
                    return false;
                }
            }
            for (int i = 0; i < origin.getPiece().moveValidators.size(); i++) {
                if (origin.getPiece().getMoveValidators().get(i).validate(origin, newPoint, this) && checkValidator.validate(origin, newPoint, this)) {
                    return true;
                }
            }
            return false;
        }catch (NullPointerException e){
            return false;
        }
    }

    public boolean check(COLOR color){
        Point kingPoint = findKing(color);
        for (Point point : square) {
            if (point.getPiece() == null) {
                continue;
            } else {
                if (point.getPiece().getColor() != color) {
                    if (canMove(point, kingPoint)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Point> getPosibleMovement(Point point){
        ArrayList<Point> posibleMovement = new ArrayList<>();
        if (point.getPiece() != null){
            for (Point value : square) {
                if (canMove(point, value)) {
                    posibleMovement.add(value);
                }
            }
        }
        return posibleMovement;
    }
    public Board clone() {
        Board clonedBoard = new Board();
        for(Point point: square){
            if (point.getPiece() != null){
                clonedBoard.add(new Point(point.getX(), point.getY(), point.getPiece().clone()));
            }else{
                clonedBoard.add(new Point(point.getX(), point.getY(), null));
            }
        }
        return clonedBoard;
    }
}
