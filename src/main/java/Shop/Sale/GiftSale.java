package Shop.Sale;

import Shop.Product;
import Shop.ShopAssortment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by employee on 3/4/16.
 */
public class GiftSale implements Sale {
    private static Map<Product, Product> salableProducts = new HashMap<Product, Product>();

    public GiftSale() {
        salableProducts.put(ShopAssortment.productList.get(0), new Product("Mars", "0"));
    }
        //TODO do not use those convensions
    public Product applySale(List<Product> _products) {
        for (Product pr : _products) {
            if (salableProducts.containsKey(pr)) {
                return salableProducts.get(pr);
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "* Gift Sale *";
    }

}
