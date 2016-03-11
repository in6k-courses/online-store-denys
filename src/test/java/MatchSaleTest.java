/**
 * Created by Денис on 10.03.2016.
 */
import Shop.Sale.MatchSale;
import Shop.Sale.Sale;
import Shop.ShopBase.Product;
import Shop.ShopBase.PurchaseItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MatchSaleTest {
    @Test
    public void testApplySale() {
        List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>();
        List<PurchaseItem> matchItems = new ArrayList<PurchaseItem>();

        Product cola = new Product("Cola","drinks", "10");
        PurchaseItem colaPI = new PurchaseItem(cola, new BigDecimal(1));
        purchaseItems.add(colaPI);

        Product fanta = new Product("Fanta","drinks", "8");
        PurchaseItem fantaPI = new PurchaseItem(fanta, new BigDecimal(2));
        purchaseItems.add(fantaPI);


        Product sprite = new Product("Sprite","drinks", "8");
        purchaseItems.add(new PurchaseItem(sprite, new BigDecimal(1)));

        Product pen = new Product("Pen","stationery", "2");
        purchaseItems.add(new PurchaseItem(pen, new BigDecimal(1)));

        matchItems.add(colaPI);
        matchItems.add(fantaPI);
        Sale sale = new MatchSale("0.1", matchItems);
        sale.applySale(purchaseItems);

        assertThat(fantaPI.getPrice(), is(new BigDecimal("0.8")));
        assertThat(colaPI.getPrice(), is(new BigDecimal("1.0")));
    }
}
