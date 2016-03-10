package Shop;

import Shop.Discount.Discount;
import Shop.Discount.NoDiscount;
import Shop.Sale.NoSale;
import Shop.Sale.Sale;
import Shop.ShopBase.PurchaseItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class ShoppingCart {
    private List<PurchaseItem> purchaseItems;
    private Discount discount;
    private Sale sale;
    private BigDecimal totalPrice;

    public ShoppingCart() {
        purchaseItems = new ArrayList<PurchaseItem>();
        sale = new NoSale();
        discount = new NoDiscount();
        totalPrice = BigDecimal.ZERO;
    }

    public void addPurchaseItem(PurchaseItem pi) {
        purchaseItems.add(pi);
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void calculateTotalPrice() {
        totalPrice = BigDecimal.ZERO;
        for (PurchaseItem pi : purchaseItems) {
            totalPrice = totalPrice.add(pi.getPrice().multiply(pi.getAmount()));
        }
    }

    public void applySale() {
        sale.applySale(purchaseItems);
    }

    public void applyDiscount() {
        totalPrice = totalPrice.subtract(discount.getCalculatedDiscount(totalPrice));
    }

    public void addSale(Sale sale) {
        this.sale = sale;
    }

    public void addDiscount(Discount discount) {
        this.discount = discount;
    }
}