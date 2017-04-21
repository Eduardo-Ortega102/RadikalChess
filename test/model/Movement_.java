package model;

import org.junit.Test;

import static model.Position_.position;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class Movement_ {

    public static Movement movement(Position origin, Position destination) {
        return new Movement(origin, destination);
    }

    @Test
    public void movements_with_same_origin_and_destination_are_equals() throws Exception {
        assertThat(movement(position(1, 'A'), position(1, 'B')), is(equalTo(movement(position(1, 'A'), position(1, 'B')))));
        assertThat(movement(position(2, 'A'), position(2, 'D')), is(equalTo(movement(position(2, 'A'), position(2, 'D')))));
    }

    @Test
    public void movements_with_different_origin_or_destination_are_not_equals() throws Exception {
        Position origin1 = position(1, 'A'), destination1 = position(3, 'A');;
        Position origin2 = position(2, 'A'), destination2 = position(2, 'D');
        assertThat(movement(origin1, destination1), is(not(equalTo(movement(origin1, destination2)))));
        assertThat(movement(origin1, destination1), is(not(equalTo(movement(origin2, destination1)))));
        assertThat(movement(origin1, destination1), is(not(equalTo(movement(origin2, destination2)))));
    }

}