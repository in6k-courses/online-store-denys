package Shop.Sale;

import Shop.ShopBase.PurchaseItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class GiftSale implements Sale {
    private List<PurchaseItem> promotionalItems;
    private PurchaseItem giftProduct;

    public GiftSale(List<PurchaseItem> promotionalProducts, PurchaseItem giftProduct) {
        this.promotionalItems = new ArrayList<PurchaseItem>();
        this.promotionalItems.addAll(promotionalProducts);
        this.giftProduct = giftProduct;
    }

    public void applySale(List<PurchaseItem> products) {
        if(products.containsAll(promotionalItems))
            products.add(giftProduct);
    }

    @Override
    public String toString(){
        return "* Gift Sale *";
    }

}
