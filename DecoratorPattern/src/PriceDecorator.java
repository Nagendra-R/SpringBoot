import java.math.BigDecimal;

public abstract class PriceDecorator implements Pricing {
    protected Pricing decoratedPrice;

    public PriceDecorator(Pricing decoratedPrice) {
        this.decoratedPrice = decoratedPrice;
    }

    @Override
    public BigDecimal calculatePrice() {
        return decoratedPrice.calculatePrice();
    }


}
