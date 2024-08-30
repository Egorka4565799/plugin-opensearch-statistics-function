import function.StatisticFunction;
import function.StatisticsFunctionFactory;
import model.JsonItem;
import parser.JsonParser;
import parser.implementaion.JsonParserImpl;

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


    public String executeFunction(String functionName, String jsonDataPath) throws IOException {

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
