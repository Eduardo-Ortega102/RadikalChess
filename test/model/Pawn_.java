package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static model.BoardMocker.board;
import static model.Position_.position;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Pawn_ {

    private static class Pawn implements Piece {
        private Board board;
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

    @Test
    public void go_forward_if_exists_position_and_is_empty() throws Exception {
        Board board = board().existPosition(true).isEmpty(true).canCapture(false).create();
        Position origin = position(3, 'B');
        Piece pawn = new Pawn(board, origin);
        List<Movement> movements = movements(origin, position(4, 'B'));
        assertThat(pawn.possibleMovements(), is(movements));
    }

    @Test
    public void not_go_forward_if_exists_position_and_is_not_empty() throws Exception {
        Board board = board().existPosition(true).isEmpty(false).canCapture(false).create();
        Position origin = position(3, 'B');
        Piece pawn = new Pawn(board, origin);
        assertThat(pawn.possibleMovements(), is(empty()));
    }

    @Test
    public void not_move_if_not_exists_position() throws Exception {
        Board board = board().existPosition(false).create();
        Position origin = position(3, 'B');
        Piece pawn = new Pawn(board, origin);
        assertThat(pawn.possibleMovements(), is(empty()));
    }

    @Test
    public void is_able_to_capture_other_piece() throws Exception {
        Board board = board().existPosition(true).isEmpty(false).canCapture(true).create();
        Position origin = position(3, 'B');
        Piece pawn = new Pawn(board, origin);
        List<Movement> movements = movements(origin, position(4, 'A'), position(4, 'C'));
        assertThat(pawn.possibleMovements(), is(movements));
    }


    private List<Movement> empty() {
        return new ArrayList<>();
    }

    private List<Movement> movements(Position origin, Position... destinations) {
        List<Movement> movements = new ArrayList<>();
        for (Position position : destinations) movements.add(new Movement(origin, position));
        return movements;
    }


}
