package Shop.core.model;

import Shop.core.entity.Product;

import java.math.BigDecimal;

/**
 * Created by employee on 3/22/16.
 */
public class PurchaseItem {
    private int id;
    private Product product;
    private BigDecimal amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
