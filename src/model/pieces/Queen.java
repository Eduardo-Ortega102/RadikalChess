package model.pieces;

import model.Board;
import model.Movement;
import model.Piece;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen implements Piece {
    private final Board board;
    private Position position;

    public Queen(Board board, Position position) {
        this.board = board;
        this.position = position;
    }

    @Override
    public List<Movement> possibleMovements() {
        List<Movement> movements = new ArrayList<>();
        addMovements(movements, Position::forwardAndLeft);
        addMovements(movements, Position::forward);
        addMovements(movements, Position::forwardAndRight);
        addMovements(movements, Position::left);
        addMovements(movements, Position::right);
        addMovements(movements, Position::backwardAndLeft);
        addMovements(movements, Position::backward);
        addMovements(movements, Position::backwardAndRight);
        return movements;
    }

    private void addMovements(List<Movement> movements, PositionCalculator calculator) {
        Position position = this.position;
        while (true) {
            position = calculator.next(position);
            if (board.exist(position) && (board.isEmpty(position) || board.canCapture(position)))
                movements.add(new Movement(this.position, position));
            else
                break;
        }
    }
}
