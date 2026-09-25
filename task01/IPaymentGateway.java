package task01;
import java.math.BigDecimal;
public interface IPaymentGateway {
    void processPayment(int customerId, BigDecimal amountInDollars);
}