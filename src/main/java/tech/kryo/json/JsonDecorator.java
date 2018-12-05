package tech.kryo.json;

import com.google.gson.JsonElement;

import java.util.Optional;

public abstract class JsonDecorator implements Json {

    private final JsonElement root;

    public JsonDecorator(JsonElement root) {
        this.root = root;
    }

    public static Optional<JsonDecorator> wrap(JsonElement root) {
        if (root == null) {
            return Optional.empty();
        }

        if (root.isJsonObject()) {
            return Optional.of(new JsonObjectDecorator(root.getAsJsonObject()));
        }

        if (root.isJsonArray()) {
            return Optional.of(new JsonArrayDecorator(root.getAsJsonArray()));
        }

        return Optional.empty();
    }

    public JsonElement getRoot() {
        return root;
    }

    public JsonObjectDecorator getAsJsonObjectDecorator() {
        return new JsonObjectDecorator(getAsJsonObject());
    }

    public JsonArrayDecorator getAsJsonArrayDecorator() {
        return new JsonArrayDecorator(getAsJsonArray());
    }

}
