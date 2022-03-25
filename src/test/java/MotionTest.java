import com.chess.game.Cell;
import com.chess.game.Field;
import com.chess.game.Point;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MotionTest {
    String filePath = "src/test/resources/static/motion/moveQueen.txt";
    Field field = new Field(filePath, 8, 8);


    @Test
    public void queen_can_capture() {
        Cell[][] gameField = field.getGameField();
        Point endPoint = new Point(4, 4);
        boolean testing = gameField[0][0].getFigure().isValidMove(endPoint);

        assertThat(testing).isTrue();
    }

    @Test
    public void queen_not_valid_move() {
        Cell[][] gameField = field.getGameField();
        Point endPoint = new Point(5, 5);
        boolean testing = gameField[0][0].getFigure().isValidMove(endPoint);

        assertThat(testing).isFalse();


        endPoint = new Point(8, 8);
        testing = gameField[0][0].getFigure().isValidMove(endPoint);

        assertThat(testing).isFalse();
    }
}
