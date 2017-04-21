package model.pieces;

public interface Piece_ {

    void move_if_exist_position_and_is_empty() throws Exception;

    void not_move_if_not_exist_position() throws Exception;

    void not_move_if_exist_position_but_is_occupied() throws Exception;

    void move_to_capture_other_piece() throws Exception;

}
