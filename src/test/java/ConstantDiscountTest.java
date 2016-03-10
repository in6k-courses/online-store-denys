import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import Shop.Discount.ConstantDiscount;
import Shop.Discount.Discount;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Денис on 10.03.2016.
 */
public class ConstantDiscountTest {
    Discount discount = new ConstantDiscount(0.1);

    @Test
    public void testApplyDiscountWithDoubleValue() {
        BigDecimal price = new BigDecimal(10);

        assertThat(discount.getCalculatedDiscount(price), is(new BigDecimal("1.0")));
    }

    @Test
    public void testApplyDiscountWithStringValue() {
        BigDecimal price = new BigDecimal("20");

        assertThat(discount.getCalculatedDiscount(price), is(new BigDecimal("2.0")));
    }
}
