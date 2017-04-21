package model;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class BoardMocker {
    private Board board;

    private BoardMocker() {
        board = mock(Board.class);
    }

    public static BoardMocker board() {
        return new BoardMocker();
    }

    public BoardMocker existPosition(boolean value) {
        doReturn(value).when(board).exist(any(Position.class));
        return this;
    }

    public BoardMocker isEmpty(boolean value) {
        doReturn(value).when(board).isEmpty(any(Position.class));
        return this;
    }

    public BoardMocker canCapture(boolean value) {
        doReturn(value).when(board).canCapture(any(Position.class));
        return this;
    }

    public Board create() {
        return board;
    }
}
