package task02;
public class TemperatureSensorAdapter implements ICelsiusSensor {
    private final FahrenheitSensor fahrenheitSensor;
    public TemperatureSensorAdapter(FahrenheitSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }
    @Override
    public double getTemperatureInCelsius() {
        String raw = fahrenheitSensor.readRawTemperature();
        String numericPart = raw.trim().replace("F", "").trim();
        double fahrenheit = Double.parseDouble(numericPart);
        double celsius = (fahrenheit - 32) * (5.0 / 9.0);task3
        return Math.round(celsius * 100.0) / 100.0;
    }
}