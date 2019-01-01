package _03_parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exe_04_Answer {
    public List<Integer> getYOfOddPoints() throws IOException {
        List<Integer> res = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        URL url = Resources.getResource("jsonFiles/exe4.json");
        JsonNode node = mapper.readTree(url);

        JsonNode points = node.get("points");

        Iterator<JsonNode> iterator = points.iterator();

        while(iterator.hasNext()){
            res.add(iterator.next().get("y").asInt());
            iterator.next();
        }

        return res;




    }
}
