package Shop.ShopBase;

import java.math.BigDecimal;

/**
 * Created by Денис on 10.03.2016.
 */
public class PurchaseItem {
    private Product product;
    private BigDecimal price;
    private BigDecimal amount;

    public PurchaseItem(Product product, BigDecimal amount) {
        this.product = product;
        this.price = product.getCost();
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseItem)) return false;
        PurchaseItem purchaseItem = (PurchaseItem) o;
        if (product != null ? !product.equals(purchaseItem.product) : purchaseItem.product != null)
            return false;
        if(price != null ? !price.equals(purchaseItem.price) : purchaseItem.price != null)
            return false;
        return amount != null ? amount.equals(purchaseItem.amount) : purchaseItem.amount == null;
    }
}
