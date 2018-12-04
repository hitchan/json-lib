package tech.kryo.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class JsonObjectDecorator extends JsonDecorator {

    public JsonObjectDecorator(JsonObject root) {
        super(root);
    }

    @Override
    public JsonObject getRoot() {
        return super.getRoot().getAsJsonObject();
    }

    public boolean has(String member) {
        return getRoot().has(member);
    }

    public Optional<JsonElement> get(String member) {
        return Optional.ofNullable(getRoot().get(member));
    }

    public Optional<JsonObject> getAsJsonObject(String member) {
        return get(member).map(JsonElement::getAsJsonObject);
    }

    public Optional<JsonObjectDecorator> getAsJsonObjectDecorator(String member) {
        return getAsJsonObject(member).map(JsonObjectDecorator::new);
    }

    public Optional<JsonArray> getAsJsonArray(String member) {
        return get(member).map(JsonElement::getAsJsonArray);
    }

    public Optional<JsonArrayDecorator> getAsJsonArrayDecorator(String member) {
        return getAsJsonArray(member).map(JsonArrayDecorator::new);
    }

    public Optional<JsonPrimitive> getAsJsonPrimitive(String member) {
        return get(member).map(JsonElement::getAsJsonPrimitive);
    }

    public Optional<String> getAsString(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsString);
    }

    public Optional<Character> getAsCharacter(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsCharacter);
    }

    public Optional<Number> getAsNumber(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsNumber);
    }

    public Optional<BigInteger> getAsBigInteger(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsBigInteger);
    }

    public Optional<Long> getAsLong(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsLong);
    }

    public Optional<Integer> getAsInteger(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsInt);
    }

    public Optional<Short> getAsShort(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsShort);
    }

    public Optional<Byte> getAsByte(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsByte);
    }

    public Optional<BigDecimal> getAsBigDecimal(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsBigDecimal);
    }

    public Optional<Double> getAsDouble(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsDouble);
    }

    public Optional<Float> getAsFloat(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsFloat);
    }

    public Optional<Boolean> getAsBoolean(String member) {
        return getAsJsonPrimitive(member).map(JsonPrimitive::getAsBoolean);
    }

    public int size() {
        return getRoot().size();
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return getRoot().entrySet();
    }

    public Set<String> keySet() {
        return getRoot().keySet();
    }

}
