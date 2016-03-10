package Shop.Discount;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal getCalculatedDiscount(BigDecimal _totalCost);
}
