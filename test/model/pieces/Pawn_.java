package model.pieces;

import model.Board;
import model.Movement;
import model.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static model.TestUtilities.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Pawn_ implements Piece_{

    private Position origin;

    @Before
    public void setUp() throws Exception {
        origin = position('B', 3);
    }

    @Test
    @Override
    public void move_if_exist_position_and_is_empty() throws Exception {
        Board board = board().existPosition(true).isEmpty(true).canCapture(false).create();
        List<Movement> movements = movements(origin, position('B', 4));
        assertThat(new Pawn(board, origin).possibleMovements(), is(movements));
    }

    @Test
    @Override
    public void not_move_if_not_exist_position() throws Exception {
        Board board = board().existPosition(false).create();
        assertThat(new Pawn(board, origin).possibleMovements(), is(empty()));
    }

    @Test
    @Override
    public void not_move_if_exist_position_but_is_occupied() throws Exception {
        Board board = board().existPosition(true).isEmpty(false).canCapture(false).create();
        assertThat(new Pawn(board, origin).possibleMovements(), is(empty()));
    }

    @Test
    @Override
    public void move_to_capture_other_piece() throws Exception {
        Board board = board().existPosition(true).isEmpty(false).canCapture(true).create();
        List<Movement> movements = movements(origin, position('A', 4), position('C', 4));
        assertThat(new Pawn(board, origin).possibleMovements(), is(movements));
    }

}
