package tech.kryo.json;

import com.google.gson.JsonPrimitive;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public class JsonPrimitiveDecorator extends JsonDecorator<JsonPrimitive> {

    public JsonPrimitiveDecorator(JsonPrimitive root) {
        super(root);
    }

    public Optional<Character> getAsCharacter() {
        return getRoot().map(jsonPrimitive -> jsonPrimitive.isString() ? jsonPrimitive.getAsCharacter() : null);
    }

    public Optional<String> getAsString() {
        return getRoot().map(jsonPrimitive -> jsonPrimitive.isString() ? jsonPrimitive.getAsString() : null);
    }

    public Optional<Boolean> getAsBoolean() {
        return getRoot().map(jsonPrimitive -> jsonPrimitive.isBoolean() ? jsonPrimitive.getAsBoolean() : null);
    }

    public Optional<Number> getAsNumber() {
        return getRoot().map(jsonPrimitive -> jsonPrimitive.isNumber() ? jsonPrimitive.getAsNumber() : null);
    }

    public Optional<BigInteger> getAsBigInteger() {
        return getRoot().map(jsonPrimitive -> jsonPrimitive.isNumber() ? jsonPrimitive.getAsBigInteger() : null);
    }

    public Optional<BigDecimal> getAsBigDecimal() {
        return getRoot().map(jsonPrimitive -> jsonPrimitive.isNumber() ? jsonPrimitive.getAsBigDecimal() : null);
    }

    public Optional<Byte> getAsByte() {
        return getAsNumber().map(Number::byteValue);
    }

    public Optional<Short> getAsShort() {
        return getAsNumber().map(Number::shortValue);
    }

    public Optional<Integer> getAsInteger() {
        return getAsNumber().map(Number::intValue);
    }

    public Optional<Long> getAsLong() {
        return getAsNumber().map(Number::longValue);
    }

    public Optional<Float> getAsFloat() {
        return getAsNumber().map(Number::floatValue);
    }

    public Optional<Double> getAsDouble() {
        return getAsNumber().map(Number::doubleValue);
    }

}
