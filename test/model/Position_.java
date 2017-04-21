package model;

import org.junit.Test;

import static model.TestUtilities.position;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class Position_ {

    @Test
    public void positions_with_the_same_row_and_column_are_equals() throws Exception {
        assertThat(position('A', 1), is(equalTo(position('A', 1))));
        assertThat(position('B', 2), is(equalTo(position('B', 2))));
        assertThat(position('C', 3), is(equalTo(position('C', 3))));
    }

    @Test
    public void positions_with_different_row_or_column_are_not_equals() throws Exception {
        assertThat(position('B', 2), is(not(equalTo(position('B', 1)))));
        assertThat(position('B', 2), is(not(equalTo(position('C', 2)))));
        assertThat(position('B', 2), is(not(equalTo(position('D', 3)))));
    }

    @Test
    public void string_representation() throws Exception {
        assertThat(position('B', 1).toString(), is(equalTo("B1")));
        assertThat(position('C', 2).toString(), is(equalTo("C2")));
        assertThat(position('D', 3).toString(), is(equalTo("D3")));
    }

    @Test
    public void a_position_with_lower_row_and_column_is_lower_than_other() throws Exception {
        assertTrue(position('A', 1).isLowerOrEqualTo(position('A', 1)));
        assertTrue(position('A', 1).isLowerOrEqualTo(position('B', 1)));
        assertTrue(position('A', 1).isLowerOrEqualTo(position('A', 2)));
    }

    @Test
    public void a_position_with_higher_row_and_column_is_higher_than_other() throws Exception {
        assertTrue(position('A', 1).isHigherOrEqualTo(position('A', 1)));
        assertTrue(position('B', 1).isHigherOrEqualTo(position('A', 1)));
        assertTrue(position('A', 2).isHigherOrEqualTo(position('A', 1)));
    }

    @Test
    public void forward() throws Exception {
        assertThat(position('A', 1).forward(), is(equalTo(position('A', 2))));
        assertThat(position('B', 2).forward(), is(equalTo(position('B', 3))));
        assertThat(position('C', 3).forward(), is(equalTo(position('C', 4))));
    }

    @Test
    public void backward() throws Exception {
        assertThat(position('B', 2).backward(), is(equalTo(position('B', 1))));
        assertThat(position('A', 1).backward(), is(equalTo(position('A', 0))));
        assertThat(position('C', 3).backward(), is(equalTo(position('C', 2))));
    }

    @Test
    public void right() throws Exception {
        assertThat(position('A', 1).right(), is(equalTo(position('B', 1))));
        assertThat(position('B', 2).right(), is(equalTo(position('C', 2))));
        assertThat(position('C', 3).right(), is(equalTo(position('D', 3))));
    }

    @Test
    public void left() throws Exception {
        assertThat(position('B', 1).left(), is(equalTo(position('A', 1))));
        assertThat(position('C', 2).left(), is(equalTo(position('B', 2))));
        assertThat(position('D', 3).left(), is(equalTo(position('C', 3))));
    }

    @Test
    public void forwardAndRight() throws Exception {
        assertThat(position('A', 1).forwardAndRight(), is(equalTo(position('B', 2))));
        assertThat(position('B', 2).forwardAndRight(), is(equalTo(position('C', 3))));
        assertThat(position('C', 3).forwardAndRight(), is(equalTo(position('D', 4))));
    }

    @Test
    public void forwardAndLeft() throws Exception {
        assertThat(position('B', 1).forwardAndLeft(), is(equalTo(position('A', 2))));
        assertThat(position('C', 2).forwardAndLeft(), is(equalTo(position('B', 3))));
        assertThat(position('D', 3).forwardAndLeft(), is(equalTo(position('C', 4))));
    }

    @Test
    public void backwardAndRight() throws Exception {
        assertThat(position('A', 3).backwardAndRight(), is(equalTo(position('B', 2))));
        assertThat(position('B', 2).backwardAndRight(), is(equalTo(position('C', 1))));
        assertThat(position('C', 4).backwardAndRight(), is(equalTo(position('D', 3))));
    }

    @Test
    public void backwardAndLeft() throws Exception {
        assertThat(position('B', 2).backwardAndLeft(), is(equalTo(position('A', 1))));
        assertThat(position('C', 3).backwardAndLeft(), is(equalTo(position('B', 2))));
        assertThat(position('D', 4).backwardAndLeft(), is(equalTo(position('C', 3))));
    }


}