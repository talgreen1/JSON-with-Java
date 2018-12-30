package _07_advanced_jackson._05_custom_serializer;

import _07_advanced_jackson._05_custom_serializer.model.Item;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ItemSerializer extends StdSerializer<Item> {

    public ItemSerializer() {
        this(null);
    }

    public ItemSerializer(Class<Item> t) {
        super(t);
    }

    @Override
    public void serialize(Item value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("itemName", value.getItemName());
        gen.writeNumberField("owner", value.getOwner().getId());
        gen.writeEndObject();
    }
}
