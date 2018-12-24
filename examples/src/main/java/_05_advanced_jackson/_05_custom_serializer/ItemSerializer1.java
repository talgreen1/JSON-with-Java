package _05_advanced_jackson._05_custom_serializer;

import _05_advanced_jackson._05_custom_serializer.model.Item1;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ItemSerializer1 extends StdSerializer<Item1> {

    public ItemSerializer1() {
        this(null);
    }

    public ItemSerializer1(Class<Item1> t) {
        super(t);
    }

    @Override
    public void serialize(Item1 value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("itemName", value.getItemName());
        gen.writeNumberField("owner", value.getOwner().getId());
        gen.writeEndObject();
    }
}
