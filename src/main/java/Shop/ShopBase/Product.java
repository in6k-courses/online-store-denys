package Shop.ShopBase;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by employee on 3/4/16.
 */
public class Product {
    private String name;
    private String category;
    private BigDecimal cost;

    public Product(String name, String category, String cost) {
        this.name = name;
        this.category = category;
        this.cost = new BigDecimal(cost);
    }

    public Product(String name, double cost) {
        this.name = name;
        this.cost = new BigDecimal(cost);
    }

    public Product(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product productIn = (Product) o;
        if (name != null ? !name.equals(productIn.name) : productIn.name != null) return false;
        if (category != null ? !category.equals(productIn.category) : productIn.category != null) return false;
        return cost != null ? cost.toString().equals(productIn.cost.toString()) : productIn.cost == null;
    }
}
