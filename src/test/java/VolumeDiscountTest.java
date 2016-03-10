/**
 * Created by Денис on 10.03.2016.
 */

import Shop.Discount.Discount;
import Shop.Discount.VolumeDiscount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class VolumeDiscountTest {
    Discount discount = new VolumeDiscount(0.1, 10);

    @Test
    public void testApplyDiscountSuccess(){
        assertThat(discount.getCalculatedDiscount(new BigDecimal("20")), is(new BigDecimal("2.0")));
    }

    @Test
    public void testApplyDiscountFailure(){
        assertThat(discount.getCalculatedDiscount(new BigDecimal("2")), is(new BigDecimal("0")));
    }
}
