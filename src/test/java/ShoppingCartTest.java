/**
 * Created by Денис on 10.03.2016.
 */

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import Shop.Discount.ConstantDiscount;
import Shop.ShopBase.Product;
import Shop.ShopBase.PurchaseItem;
import Shop.ShoppingCart;
import org.junit.Test;

import java.math.BigDecimal;


public class ShoppingCartTest {
    ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    public void testGetTotalPriceWithoutEverything() {
        Product cola = new Product("Cola", "10");
        shoppingCart.addPurchaseItem(new PurchaseItem(cola, new BigDecimal(1)));

        Product fanta = new Product("Fanta", "8");
        shoppingCart.addPurchaseItem(new PurchaseItem(fanta, new BigDecimal(2)));

        Product sprite = new Product("Sprite", "8");
        shoppingCart.addPurchaseItem(new PurchaseItem(sprite, new BigDecimal(1)));

        shoppingCart.calculateTotalPrice();

        assertThat(shoppingCart.getTotalPrice(), is(new BigDecimal(34)));
    }

    @Test
    public void testGetTotalPriceWithConstantDiscount() {
        Product cola = new Product("Cola", "10");
        shoppingCart.addPurchaseItem(new PurchaseItem(cola, new BigDecimal( 1)));

        Product fanta = new Product("Fanta", "8");
        shoppingCart.addPurchaseItem(new PurchaseItem(fanta, new BigDecimal(2)));

        Product sprite = new Product("Sprite", "8");
        shoppingCart.addPurchaseItem(new PurchaseItem(sprite, new BigDecimal(1)));

        shoppingCart.calculateTotalPrice();

        shoppingCart.addDiscount(new ConstantDiscount(0.1));
        shoppingCart.applyDiscount();

        assertThat(shoppingCart.getTotalPrice(), is(new BigDecimal("30.6")));
    }
}
