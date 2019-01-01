package _01_json_as_string;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exe_02_Answer {
    public boolean isPersonHaveAtLeast3Cars(String jsonPath) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(jsonPath)), StandardCharsets.UTF_8);

        int indexOfCarsArray = json.indexOf("\"cars\"");
        if (indexOfCarsArray == -1){
            return false;
        }

        int indexOfCarsArrayBeginning = json.indexOf("[", indexOfCarsArray);
        int indexOfCarsArrayEnding = json.indexOf("]", indexOfCarsArrayBeginning);

        String carsString = json.substring(indexOfCarsArrayBeginning, indexOfCarsArrayEnding);
        String[] cars = carsString.split(",");

        if (cars.length < 3){
            return false;
        }

        return true;
    }
}
