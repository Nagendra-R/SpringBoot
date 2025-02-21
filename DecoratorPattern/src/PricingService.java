import java.math.BigDecimal;

public class PricingService {

    public BigDecimal getDynamicPrice(BigDecimal basePrice, boolean isHoliday, boolean isHighOccupancy, boolean isUrgent) {
        Pricing pricing = new BaseRoomPrice(basePrice);

        if (isHoliday) {
            pricing = new HolidaySurgePrice(pricing);
            System.out.println(pricing);
        }
        if (isHighOccupancy) {
            pricing = new HighOccupancySurgePrice(pricing);
            System.out.println(pricing);
        }
        if (isUrgent) {
            pricing = new UrgencySurgePrice(pricing);
            System.out.println(pricing);
        }

        return pricing.calculatePrice();
    }
}
