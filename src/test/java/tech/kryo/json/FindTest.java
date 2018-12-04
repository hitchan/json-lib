package tech.kryo.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;


public class FindTest {

    private static final Gson gson = new Gson();

    @Test
    public void find() throws IOException {

        InputStream inputStream = FindTest.class.getResourceAsStream("/jsonarray.json");
        JsonElement element = new JsonParser().parse(IOUtils.toString(inputStream));

        JsonDecorator jsonDecorator = JsonDecorator.wrap(element).get();
        Optional<Set<JsonElement>> result = jsonDecorator.findAll("name");
        System.out.println(result);

    }

}
