package model;

import org.junit.Test;

import static model.TestUtilities.movement;
import static model.TestUtilities.position;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class Movement_ {

    @Test
    public void movements_with_same_origin_and_destination_are_equals() throws Exception {
        assertThat(movement(position('A', 1), position('B', 1)), is(equalTo(movement(position('A', 1), position('B', 1)))));
        assertThat(movement(position('A', 2), position('D', 2)), is(equalTo(movement(position('A', 2), position('D', 2)))));
    }

    @Test
    public void movements_with_different_origin_or_destination_are_not_equals() throws Exception {
        Position origin1 = position('A', 1), destination1 = position('A', 3);
        Position origin2 = position('A', 2), destination2 = position('D', 2);
        assertThat(movement(origin1, destination1), is(not(equalTo(movement(origin1, destination2)))));
        assertThat(movement(origin1, destination1), is(not(equalTo(movement(origin2, destination1)))));
        assertThat(movement(origin1, destination1), is(not(equalTo(movement(origin2, destination2)))));
    }

    @Test
    public void string_representation() throws Exception {
        assertThat(movement(position('A', 1), position('B', 1)).toString(), is(equalTo("A1:B1")));
        assertThat(movement(position('A', 2), position('D', 2)).toString(), is(equalTo("A2:D2")));

    }
}