package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class Pawn_ {

    private static class Pawn implements Piece {
        private Board board;
        private Position position;

        public Pawn(Board board, Position position) {
            this.board = board;
            this.position = position;
        }

        @Override
        public List<Position> possibleMovements() {
            ArrayList<Position> list = new ArrayList<>();
            list.add(position.forward());
            return list;
        }
    }

    @Test
    public void should_go_forward() throws Exception {
        Board board = mock(Board.class);
        Piece pawn = new Pawn(board, new Position(3, 'B'));
        ArrayList<Position> list = new ArrayList<>();
        list.add(new Position(4, 'B'));
        assertThat(pawn.possibleMovements(), is(equalTo(list)));
    }
}
