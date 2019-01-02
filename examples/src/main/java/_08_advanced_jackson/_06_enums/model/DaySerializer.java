package _08_advanced_jackson._06_enums.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class DaySerializer extends StdSerializer<Day3> {

    public DaySerializer() {
        super(Day3.class);
    }

    public DaySerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(Day3 day, JsonGenerator generator,
                          SerializerProvider provider)
            throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("DayName");
        generator.writeString(day.name());
        generator.writeFieldName("DayVal");
        generator.writeNumber(day.getVal());
        generator.writeEndObject();
    }
}
