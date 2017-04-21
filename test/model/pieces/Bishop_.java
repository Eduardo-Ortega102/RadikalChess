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

public class Bishop_ implements Piece_ {

    private Position origin;

    @Before
    public void setUp() throws Exception {
        origin = new Position('C', 3);
    }

    @Test
    @Override
    public void move_if_exist_position_and_is_empty() throws Exception {
        Board board = board()
                .existPosition(position('A', 1), position('E', 5))
                .isEmpty(true)
                .create();
        List<Movement> movements = movements(origin,
                position('B', 4), position('A', 5), position('D', 4), position('E', 5),
                position('B', 2), position('A', 1), position('D', 2), position('E', 1)
        );
        assertThat(new Bishop(board, origin).possibleMovements(), is(movements));
    }

    @Test
    @Override
    public void not_move_if_not_exist_position() throws Exception {
        Board board = board()
                .existPosition(false)
                .create();
        assertThat(new Bishop(board, origin).possibleMovements(), is(empty()));
    }

    @Test
    @Override
    public void not_move_if_exist_position_but_is_occupied() throws Exception {
        Board board = board()
                .existPosition(true)
                .isEmpty(false)
                .create();
        assertThat(new Bishop(board, origin).possibleMovements(), is(empty()));
    }

    @Test
    @Override
    public void move_to_capture_other_piece() throws Exception {
        Board board = board()
                .existPosition(true)
                .isEmpty(false)
                .canCapture(new Position[]{position('B', 4), position('D', 4), position('B', 2), position('D', 2)})
                .create();
        List<Movement> movements = movements(origin,
                position('B', 4), position('D', 4), position('B', 2), position('D', 2)
        );
        assertThat(new Bishop(board, origin).possibleMovements(), is(movements));
    }


}
