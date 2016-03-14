package Shop.ShopBase;

import java.math.BigDecimal;

/**
 * Created by employee on 3/4/16.
 */
public class Product {
    private int id;
    private String name;
    private int category;
    private String category_name;
    private BigDecimal cost;

    public Product(){
    }

    public Product(String name, String category, String cost) {
        this.name = name;
        this.category_name = category;
        this.cost = new BigDecimal(cost);
    }

    public Product(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public int getCategory() {
        return category;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + category + " " + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product productIn = (Product) o;
        if (name != null ? !name.equals(productIn.name) : productIn.name != null) return false;
        if (category_name != null ? !category_name.equals(productIn.category_name) : productIn.category_name != null) return false;
        return cost != null ? cost.toString().equals(productIn.cost.toString()) : productIn.cost == null;
    }
}
