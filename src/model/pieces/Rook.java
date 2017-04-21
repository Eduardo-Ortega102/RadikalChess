package model.pieces;

import model.Board;
import model.Movement;
import model.Piece;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook implements Piece {
    private final Board board;
    private Position position;

    public Rook(Board board, Position position) {
        this.board = board;
        this.position = position;
    }

    @Override
    public List<Movement> possibleMovements() {
        List<Movement> movements = new ArrayList<>();
        addMovements(movements, Position::forward);
        addMovements(movements, Position::backward);
        addMovements(movements, Position::left);
        addMovements(movements, Position::right);
        return movements;
    }

    private void addMovements(List<Movement> movements, PositionCalculator calculator) {
        Position position = this.position;
        while (true){
            position = calculator.next(position);
            if (board.exist(position) && (board.isEmpty(position) || board.canCapture(position)))
                movements.add(new Movement(this.position, position));
            else
                break;
        }
    }
}
