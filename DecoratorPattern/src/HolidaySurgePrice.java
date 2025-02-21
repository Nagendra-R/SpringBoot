import java.math.BigDecimal;

public class HolidaySurgePrice extends PriceDecorator {

    public HolidaySurgePrice(Pricing decoratedPrice) {
        super(decoratedPrice);
    }

    @Override
    public BigDecimal calculatePrice() {
        return super.calculatePrice().multiply(BigDecimal.valueOf(1.5)); // 50% increase
    }
}
