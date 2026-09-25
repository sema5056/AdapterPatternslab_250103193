package task14;

import java.util.LinkedHashMap;
import java.util.Map;

public class TelemetryFeedAdapter implements ITelemetryService {
    private final LegacySensorFeed legacySensorFeed;
    public TelemetryFeedAdapter(LegacySensorFeed legacySensorFeed) {
        this.legacySensorFeed = legacySensorFeed;
    }
    @Override
    public Map<String, String> getCleanTelemetry() {
        String raw = legacySensorFeed.getRawTelemetry();
        Map<String, String> result = new LinkedHashMap<>();

        if (raw == null || raw.isBlank()) {
            return result;
        }
        String[] tokens = raw.split(";");
        for (String token : tokens) {
            String trimmed = token.trim();
            if (trimmed.isEmpty() || !trimmed.contains("=")) {
                continue;
            }
            String[] parts = trimmed.split("=", 2);
            String key = parts[0].trim();
            String value = parts[1].trim();

            if (key.isEmpty()) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }
}