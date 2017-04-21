package model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Position_ {

    public static Position position(int row, char column) {
        return new Position(row, column);
    }

    @Test
    public void positions_with_the_same_row_and_column_are_equals() throws Exception {
        assertThat(position(1, 'A'), is(equalTo(position(1, 'A'))));
        assertThat(position(2, 'B'), is(equalTo(position(2, 'B'))));
        assertThat(position(3, 'C'), is(equalTo(position(3, 'C'))));
    }

    @Test
    public void positions_with_different_row_or_column_are_not_equals() throws Exception {
        assertThat(position(2, 'B'), is(not(equalTo(position(1, 'B')))));
        assertThat(position(2, 'B'), is(not(equalTo(position(2, 'C')))));
        assertThat(position(2, 'B'), is(not(equalTo(position(3, 'D')))));
    }

    @Test
    public void a_position_with_lower_row_or_column_is_lower_than_other() throws Exception {
        assertFalse(position(1,'A').isLowerThan(position(1,'A')));
        assertTrue(position(1,'A').isLowerThan(position(1,'B')));
        assertTrue(position(1,'A').isLowerThan(position(2,'A')));
    }

    @Test
    public void a_position_with_higher_row_or_column_is_higher_than_other() throws Exception {
        assertFalse(position(1, 'A').isHigherThan(position(1, 'A')));
        assertTrue(position(1, 'B').isHigherThan(position(1, 'A')));
        assertTrue(position(2, 'A').isHigherThan(position(1, 'A')));
    }

    @Test
    public void forward() throws Exception {
        assertThat(position(1, 'A').forward(), is(equalTo(position(2, 'A'))));
        assertThat(position(2, 'B').forward(), is(equalTo(position(3, 'B'))));
        assertThat(position(3, 'C').forward(), is(equalTo(position(4, 'C'))));
    }

    @Test
    public void backward() throws Exception {
        assertThat(position(2, 'B').backward(), is(equalTo(position(1, 'B'))));
        assertThat(position(1, 'A').backward(), is(equalTo(position(0, 'A'))));
        assertThat(position(3, 'C').backward(), is(equalTo(position(2, 'C'))));
    }

    @Test
    public void right() throws Exception {
        assertThat(position(1, 'A').right(), is(equalTo(position(1, 'B'))));
        assertThat(position(2, 'B').right(), is(equalTo(position(2, 'C'))));
        assertThat(position(3, 'C').right(), is(equalTo(position(3, 'D'))));
    }

    @Test
    public void left() throws Exception {
        assertThat(position(1, 'B').left(), is(equalTo(position(1, 'A'))));
        assertThat(position(2, 'C').left(), is(equalTo(position(2, 'B'))));
        assertThat(position(3, 'D').left(), is(equalTo(position(3, 'C'))));
    }

    @Test
    public void forwardAndRight() throws Exception {
        assertThat(position(1, 'A').forwardAndRight(), is(equalTo(position(2, 'B'))));
        assertThat(position(2, 'B').forwardAndRight(), is(equalTo(position(3, 'C'))));
        assertThat(position(3, 'C').forwardAndRight(), is(equalTo(position(4, 'D'))));
    }

    @Test
    public void forwardAndLeft() throws Exception {
        assertThat(position(1, 'B').forwardAndLeft(), is(equalTo(position(2, 'A'))));
        assertThat(position(2, 'C').forwardAndLeft(), is(equalTo(position(3, 'B'))));
        assertThat(position(3, 'D').forwardAndLeft(), is(equalTo(position(4, 'C'))));
    }

    @Test
    public void backwardAndRight() throws Exception {
        assertThat(position(3, 'A').backwardAndRight(), is(equalTo(position(2, 'B'))));
        assertThat(position(2, 'B').backwardAndRight(), is(equalTo(position(1, 'C'))));
        assertThat(position(4, 'C').backwardAndRight(), is(equalTo(position(3, 'D'))));
    }

    @Test
    public void backwardAndLeft() throws Exception {
        assertThat(position(2, 'B').backwardAndLeft(), is(equalTo(position(1, 'A'))));
        assertThat(position(3, 'C').backwardAndLeft(), is(equalTo(position(2, 'B'))));
        assertThat(position(4, 'D').backwardAndLeft(), is(equalTo(position(3, 'C'))));
    }


}