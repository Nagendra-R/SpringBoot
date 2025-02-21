import java.math.BigDecimal;

public class UrgencySurgePrice extends PriceDecorator {

    public UrgencySurgePrice(Pricing decoratedPrice) {
        super(decoratedPrice);
    }

    @Override
    public BigDecimal calculatePrice() {
        return super.calculatePrice().multiply(BigDecimal.valueOf(1.3)); // 30% increase
    }
}
