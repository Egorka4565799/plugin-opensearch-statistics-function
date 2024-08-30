package parser.implementaion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import model.JsonItem;
import parser.JsonParser;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class JsonParserImpl implements JsonParser<JsonItem> {

    private final Gson gson = new Gson();
    @Override
    public List<JsonItem> fromJson(String jsonDataPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonDataPath))) {
            Type listType = new TypeToken<List<JsonItem>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}

