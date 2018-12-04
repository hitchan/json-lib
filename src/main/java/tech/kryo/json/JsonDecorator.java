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

    @Override
    public Optional<JsonElement> getAsJsonElement() {
        return Optional.of(root);
    }

    public Optional<JsonObjectDecorator> getAsJsonObjectDecorator() {
        return getAsJsonObject().map(JsonObjectDecorator::new);
    }

    public Optional<JsonArrayDecorator> getAsJsonArrayDecorator() {
        return getAsJsonArray().map(JsonArrayDecorator::new);
    }

}
