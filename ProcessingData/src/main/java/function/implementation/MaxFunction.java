package function.implementation;

import function.StatisticFunction;
import model.JsonItem;

import java.io.IOException;
import java.util.List;

public class MaxFunction implements StatisticFunction {
    @Override
    public String execute(List<JsonItem> jsonData) throws IOException {
        // Реализуйте логику для нахождения максимума
        int max = jsonData.stream()
                .map(JsonItem::getUps_adv_output_voltage)
                .filter(value-> value != null)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        return String.valueOf(max);
    }
}