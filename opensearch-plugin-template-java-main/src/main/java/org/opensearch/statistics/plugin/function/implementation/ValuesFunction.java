package org.opensearch.statistics.plugin.function.implementation;

import org.opensearch.statistics.plugin.function.StatisticFunction;
import org.opensearch.statistics.plugin.model.JsonItem;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ValuesFunction implements StatisticFunction {
    @Override
    public String execute(List<JsonItem> jsonData) throws IOException {
        // Реализуйте логику для получения значений
        return jsonData.stream()
                .map(JsonItem::getHost)
                .filter(value-> value != null && !value.isEmpty())
                .distinct()
                .collect(Collectors.joining(", "));
    }
}
