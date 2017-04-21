package model;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public final class TestUtilities {

    public static Position position(char column, int row) {
        return new Position(column, row);
    }

    public static List<Movement> empty() {
        return new ArrayList<>();
    }

    public static List<Movement> movements(Position origin, Position... destinations) {
        List<Movement> movements = new ArrayList<>();
        for (Position position : destinations) movements.add(new Movement(origin, position));
        return movements;
    }

    public static Movement movement(Position origin, Position destination) {
        return new Movement(origin, destination);
    }

    public static BoardMocker board() {
        Board board = mock(Board.class);
        return new BoardMocker() {
            @Override
            public BoardMocker existPosition(boolean value) {
                doReturn(value).when(board).exist(any(Position.class));
                return this;
            }

            @Override
            public BoardMocker isEmpty(boolean value) {
                doReturn(value).when(board).isEmpty(any(Position.class));
                return this;
            }

            @Override
            public BoardMocker canCapture(boolean value) {
                doReturn(value).when(board).canCapture(any(Position.class));
                return this;
            }

            @Override
            public BoardMocker canCapture(Position[] positions) {
                for (Position position : positions)
                    when(board.canCapture(position)).thenReturn(true);
                return this;
            }

            @Override
            public Board create() {
                return board;
            }

            @Override
            public BoardMocker existPosition(Position origin, Position limit) {
                when(board.exist(any(Position.class))).thenAnswer(invocationOnMock -> {
                    Position position = (Position) invocationOnMock.getArguments()[0];
                    return position.isHigherOrEqualTo(origin) && position.isLowerOrEqualTo(limit);
                });
                return this;
            }
        };
    }

    public interface BoardMocker {
        BoardMocker existPosition(boolean value);

        BoardMocker isEmpty(boolean value);

        BoardMocker canCapture(boolean value);

        BoardMocker canCapture(Position[] positions);

        Board create();

        BoardMocker existPosition(Position origin, Position limit);
    }
}
