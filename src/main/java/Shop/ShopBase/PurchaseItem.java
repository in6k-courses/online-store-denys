package Shop.ShopBase;

import Shop.core.entity.Product;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Денис on 10.03.2016.
 */
public class PurchaseItem {
    private int id;
    private Product product; //TODO review this field
    private int product_id; //TODO review this field
    private BigDecimal price;
    private BigDecimal amount;
    private int orderId;

    public PurchaseItem(Product product, BigDecimal amount) {
        this.product = product;
        this.product_id = product.getId();
        this.price = new BigDecimal(BigInteger.ZERO).add(product.getCost());
        this.amount = amount;
    }

    public PurchaseItem(){
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
