package org.opensearch.statistics.plugin;

import org.opensearch.statistics.plugin.function.StatisticFunction;
import org.opensearch.statistics.plugin.function.StatisticsFunctionFactory;
import org.opensearch.statistics.plugin.model.JsonItem;
import org.opensearch.statistics.plugin.parser.JsonParser;
import org.opensearch.statistics.plugin.parser.implementaion.JsonParserImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

public class ExecuteService {
    private final StatisticsFunctionFactory functionFactory;
    private final JsonParser<JsonItem> jsonParser;

    public ExecuteService() {
        this.functionFactory = new StatisticsFunctionFactory();
        this.jsonParser = new JsonParserImpl();
    }


    public String executeFunction(String functionName, InputStream jsonDataPath) throws IOException {

        List<JsonItem> jsonData = jsonParser.fromJson(jsonDataPath);

        // Создание функции с использованием фабрики
        StatisticFunction function;
        try {
            function = functionFactory.getFunction(functionName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown function: " + functionName, e);
        }

        // Выполнение функции и возвращение результата
        try {
            return function.execute(jsonData);
        } catch (IOException e) {
            throw new IOException("Error while executing function: " + functionName, e);
        }
    }

}
