package model;

public class Position {

    private final int row;
    private final char column;

    public Position(char column, int row) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return column + "" + row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return column == position.column && row == position.row;
    }

    @Override
    public int hashCode() {
        return 31 * row + (int) column;
    }

    public boolean isLowerOrEqualTo(Position position) {
        return row <= position.row && column <= position.column;
    }

    public boolean isHigherOrEqualTo(Position position) {
        return row >= position.row && column >= position.column;
    }

    public Position forward() {
        return new Position(column, row + 1);
    }

    public Position backward() {
        return new Position(column, row - 1);
    }

    public Position right() {
        return new Position((char) (column + 1), row);
    }

    public Position left() {
        return new Position((char) (column - 1), row);
    }

    public Position forwardAndRight() {
        return new Position((char) (column + 1), row + 1);
    }

    public Position forwardAndLeft() {
        return new Position((char) (column - 1), row + 1);
    }

    public Position backwardAndRight() {
        return new Position((char) (column + 1), row - 1);
    }

    public Position backwardAndLeft() {
        return new Position((char) (column - 1), row - 1);
    }

}
