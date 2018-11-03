package tech.kryo.json;

import com.google.gson.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public abstract class JsonArrayDecorator extends JsonDecorator<JsonArray> {

    public JsonArrayDecorator(JsonArray root) {
        super(root);
    }

    public Optional<JsonElement> get(int index) throws IndexOutOfBoundsException {
        return getAsJsonArray().map(jsonElements -> jsonElements.get(index));
    }

    public Optional<JsonObject> getAsJsonObject(int index) {
        return get(index).map(element -> element.isJsonObject() ? element.getAsJsonObject() : null);
    }

    public Optional<JsonPrimitive> getAsJsonPrimitive(int index) {
        return get(index).map(element -> element.isJsonPrimitive() ? element.getAsJsonPrimitive() : null);
    }

    public Optional<JsonNull> getAsJsonNull(int index) {
        return get(index).map(element -> element.isJsonNull() ? element.getAsJsonNull() : null);
    }

    public Optional<Character> getAsCharacter(int index) {
        return getAsJsonPrimitive(index).map(jsonPrimitive -> jsonPrimitive.isString() ? jsonPrimitive.getAsCharacter() : null);
    }

    public Optional<String> getAsString(int index) {
        return getAsJsonPrimitive(index).map(jsonPrimitive -> jsonPrimitive.isString() ? jsonPrimitive.getAsString() : null);
    }

    public Optional<Boolean> getAsBoolean(int index) {
        return getAsJsonPrimitive(index).map(jsonPrimitive -> jsonPrimitive.isBoolean() ? jsonPrimitive.getAsBoolean() : null);
    }

    public Optional<Number> getAsNumber(int index) {
        return getAsJsonPrimitive(index).map(jsonPrimitive -> jsonPrimitive.isNumber() ? jsonPrimitive.getAsNumber() : null);
    }

    public Optional<BigInteger> getAsBigInteger(int index) {
        return getAsJsonPrimitive(index).map(jsonPrimitive -> jsonPrimitive.isNumber() ? jsonPrimitive.getAsBigInteger() : null);
    }

    public Optional<BigDecimal> getAsBigDecimal(int index) {
        return getAsJsonPrimitive(index).map(jsonPrimitive -> jsonPrimitive.isNumber() ? jsonPrimitive.getAsBigDecimal() : null);
    }

    public Optional<Byte> getAsByte(int index) {
        return getAsNumber(index).map(Number::byteValue);
    }

    public Optional<Short> getAsShort(int index) {
        return getAsNumber(index).map(Number::shortValue);
    }

    public Optional<Integer> getAsInteger(int index) {
        return getAsNumber(index).map(Number::intValue);
    }

    public Optional<Long> getAsLong(int index) {
        return getAsNumber(index).map(Number::longValue);
    }

    public Optional<Float> getAsFloat(int index) {
        return getAsNumber(index).map(Number::floatValue);
    }

    public Optional<Double> getAsDouble(int index) {
        return getAsNumber(index).map(Number::doubleValue);
    }

}
