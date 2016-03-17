package Shop.ShopBase;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Денис on 10.03.2016.
 */
public class PurchaseItem {
    private Product product;
    private BigDecimal price;
    private BigDecimal amount;
    private int ordierId;

    public PurchaseItem(Product product, BigDecimal amount) {
        this.product = product;
        this.price = new BigDecimal(BigInteger.ZERO).add(product.getCost());
        this.amount = amount;
    }

    public int getOrdierId() {
        return ordierId;
    }

    public void setOrdierId(int ordierId) {
        this.ordierId = ordierId;
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

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void addAmount(BigDecimal addAmount){
        this.amount = this.amount.add(addAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseItem)) return false;
        PurchaseItem purchaseItem = (PurchaseItem) o;
        if (product != null ? !product.equals(purchaseItem.product) : purchaseItem.product != null)
            return false;
        return price != null ? price.equals(purchaseItem.price) : purchaseItem.price == null;
    }
}
