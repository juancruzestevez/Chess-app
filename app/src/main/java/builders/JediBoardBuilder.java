package builders;

import Objects.Board;
import Objects.COLOR;
import Objects.Point;

public class JediBoardBuilder implements BoardBuilder{

    public JediBoardBuilder() {
    }
    @Override
    public Board build() {
        Board board = new Board();
        board.add(new Point(1,1, PieceBuilder.towerBuilder(1, COLOR.WHITE)));
        board.add(new Point(2,1, PieceBuilder.horseJediBuilder(2, COLOR.WHITE)));
        board.add(new Point(3,1, PieceBuilder.bishopBuilder(3, COLOR.WHITE)));
        board.add(new Point(4,1, PieceBuilder.queenBuilder(4, COLOR.WHITE)));
        board.add(new Point(5,1, PieceBuilder.kingBuilder(5, COLOR.WHITE)));
        board.add(new Point(6,1, PieceBuilder.bishopBuilder(6, COLOR.WHITE)));
        board.add(new Point(7,1, PieceBuilder.horseJediBuilder(7, COLOR.WHITE)));
        board.add(new Point(8,1, PieceBuilder.towerBuilder(8, COLOR.WHITE)));
        board.add(new Point(1,2, PieceBuilder.pawnBuilder(9, COLOR.WHITE)));
        board.add(new Point(2,2, PieceBuilder.pawnBuilder(10, COLOR.WHITE)));
        board.add(new Point(3,2, PieceBuilder.pawnBuilder(11, COLOR.WHITE)));
        board.add(new Point(4,2, PieceBuilder.pawnBuilder(12, COLOR.WHITE)));
        board.add(new Point(5,2, PieceBuilder.pawnBuilder(13, COLOR.WHITE)));
        board.add(new Point(6,2, PieceBuilder.pawnBuilder(14, COLOR.WHITE)));
        board.add(new Point(7,2, PieceBuilder.pawnBuilder(15, COLOR.WHITE)));
        board.add(new Point(8,2, PieceBuilder.pawnBuilder(16, COLOR.WHITE)));
        for (int i = 2; i < 6 ; i++) {
            for (int j = 0; j < 8; j++) {
                board.getSquare().add(new Point(j+1,i+1, null));
            }
        }
        board.add(new Point(1,7, PieceBuilder.pawnBuilder(17, COLOR.BLACK)));
        board.add(new Point(2,7, PieceBuilder.pawnBuilder(18, COLOR.BLACK )));
        board.add(new Point(3,7, PieceBuilder.pawnBuilder(19, COLOR.BLACK )));
        board.add(new Point(4,7, PieceBuilder.pawnBuilder(20, COLOR.BLACK )));
        board.add(new Point(5,7, PieceBuilder.pawnBuilder(21, COLOR.BLACK )));
        board.add(new Point(6,7, PieceBuilder.pawnBuilder(22, COLOR.BLACK )));
        board.add(new Point(7,7, PieceBuilder.pawnBuilder(23, COLOR.BLACK )));
        board.add(new Point(8,7, PieceBuilder.pawnBuilder(24, COLOR.BLACK )));
        board.add(new Point(1,8, PieceBuilder.towerBuilder(25, COLOR.BLACK)));
        board.add(new Point(2,8, PieceBuilder.horseJediBuilder(26, COLOR.BLACK)));
        board.add(new Point(3,8, PieceBuilder.bishopBuilder(27, COLOR.BLACK)));
        board.add(new Point(4,8, PieceBuilder.queenBuilder(28, COLOR.BLACK )));
        board.add(new Point(5,8, PieceBuilder.kingBuilder(29, COLOR.BLACK  )));
        board.add(new Point(6,8, PieceBuilder.bishopBuilder(30, COLOR.BLACK)));
        board.add(new Point(7,8, PieceBuilder.horseJediBuilder(31, COLOR.BLACK )));
        board.add(new Point(8,8, PieceBuilder.towerBuilder(32,COLOR.BLACK )));
        return board;
    }
}
