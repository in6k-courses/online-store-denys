package Shop.Sale;

import Shop.ShopBase.PurchaseItem;

import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public interface Sale {
    void applySale(List<PurchaseItem> purchaseItems);
}
