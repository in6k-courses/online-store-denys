package Shop.Sale;

import Shop.ShopBase.PurchaseItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class MatchSale implements Sale {
    private BigDecimal discountValue;
    private List<PurchaseItem> matches = new ArrayList<PurchaseItem>();


    public MatchSale(String discontValue, List<PurchaseItem> matches) {
        this.discountValue = new BigDecimal(discontValue);
        this.matches.addAll(matches);
    }

    public void applySale(List<PurchaseItem> products) {
        if(products.containsAll(matches)){
            for (PurchaseItem pi: products) {
                if(matches.contains(pi)){
                    pi.setPrice(pi.getPrice().multiply(discountValue));
                }
            }
        }
    }

    public double getDiscountValue() {
        return discountValue.doubleValue();
    }


    @Override
    public String toString() {
        return "* Match Sale *";
    }

}
