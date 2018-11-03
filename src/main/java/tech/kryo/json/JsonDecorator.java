package tech.kryo.json;

import com.google.gson.JsonElement;

import java.util.Optional;

public abstract class JsonDecorator<T extends JsonElement> implements JsonSerializable {

    private final T root;

    protected JsonDecorator(T root) {
        this.root = root;
    }

    protected Optional<T> getRoot() {
        return Optional.ofNullable(root);
    }

    @Override
    public Optional<JsonElement> getAsJsonElement() {
        return Optional.ofNullable(root);
    }

}
