package _01_json_as_string;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("Duplicates")
public class Exe_02_Answer_Test {

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    private static Exe_02_Answer answer;

    @BeforeClass
    public static void setup(){
        answer = new Exe_02_Answer();
    }


    @Test
    public void exe_02_answer_test_3_cars() throws IOException {
        File file = folder.newFile("testFile.json");

        String personWith3Cars = "{\"name\": \"John\",\"age\": 30,\"cars\": [\"Ford\",\"BMW\",\"Fiat\"]}";
        FileUtils.writeStringToFile(file,personWith3Cars, Charset.defaultCharset() );

        boolean result = answer.isPersonHaveAtLeast3Cars(file.getAbsolutePath());

        assertThat(result).isTrue();
    }

    @Test
    public void exe_02_answer_test_4_cars() throws IOException {
        File file = folder.newFile("testFile.json");

        String personWith4Cars = "{\"name\": \"John\",\"age\": 30,\"cars\": [\"Audi\",\"Ford\",\"BMW\",\"Fiat\"]}";
        FileUtils.writeStringToFile(file,personWith4Cars, Charset.defaultCharset() );

        boolean result = answer.isPersonHaveAtLeast3Cars(file.getAbsolutePath());

        assertThat(result).isTrue();
    }

    @Test
    public void exe_02_answer_test_2_cars() throws IOException {
        File file = folder.newFile("testFile.json");

        String personWith2Cars = "{\"name\": \"John\",\"age\": 30,\"cars\": [\"Ford\",\"BMW\"]}";
        FileUtils.writeStringToFile(file,personWith2Cars, Charset.defaultCharset() );

        boolean result = answer.isPersonHaveAtLeast3Cars(file.getAbsolutePath());

        assertThat(result).isFalse();
    }

    @Test
    public void exe_02_answer_test_no_cars() throws IOException {
        File file = folder.newFile("testFile.json");

        String personWithNoCars = "{\"name\": \"John\",\"age\": 30}";
        FileUtils.writeStringToFile(file,personWithNoCars, Charset.defaultCharset() );

        boolean result = answer.isPersonHaveAtLeast3Cars(file.getAbsolutePath());

        assertThat(result).isFalse();
    }
}