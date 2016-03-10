package Shop.Discount;

import java.math.BigDecimal;

/**
 * Created by Денис on 10.03.2016.
 */
public class NoDiscount implements Discount {
    public BigDecimal getCalculatedDiscount(BigDecimal totalCost) {
        return totalCost;
    }
}
