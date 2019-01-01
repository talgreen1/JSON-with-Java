package _02_serialization_and_deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Exe_03_Answer_Test {

    @Test
    public void exe02Test() throws IOException {
        new Exe_03_Answer().execute();

        ObjectMapper mapper = new ObjectMapper();
        String[] names = mapper.readValue(new File(Exe_03_Answer.RESULT_FILE_PATH), String[].class);

        assertThat(names).startsWith("Itzhak Klepter");
        assertThat(names).endsWith("Gidi Gov");
        assertThat(names).contains("Yoni Rechter","Dany Sanderson");
    }
}
