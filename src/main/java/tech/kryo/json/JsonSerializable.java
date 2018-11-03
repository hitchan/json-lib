package tech.kryo.json;

import com.google.gson.*;

import java.util.Optional;

public interface JsonSerializable {

    Optional<JsonElement> getAsJsonElement();

    default boolean isJsonObject() {
        final Optional<JsonElement> element = getAsJsonElement();
        return element.isPresent() && element.get().isJsonObject();
    }

    default Optional<JsonObject> getAsJsonObject() {
        return getAsJsonElement().map(JsonElement::getAsJsonObject);
    }

    default boolean isJsonArray() {
        final Optional<JsonElement> element = getAsJsonElement();
        return element.isPresent() && element.get().isJsonArray();
    }

    default Optional<JsonArray> getAsJsonArray() {
        return getAsJsonElement().map(JsonElement::getAsJsonArray);
    }

    default boolean isJsonPrimitive() {
        final Optional<JsonElement> element = getAsJsonElement();
        return element.isPresent() && element.get().isJsonPrimitive();
    }

    default Optional<JsonPrimitive> getAsJsonPrimitive() {
        return getAsJsonElement().map(JsonElement::getAsJsonPrimitive);
    }

    default boolean isJsonNull() {
        final Optional<JsonElement> element = getAsJsonElement();
        return element.isPresent() && element.get().isJsonNull();
    }

    default Optional<JsonNull> getAsJsonNull() {
        return getAsJsonElement().map(JsonElement::getAsJsonNull);
    }

}
