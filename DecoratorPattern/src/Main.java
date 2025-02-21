import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PricingService pricingService = new PricingService();

        BigDecimal basePrice = new BigDecimal("100");

        // Scenario: Holiday + High Occupancy + Urgency
        BigDecimal finalPrice = pricingService.getDynamicPrice(basePrice, true, true, true);

        System.out.println("Final Price: $" + finalPrice);
    }
}