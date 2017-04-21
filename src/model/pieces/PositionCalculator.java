package model.pieces;

import model.Position;

@FunctionalInterface
public interface PositionCalculator {
    Position next(Position position);
}
