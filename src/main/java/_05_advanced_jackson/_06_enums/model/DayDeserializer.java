package _05_advanced_jackson._06_enums.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class DayDeserializer extends StdDeserializer<Day5> {

    public DayDeserializer() {
        super(Day5.class);
    }


    public DayDeserializer(Class t) {
        super(t);
    }

    @Override
    public Day5 deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);
        String dayName = (String) ((TextNode) node.get("DayName")).asText();
        return Day5.valueOf(dayName);
    }

}
