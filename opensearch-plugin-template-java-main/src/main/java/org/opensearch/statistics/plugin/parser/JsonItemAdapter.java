package org.opensearch.statistics.plugin.parser;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.opensearch.statistics.plugin.model.JsonItem;

import java.io.IOException;

public class JsonItemAdapter extends TypeAdapter<JsonItem> {

    @Override
    public void write(JsonWriter out, JsonItem value) throws IOException {
        out.beginObject();
        out.name("ups_adv_output_load").value(value.getUps_adv_output_load());
        out.name("ups_adv_battery_temperature").value(value.getUps_adv_battery_temperature());
        out.name("timestamp").value(value.getTimestamp());
        out.name("host").value(value.getHost());
        out.name("ups_adv_battery_run_time_remaining").value(value.getUps_adv_battery_run_time_remaining());
        out.name("ups_adv_output_voltage").value(value.getUps_adv_output_voltage());
        out.endObject();
    }

    @Override
    public JsonItem read(JsonReader in) throws IOException {
        JsonItem item = new JsonItem();
        in.beginObject();
        while (in.hasNext()) {
            String name = in.nextName();
            switch (name) {
                case "ups_adv_output_load":
                    if (in.peek() != JsonToken.NULL) {
                        item.setUps_adv_output_load(in.nextInt());
                    } else {
                        in.nextNull(); // Пропускаем null в потоке
                        item.setUps_adv_output_load(null);
                    }
                    break;
                case "ups_adv_battery_temperature":
                    if (in.peek() != JsonToken.NULL) {
                        item.setUps_adv_battery_temperature(in.nextInt());
                    } else {
                        in.nextNull(); // Пропускаем null в потоке
                        item.setUps_adv_battery_temperature(null);
                    }
                    break;
                case "timestamp":
                    if (in.peek() != JsonToken.NULL) {
                        item.setTimestamp(in.nextString());
                    } else {
                        in.nextNull(); // Пропускаем null в потоке
                        item.setTimestamp(null);
                    }
                    break;
                case "host":
                    if (in.peek() != JsonToken.NULL) {
                        item.setHost(in.nextString());
                    } else {
                        in.nextNull(); // Пропускаем null в потоке
                        item.setHost(null);
                    }
                    break;
                case "ups_adv_battery_run_time_remaining":
                    if (in.peek() != JsonToken.NULL) {
                        item.setUps_adv_battery_run_time_remaining(in.nextLong());
                    } else {
                        in.nextNull(); // Пропускаем null в потоке
                        item.setUps_adv_battery_run_time_remaining(null);
                    }
                    break;
                case "ups_adv_output_voltage":
                    if (in.peek() != JsonToken.NULL) {
                        item.setUps_adv_output_voltage(in.nextInt());
                    } else {
                        in.nextNull(); // Пропускаем null в потоке
                        item.setUps_adv_output_voltage(null);
                    }
                    break;
                default:
                    in.skipValue(); // Пропускаем неизвестное значение
                    break;
            }
        }
        in.endObject();
        return item;
    }
}
