import java.math.BigDecimal;

public class BaseRoomPrice implements Pricing {
    private final BigDecimal basePrice;

    public BaseRoomPrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public BigDecimal calculatePrice() {
        return basePrice;
    }
}
