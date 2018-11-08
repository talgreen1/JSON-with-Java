package _07_comparison;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.json.JSONException;

import java.io.FileReader;
import java.io.IOException;

public class SchemaValidation {
    public static void main(String[] args) throws IOException, JSONException, ProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode productSchema = mapper.readTree(new FileReader("./src/main/resources/jsonFiles/productSchema.json"));
        JsonNode validJProduct = mapper.readTree("{\"id\": 1,\"name\": \"Lampshade\",\"price\": 1}");
        JsonNode invalidProduct = mapper.readTree("{\"id\": 1,\"name\": \"Lampshade\",\"price\": 0}");

        JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(productSchema);

        ProcessingReport report = schema.validate(validJProduct);
        System.out.printf("Is success: %b. Status messge: %s%n", report.isSuccess(), report);

        report = schema.validate(invalidProduct);
        System.out.printf("Is success: %b. Status messge: %s%n", report.isSuccess(), report);
    }
}
