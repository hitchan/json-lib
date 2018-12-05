package tech.kryo.json;

import com.google.gson.*;

public interface Json {

    default JsonElement getAsJsonElement() {
        return JsonNull.INSTANCE;
    }

    default boolean isJsonObject() {
        return getAsJsonElement().isJsonObject();
    }

    default JsonObject getAsJsonObject() {
        return getAsJsonElement().getAsJsonObject();
    }

    default boolean isJsonArray() {
        return getAsJsonElement().isJsonArray();
    }

    default JsonArray getAsJsonArray() {
        return getAsJsonElement().getAsJsonArray();
    }

    default boolean isJsonPrimitive() {
        return getAsJsonElement().isJsonPrimitive();
    }

    default JsonPrimitive getAsJsonPrimitive() {
        return getAsJsonElement().getAsJsonPrimitive();
    }

    default boolean isJsonNull() {
        return getAsJsonElement().isJsonNull();
    }

    default JsonNull getAsJsonNull() {
        return getAsJsonElement().getAsJsonNull();
    }

}
