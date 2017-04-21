package model;

public class Movement {

    private final Position origin;
    private final Position destination;

    public Movement(Position origin, Position destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return origin.equals(movement.origin) && destination.equals(movement.destination);
    }

    @Override
    public int hashCode() {
        return 31 * origin.hashCode() + destination.hashCode();
    }

    @Override
    public String toString() {
        return origin + "->" + destination;
    }

}
