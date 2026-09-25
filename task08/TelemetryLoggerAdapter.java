package task08;
public class TelemetryLoggerAdapter implements ISimpleLogger {
    private final EnterpriseTelemetryLogger enterpriseTelemetryLogger;
    private final String appName;
    public TelemetryLoggerAdapter(EnterpriseTelemetryLogger enterpriseTelemetryLogger, String appName) {
        this.enterpriseTelemetryLogger = enterpriseTelemetryLogger;
        this.appName = appName;
    }
    @Override
    public void info(String message) {
        enterpriseTelemetryLogger.writeLog(1, appName, message);
    }
    @Override
    public void warn(String message) {
        enterpriseTelemetryLogger.writeLog(2, appName, message);
    }
    @Override
    public void error(String message) {
        enterpriseTelemetryLogger.writeLog(3, appName, message);
    }
}