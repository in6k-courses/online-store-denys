package Shop.Sale;

import Shop.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by employee on 3/4/16.
 */
public class MatchSale implements Sale {
    private BigDecimal discountValue;
    //TODO it will be List
    private Map<String, String> matches = new HashMap<String, String>();


    public MatchSale(double _disc) {
        this.discountValue = BigDecimal.valueOf(_disc);
        this.matches.put("Cola", "Fanta");
    }

    public Product applySale(List<Product> _products) {
        findMatches(_products);
        return null;
    }
    //TODO rebuild this method
    private void findMatches(List<Product> _products){
        for (Product first : _products) {
            for (Product second : _products) {
                if (matches.containsValue(first.getName()))
                    if (matches.containsKey(second.getName())) {
                        giveProductsDiscount(first, second);
                    }
            }
        }
    }

    private void giveProductsDiscount(Product first, Product second){
        first.setDiscountValue(first.getCost().multiply(discountValue));
        second.setDiscountValue(second.getCost().multiply(discountValue));
    }

    public double getDiscountValue() {
        return discountValue.doubleValue();
    }

    @Override
    public String toString(){
        return "* Match Sale *";
    }

}
