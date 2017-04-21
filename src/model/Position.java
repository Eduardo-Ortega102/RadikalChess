package model;

public class Position {

    private final int row;
    private final char column;

    public Position(int row, char column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "(" + row + "," + column + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return 31 * row + (int) column;
    }

    public boolean isLowerThan(Position position) {
        return row < position.row || column < position.column;
    }

    public boolean isHigherThan(Position position) {
        return row > position.row || column > position.column;
    }

    public Position forward() {
        return new Position(row + 1, column);
    }

    public Position backward() {
        return new Position(row - 1, column);
    }

    public Position right() {
        return new Position(row, (char) (column + 1));
    }

    public Position left() {
        return new Position(row, (char) (column - 1));
    }

    public Position forwardAndRight() {
        return new Position(row + 1, (char) (column + 1));
    }

    public Position forwardAndLeft() {
        return new Position(row + 1, (char) (column - 1));
    }

    public Position backwardAndRight() {
        return new Position(row - 1, (char) (column + 1));
    }

    public Position backwardAndLeft() {
        return new Position(row - 1, (char) (column - 1));
    }

}
