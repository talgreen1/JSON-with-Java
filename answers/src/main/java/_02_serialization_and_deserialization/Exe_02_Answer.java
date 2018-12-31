package _02_serialization_and_deserialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@SuppressWarnings("Duplicates")
public class Exe_02_Answer {
    public static final String RESULT_FILE_PATH = "c:/temp/names.json";

    public void execute() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Read json file into list of persons
        URL url = Resources.getResource("jsonFiles/exe2.json");
        List<Exe_02_Answer_Person> persons = mapper.readValue(url, new TypeReference<List<Exe_02_Answer_Person>>() {
        });

        // sort persons according to date
        List<String> sortedNamesbyChildren = persons.stream()
                .sorted(Comparator.comparingInt(Exe_02_Answer_Person::getNumOfChildren))
                .map(Exe_02_Answer_Person::getName)
                .collect(Collectors.toList());

        try (FileWriter writer = new FileWriter("c:/temp/names.json")) {
            mapper.writeValue(writer, sortedNamesbyChildren);
        }
    }
}
