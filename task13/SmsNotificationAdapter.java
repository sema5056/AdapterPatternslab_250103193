package task13;
public class SmsNotificationAdapter implements IPushNotifier {
    private final ThirdPartySmsProvider thirdPartySmsProvider;
    public SmsNotificationAdapter(ThirdPartySmsProvider thirdPartySmsProvider) {
        this.thirdPartySmsProvider = thirdPartySmsProvider;
    }
    @Override
    public void notify(AlertMessage alert) {
        if (alert == null) {
            throw new IllegalArgumentException("alert must not be null");
        }
        String phone = alert.userPhone();
        if (phone == null || !phone.startsWith("+")) {
            phone = "+" + phone;
        }
        String text = "[" + alert.title() + "] " + alert.body();
        thirdPartySmsProvider.sendSms(phone, text);
    }
}