package Shop.Discount;

import java.math.BigDecimal;

/**
 * Created by employee on 3/4/16.
 */
public class VolumeDiscount implements Discount {
    private int levelOfVolumeDiscount;
    private double valueDiscount;

    public VolumeDiscount(double _valueDiscount, int _levelOfVolumeDiscount) {
        this.valueDiscount = _valueDiscount;
        this.levelOfVolumeDiscount = _levelOfVolumeDiscount;
    }

    public BigDecimal getCalculatedDiscount(BigDecimal cost) {
        if (cost.intValue() >= levelOfVolumeDiscount) return cost.multiply(BigDecimal.valueOf(valueDiscount));
        return BigDecimal.ZERO;
    }

    public double getValueDiscount() {
        return valueDiscount;
    }

    public void setValueDiscount(double valueDiscount) {
        this.valueDiscount = valueDiscount;
    }

    public int getLevelOfVolumeDiscount() {
        return levelOfVolumeDiscount;
    }
}
