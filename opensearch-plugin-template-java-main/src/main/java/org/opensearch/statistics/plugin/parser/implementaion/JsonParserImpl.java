package org.opensearch.statistics.plugin.parser.implementaion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.opensearch.statistics.plugin.model.JsonItem;
import org.opensearch.statistics.plugin.parser.JsonItemAdapter;
import org.opensearch.statistics.plugin.parser.JsonParser;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonParserImpl implements JsonParser<JsonItem> {

    private final Gson gson;

    public JsonParserImpl() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(JsonItem.class, new JsonItemAdapter()) // Регистрируем адаптер
                .create();
    }
    @Override
    public List<JsonItem> fromJson(InputStream jsonDataPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(jsonDataPath, StandardCharsets.UTF_8))) {
            Type listType = new TypeToken<List<JsonItem>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (JsonSyntaxException e) {
            throw new IOException("Failed to parse JSON", e);
        }
    }

}
