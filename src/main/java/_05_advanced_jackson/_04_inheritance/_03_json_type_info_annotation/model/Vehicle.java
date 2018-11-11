package _05_advanced_jackson._04_inheritance._03_json_type_info_annotation.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//TODO: Ask Yaniv : Is there another way? Without adding annotataions?

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,     //TODO: Ask Yaniv about Id.Custom
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = Car.class, name = "car"),
        @Type(value = Truck.class, name = "truck")
})

//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.CLASS,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "type")

//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.MINIMAL_CLASS,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "type")

//
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.WRAPPER_OBJECT,
//        property = "type")
//@JsonSubTypes({
//        @Type(value = Car.class, name = "car"),
//        @Type(value = Truck.class, name = "truck")
//})



//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.EXISTING_PROPERTY,  //TODO: Ask Yaniv about Existing_Property, External_Property
//        property = "type")
//@JsonSubTypes({
//        @Type(value = Car.class, name = "car"),
//        @Type(value = Truck.class, name = "truck")
//})
public abstract class Vehicle {
    protected String maker;
    protected String model;

    public Vehicle() {
    }

    protected Vehicle(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }
}
