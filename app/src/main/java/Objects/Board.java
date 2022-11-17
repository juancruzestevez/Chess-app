package Objects;

import java.util.ArrayList;
import java.util.List;

public class Board{
    public List<Point> square;
    public List<Piece> pieces;

    public Board() {
        square = new ArrayList<>();
        pieces = new ArrayList<>();
    }

    public Board(Board board, Point beforeChange, Point afterChange){
        square = board.getSquare();
        indexOf(afterChange.getX(), afterChange.getY()).setPiece(beforeChange.getPiece());
        indexOf(beforeChange.getX(), beforeChange.getY()).setPiece(null);
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



    public Point findPointByPiece(COLOR color, TypePiece typePiece){
        for (Point point : square) {
            if (point.getPiece() == null){
                continue;
            }else{
                if (point.getPiece().getColor() == color && point.getPiece().getType() == typePiece) {
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
        if (origin == newPoint){
            return false;
        }
        if (origin.getPiece() != null){
            for (int i = 0; i < origin.getPiece().getStrictValidator().size(); i++) {
                if (!origin.getPiece().getStrictValidator().get(i).validate(origin, newPoint, this)){
                    return false;
                }
            }
            if (origin.getPiece().moveValidators.size() == 0){
                return true;
            }
            for (int i = 0; i < origin.getPiece().moveValidators.size(); i++) {
                if (origin.getPiece().getMoveValidators().get(i).validate(origin, newPoint, this)) {
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }
}
