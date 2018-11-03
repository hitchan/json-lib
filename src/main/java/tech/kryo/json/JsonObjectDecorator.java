package tech.kryo.json;

import com.google.gson.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class JsonObjectDecorator extends JsonDecorator<JsonObject> {

    public JsonObjectDecorator(JsonObject root) {
        super(root);
    }

    public boolean has(String field) {
        return getRoot().isPresent() && getRoot().get().has(field);
    }

    public Optional<JsonElement> get(String field) {
        return getAsJsonObject().map(jsonObject -> jsonObject.get(field));
    }

    public Optional<JsonObject> getAsJsonObject(String field) {
        return get(field).map(element -> element.isJsonObject() ? element.getAsJsonObject() : null);
    }

    public Optional<JsonArray> getAsJsonArray(String field) {
        return get(field).map(element -> element.isJsonArray() ? element.getAsJsonArray() : null);
    }

    public Optional<JsonPrimitive> getAsJsonPrimitive(String field) {
        return get(field).map(element -> element.isJsonPrimitive() ? element.getAsJsonPrimitive() : null);
    }

    public Optional<JsonNull> getAsJsonNull(String field) {
        return get(field).map(element -> element.isJsonNull() ? element.getAsJsonNull() : null);
    }

    public Optional<Character> getAsCharacter(String field) {
        return getAsJsonPrimitive(field).map(jsonPrimitive -> jsonPrimitive.isString() ? jsonPrimitive.getAsCharacter() : null);
    }

    public Optional<String> getAsString(String field) {
        return getAsJsonPrimitive(field).map(jsonPrimitive -> jsonPrimitive.isString() ? jsonPrimitive.getAsString() : null);
    }

    public Optional<Boolean> getAsBoolean(String field) {
        return getAsJsonPrimitive(field).map(jsonPrimitive -> jsonPrimitive.isBoolean() ? jsonPrimitive.getAsBoolean() : null);
    }

    public Optional<Number> getAsNumber(String field) {
        return getAsJsonPrimitive(field).map(jsonPrimitive -> jsonPrimitive.isNumber() ? jsonPrimitive.getAsNumber() : null);
    }

    public Optional<BigInteger> getAsBigInteger(String field) {
        return getAsJsonPrimitive(field).map(jsonPrimitive -> jsonPrimitive.isNumber() ? jsonPrimitive.getAsBigInteger() : null);
    }

    public Optional<BigDecimal> getAsBigDecimal(String field) {
        return getAsJsonPrimitive(field).map(jsonPrimitive -> jsonPrimitive.isNumber() ? jsonPrimitive.getAsBigDecimal() : null);
    }

    public Optional<Byte> getAsByte(String field) {
        return getAsNumber(field).map(Number::byteValue);
    }

    public Optional<Short> getAsShort(String field) {
        return getAsNumber(field).map(Number::shortValue);
    }

    public Optional<Integer> getAsInteger(String field) {
        return getAsNumber(field).map(Number::intValue);
    }

    public Optional<Long> getAsLong(String field) {
        return getAsNumber(field).map(Number::longValue);
    }

    public Optional<Float> getAsFloat(String field) {
        return getAsNumber(field).map(Number::floatValue);
    }

    public Optional<Double> getAsDouble(String field) {
        return getAsNumber(field).map(Number::doubleValue);
    }

    public Optional<Set<Map.Entry<String, JsonElement>>> entrySet() {
        return getRoot().map(JsonObject::entrySet);
    }

    public Optional<Set<String>> keySet() {
        return getRoot().map(JsonObject::keySet);
    }

    public Optional<Integer> size() {
        return getRoot().map(JsonObject::size);
    }



}
