import Shop.Sale.GiftSale;
import Shop.Sale.Sale;
import Shop.ShopBase.Product;
import Shop.ShopBase.PurchaseItem;
import org.junit.Test;

/**
 * Created by Денис on 10.03.2016.
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GiftSaleTest {
    @Test
    public void testApplySaleSuccess() {
        List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>();
        List<PurchaseItem> promotionalItems = new ArrayList<PurchaseItem>();
        Product cola = new Product("Cola","drinks", "10");
        purchaseItems.add(new PurchaseItem(cola, new BigDecimal(1)));

        Product fanta = new Product("Fanta","drinks", "8");
        purchaseItems.add(new PurchaseItem(fanta, new BigDecimal(1)));

        Product sprite = new Product("Sprite","drinks", "8");
        PurchaseItem spritePI = new PurchaseItem(sprite, new BigDecimal(1));
        purchaseItems.add(spritePI);

        Product gift = new Product("Gift", BigDecimal.ZERO);
        PurchaseItem giftPI = new PurchaseItem(gift, new BigDecimal(1));

        promotionalItems.add(spritePI);

        Sale sale = new GiftSale(purchaseItems, giftPI);

        sale.applySale(purchaseItems);
        assertThat(purchaseItems, hasItem(giftPI));
    }

}
