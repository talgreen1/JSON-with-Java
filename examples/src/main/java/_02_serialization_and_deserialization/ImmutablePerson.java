package _02_serialization_and_deserialization;

import lombok.Value;

@Value
public class ImmutablePerson {
    private final int id;
    private final String name;
}
