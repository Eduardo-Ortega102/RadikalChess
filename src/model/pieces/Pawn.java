package model.pieces;

import model.Board;
import model.Movement;
import model.Piece;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {
    private final Board board;
    private Position position;

    public Pawn(Board board, Position position) {
        this.board = board;
        this.position = position;
    }

    @Override
    public List<Movement> possibleMovements() {
        List<Movement> movements = new ArrayList<>();
        addForwardMovement(movements, position.forward());
        addCaptureMovement(movements, position.forwardAndLeft());
        addCaptureMovement(movements, position.forwardAndRight());
        return movements;
    }

    private void addForwardMovement(List<Movement> movements, Position destination) {
        if (board.exist(destination) && board.isEmpty(destination))
            movements.add(new Movement(position, destination));
    }

    private void addCaptureMovement(List<Movement> movements, Position destination) {
        if (board.exist(destination) && board.canCapture(destination))
            movements.add(new Movement(position,destination));
    }

}
