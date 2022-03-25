import com.chess.game.Cell;
import com.chess.game.Field;
import com.chess.game.Point;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

// TODO: optimize tests to avoid such horrific code copy paste
public class MotionTestQueen {
    String filePath = "src/test/resources/static/motion/moveQueen.txt";
    Field field = new Field(filePath, 8, 8);
    final Cell[][] gameField = field.getGameField();
    Point endPoint;
    boolean testing;


    @Test
    public void invalid_point() {
        endPoint = new Point(8, 8);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isFalse();

        endPoint = new Point(-1, -1);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isFalse();
    }

    @Test
    public void queen_invalid_move() {
        endPoint = new Point(0, 2);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isFalse();

        endPoint = new Point(0, 1);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isFalse();

        endPoint = new Point(7, 6);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isFalse();

        endPoint = new Point(7, 4);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isFalse();
    }

    @Test
    public void queen_can_capture() {
        endPoint = new Point(1, 3);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();

        endPoint = new Point(3, 1);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();

        endPoint = new Point(5, 3);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();

        endPoint = new Point(3, 5);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();

        endPoint = new Point(1, 1);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();

        endPoint = new Point(5, 1);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();

        endPoint = new Point(1, 5);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();

        endPoint = new Point(5, 5);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();
    }

    @Test
    public void queen_valid_move_diagonal_top_left() {
        endPoint = new Point(2, 2);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();
    }


    @Test
    public void queen_not_valid_move_diagonal_top_left() {
        endPoint = new Point(0, 0);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isFalse();
    }

    @Test
    public void queen_valid_move_diagonal_top_right() {
        endPoint = new Point(2, 4);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();
    }

    @Test
    public void queen_not_valid_move_diagonal_top_right() {
        endPoint = new Point(0, 7);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isFalse();
    }

    @Test
    public void queen_valid_move_diagonal_bottom_left() {
        endPoint = new Point(4, 2);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();
    }

    @Test
    public void queen_not_valid_move_diagonal_bottom_left() {
        endPoint = new Point(7, 0);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isFalse();
    }

    @Test
    public void queen_valid_move_diagonal_bottom_right() {
        endPoint = new Point(4, 4);
        testing = gameField[3][3].getFigure().isValidMove(endPoint);
        assertThat(testing).isTrue();
    }

    @Test
    public void queen_not_valid_move_diagonal_bottom_right() {
        Point endPoint = new Point(7, 7);
        boolean testing = gameField[3][3].getFigure().isValidMove(endPoint);

        assertThat(testing).isFalse();
    }
}
