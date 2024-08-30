package parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface JsonParser<T> {
    List<T> fromJson(String json) throws IOException;
}
