package model;

public interface Board {

    boolean exist(Position position);

    boolean isEmpty(Position position);

    boolean canCapture(Position position);
}
