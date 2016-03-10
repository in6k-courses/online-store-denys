package Shop.Discount;

import java.math.BigDecimal;

/**
 * Created by employee on 3/4/16.
 */
public class ConstantDiscount implements Discount {
    private double valueDiscount = 0.1;

    public ConstantDiscount(double _valueDiscount){
        this.valueDiscount = _valueDiscount;

    }

    public BigDecimal getCalculatedDiscount(BigDecimal cost){
        BigDecimal disc = cost.multiply(BigDecimal.valueOf(valueDiscount));
        return disc;
    }

    public void setValueDiscount(double valueDiscount){
        this.valueDiscount = valueDiscount;
    }

    public double getValueDiscount() {
        return valueDiscount;
    }
}
