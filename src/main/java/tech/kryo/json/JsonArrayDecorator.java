package tech.kryo.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public class JsonArrayDecorator extends JsonDecorator {

    public JsonArrayDecorator(JsonArray root) {
        super(root);
    }

    @Override
    public JsonArray getRoot() {
        return super.getRoot().getAsJsonArray();
    }

    public Optional<JsonElement> get(int index) {
        return Optional.ofNullable(getRoot().get(index));
    }

    public Optional<JsonObject> getAsJsonObject(int index) {
        return get(index).map(JsonElement::getAsJsonObject);
    }

    public Optional<JsonObjectDecorator> getAsJsonObjectDecorator(int index) {
        return getAsJsonObject(index).map(JsonObjectDecorator::new);
    }

    public Optional<JsonArray> getAsJsonArray(int index) {
        return get(index).map(JsonElement::getAsJsonArray);
    }

    public Optional<JsonArrayDecorator> getAsJsonArrayDecorator(int index) {
        return getAsJsonArray(index).map(JsonArrayDecorator::new);
    }

    public Optional<JsonPrimitive> getAsJsonPrimitive(int index) {
        return get(index).map(JsonElement::getAsJsonPrimitive);
    }

    public Optional<String> getAsString(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsString);
    }

    public Optional<Character> getAsCharacter(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsCharacter);
    }

    public Optional<Number> getAsNumber(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsNumber);
    }

    public Optional<BigInteger> getAsBigInteger(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsBigInteger);
    }

    public Optional<Long> getAsLong(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsLong);
    }

    public Optional<Integer> getAsInteger(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsInt);
    }

    public Optional<Short> getAsShort(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsShort);
    }

    public Optional<Byte> getAsByte(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsByte);
    }

    public Optional<BigDecimal> getAsBigDecimal(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsBigDecimal);
    }

    public Optional<Double> getAsDouble(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsDouble);
    }

    public Optional<Float> getAsFloat(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsFloat);
    }

    public Optional<Boolean> getAsBoolean(int index) {
        return getAsJsonPrimitive(index).map(JsonPrimitive::getAsBoolean);
    }

    public int size() {
        return getRoot().size();
    }

    public boolean contains(JsonElement element) {
        return getRoot().contains(element);
    }

}
