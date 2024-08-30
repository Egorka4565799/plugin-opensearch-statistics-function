package function;

import model.JsonItem;

import java.io.IOException;
import java.util.List;

public interface StatisticFunction {
    String execute(List<JsonItem> jsonData) throws IOException;
}