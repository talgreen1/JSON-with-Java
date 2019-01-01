package _03_parsing;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Exe_04_Answer_Test {

    @Test
    public void getYOfOddPoints() throws IOException {
        Exe_04_Answer answer = new Exe_04_Answer();
        List<Integer> yOfOddPoints = answer.getYOfOddPoints();

        assertThat(yOfOddPoints).containsExactly(13,68);

    }
}