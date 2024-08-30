package org.opensearch.statistics.plugin.function.implementation;

import org.opensearch.statistics.plugin.function.StatisticFunction;
import org.opensearch.statistics.plugin.model.JsonItem;

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
