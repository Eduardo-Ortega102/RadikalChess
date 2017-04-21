package model.pieces;

import model.Board;
import model.Movement;
import model.Piece;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class King implements Piece {
    private final Board board;
    private Position position;

    public King(Board board, Position position) {
        this.board = board;
        this.position = position;
    }

    @Override
    public List<Movement> possibleMovements() {
        List<Movement> movements = new ArrayList<>();
        for (Position position : positions())
            if (board.exist(position) && (board.isEmpty(position) || board.canCapture(position)))
                movements.add(new Movement(this.position, position));
        return movements;
    }

    private Position[] positions() {
        return new Position[]{
                position.forward(),
                position.forwardAndLeft(),
                position.forwardAndRight(),
                position.left(),
                position.right(),
                position.backward(),
                position.backwardAndLeft(),
                position.backwardAndRight(),
        };
    }
}
