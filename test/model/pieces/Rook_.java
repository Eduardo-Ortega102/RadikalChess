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

public class Rook_ implements Piece_ {

    private Position origin;

    @Before
    public void setUp() throws Exception {
        origin = new Position('B', 4);
    }

    @Test
    @Override
    public void move_if_exist_position_and_is_empty() throws Exception {
        Board board = board()
                .existPosition(position('A', 1), position('D', 6))
                .isEmpty(true)
                .create();
        List<Movement> movements = movements(origin,
                position('B', 5), position('B', 6), position('B', 3), position('B', 2),
                position('B', 1), position('A', 4), position('C', 4), position('D', 4)
        );
        assertThat(new Rook(board, origin).possibleMovements(), is(movements));
    }

    @Test
    @Override
    public void not_move_if_not_exist_position() throws Exception {
        Board board = board()
                .existPosition(false)
                .create();
        assertThat(new Rook(board, origin).possibleMovements(), is(empty()));
    }

    @Test
    @Override
    public void not_move_if_exist_position_but_is_occupied() throws Exception {
        Board board = board()
                .existPosition(true)
                .isEmpty(false)
                .create();
        assertThat(new Rook(board, origin).possibleMovements(), is(empty()));
    }

    @Test
    @Override
    public void move_to_capture_other_piece() throws Exception {
        Board board = board()
                .existPosition(true)
                .isEmpty(false)
                .canCapture(new Position[]{position('B', 5), position('B', 3), position('A', 4), position('C', 4)})
                .create();
        List<Movement> movements = movements(origin,
                position('B', 5), position('B', 3),
                position('A', 4), position('C', 4)
        );
        assertThat(new Rook(board, origin).possibleMovements(), is(movements));
    }


}
