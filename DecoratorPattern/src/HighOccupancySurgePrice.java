import java.math.BigDecimal;

public class HighOccupancySurgePrice extends PriceDecorator {

    public HighOccupancySurgePrice(Pricing decoratedPrice) {
        super(decoratedPrice);
    }

    @Override
    public BigDecimal calculatePrice() {
        return super.calculatePrice().multiply(BigDecimal.valueOf(1.2)); // 20% increase
    }
}
