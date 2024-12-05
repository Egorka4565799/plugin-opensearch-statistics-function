package org.opensearch.statistics.plugin.function;

import org.opensearch.statistics.plugin.function.implementation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class StatisticsFunctionFactory {
    private static final Map<String, StatisticFunction> functions = new HashMap<>();

    static {
        functions.put("avg", new AverageFunction());
        functions.put("max", new MaxFunction());
        functions.put("values", new ValuesFunction());
    }

    public static StatisticFunction getFunction(String functionName) {
        return functions.getOrDefault(functionName.toLowerCase(Locale.ROOT), null);
    }
}
