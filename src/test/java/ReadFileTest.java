import com.chess.game.Field;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ReadFileTest {
    @Test
    public void read_file_not_empty() {
        String filePath = "src/test/resources/static/fileNotEmpty.txt";
        char[][] content = Field.readFileToCharArr(filePath, 4, 4);
        assertThat(content).isNotEmpty();
    }

    @Test
    public void read_file_content() {
        String filePath = "src/test/resources/static/fileContent.txt";
        char[][] content = Field.readFileToCharArr(filePath, 2, 4);

        char[][] expectedContent = {{'p', 'p', 'p', 'p'}, {'z', 'z', 'z', 'z'}};
        assertThat(content).isEqualTo(expectedContent);
    }
}
