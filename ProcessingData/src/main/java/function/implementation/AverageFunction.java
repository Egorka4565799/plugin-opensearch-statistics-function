package function.implementation;

import function.StatisticFunction;
import model.JsonItem;

import java.io.IOException;
import java.util.List;

public class AverageFunction implements StatisticFunction {
    @Override
    public String execute(List<JsonItem> jsonData) throws IOException {

        double average = jsonData.stream()
                .map(JsonItem::getUps_adv_battery_run_time_remaining)
                .filter(value -> value != null)
                .mapToDouble(Long::doubleValue)
                .average()
                .orElse(0.0);

        return String.valueOf(average);
    }
}
