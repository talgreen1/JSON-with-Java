package _07_comparison;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static net.javacrumbs.jsonunit.JsonAssert.when;
import static net.javacrumbs.jsonunit.JsonAssert.whenIgnoringPaths;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_VALUES;

public class JsonUnitExamples {
    public static void main(String[] args) {
        basicAssertion();
        ignoringExtraFields();
        compareSchemaOnly();
        ignoringPath();
        typePlaceholders();


    }

    private static void typePlaceholders() {
        String json1 = "{\"id\":1, \"name\":\"tal\", \"role\":\"admin\"}";
        String json2 = "{\"id\":\"${json-unit.any-number}\", \"name\":\"tal\", \"role\":\"admin\"}";

        assertThatJson(json1).isEqualTo(json2);
    }

    private static void ignoringPath() {
        String json1 = "{\"id\":\"1\", \"name\":\"tal\", \"role\":\"admin\"}";
        String json2 = "{\"id\":\"1\", \"name\":\"tal\", \"role\":\"User\"}";

        // AssertJ Syntax
        assertThatJson(json1)
                .withConfiguration(c -> c.whenIgnoringPaths("role"))
                .isEqualTo(json2);

        // Standard syntax
        assertJsonEquals(json1, json2, whenIgnoringPaths("role"));

    }

    private static void compareSchemaOnly() {
        String json1 = "{\"id\":\"1\", \"name\":\"tal\"}";
        String json2 = "{\"id\":\"2222\", \"name\":\"gidi\"}";

        // Standard Syntax
        assertJsonEquals(json2, json1, when(IGNORING_VALUES));

        // AssertJ Syntax
        assertThatJson(json1).when(IGNORING_VALUES).isEqualTo(json2);
    }

    private static void ignoringExtraFields() {
        String json1 = "{\"id\":\"1\", \"name\":\"tal\", \"role\":\"admin\"}";
        String json2 = "{\"id\":\"1\", \"name\":\"tal\"}";

        // Standard Syntax
        assertJsonEquals(json2, json1, when(IGNORING_EXTRA_FIELDS));

        // AssertJ Syntax
        assertThatJson(json1).when(IGNORING_EXTRA_FIELDS).isEqualTo(json2);
    }

    private static void basicAssertion() {
        String json1 = "{\"id\":\"1\", \"name\":\"tal\"}";
        String json2 = "{\"id\":\"1\", \"name\":\"tal\"}";

        // Standard Syntax
        assertJsonEquals(json1, json2);

        // AssertJ Syntax
        assertThatJson(json1).isEqualTo(json2);
    }
}
