package org.opensearch.statistics.plugin.model;

public class JsonItem {
    private Integer ups_adv_output_load;
    private Integer ups_adv_battery_temperature;
    private String timestamp;
    private String host;
    private Long ups_adv_battery_run_time_remaining;
    private Integer ups_adv_output_voltage;

    public JsonItem() {
    }

    public JsonItem(Integer ups_adv_output_load, Integer ups_adv_battery_temperature, String timestamp, String host, Long ups_adv_battery_run_time_remaining, Integer ups_adv_output_voltage) {
        this.ups_adv_output_load = ups_adv_output_load;
        this.ups_adv_battery_temperature = ups_adv_battery_temperature;
        this.timestamp = timestamp;
        this.host = host;
        this.ups_adv_battery_run_time_remaining = ups_adv_battery_run_time_remaining;
        this.ups_adv_output_voltage = ups_adv_output_voltage;
    }

    public Integer getUps_adv_output_load() {
        return ups_adv_output_load;
    }

    public void setUps_adv_output_load(Integer ups_adv_output_load) {
        this.ups_adv_output_load = ups_adv_output_load;
    }

    public Integer getUps_adv_battery_temperature() {
        return ups_adv_battery_temperature;
    }

    public void setUps_adv_battery_temperature(Integer ups_adv_battery_temperature) {
        this.ups_adv_battery_temperature = ups_adv_battery_temperature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getUps_adv_battery_run_time_remaining() {
        return ups_adv_battery_run_time_remaining;
    }

    public void setUps_adv_battery_run_time_remaining(Long ups_adv_battery_run_time_remaining) {
        this.ups_adv_battery_run_time_remaining = ups_adv_battery_run_time_remaining;
    }

    public Integer getUps_adv_output_voltage() {
        return ups_adv_output_voltage;
    }

    public void setUps_adv_output_voltage(Integer ups_adv_output_voltage) {
        this.ups_adv_output_voltage = ups_adv_output_voltage;
    }
}
