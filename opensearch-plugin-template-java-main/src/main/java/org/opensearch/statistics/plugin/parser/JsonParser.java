package org.opensearch.statistics.plugin.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface JsonParser<T> {
    List<T> fromJson(InputStream json) throws IOException;
}
