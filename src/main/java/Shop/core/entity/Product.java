package Shop.core.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by employee on 3/4/16.
 */
@Entity
public class Product {
    private int id;
    private String name;
    private BigDecimal cost;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(){
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }


    @Override
    public String toString(){
        return id + " " + name + " " + cost;
    }

    @Override //TODO here some changes. To equals please add category.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product productIn = (Product) o;
        if (name != null ? !name.equals(productIn.name) : productIn.name != null) return false;
        return cost != null ? cost.toString().equals(productIn.cost.toString()) : productIn.cost == null;
    }
}
