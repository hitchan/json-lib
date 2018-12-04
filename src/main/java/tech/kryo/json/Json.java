package tech.kryo.json;

import com.google.gson.*;

import java.util.Optional;

public interface Json {

    Optional<JsonElement> getAsJsonElement();

    default boolean isJsonObject() {
        return getAsJsonElement().filter(JsonElement::isJsonObject).isPresent();
    }

    default Optional<JsonObject> getAsJsonObject() {
        return getAsJsonElement().map(JsonElement::getAsJsonObject);
    }

    default boolean isJsonArray() {
        return getAsJsonElement().filter(JsonElement::isJsonArray).isPresent();
    }

    default Optional<JsonArray> getAsJsonArray() {
        return getAsJsonElement().map(JsonElement::getAsJsonArray);
    }

    default boolean isJsonPrimitive() {
        return getAsJsonElement().filter(JsonElement::isJsonPrimitive).isPresent();
    }

    default Optional<JsonPrimitive> getAsJsonPrimitive() {
        return getAsJsonElement().map(JsonElement::getAsJsonPrimitive);
    }

    default boolean isJsonNull() {
        return getAsJsonElement().filter(JsonElement::isJsonNull).isPresent();
    }

    default Optional<JsonNull> getAsJsonNull() {
        return getAsJsonElement().map(JsonElement::getAsJsonNull);
    }

}
