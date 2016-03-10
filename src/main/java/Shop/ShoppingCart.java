package Shop;

import Shop.Discount.Discount;
import Shop.Sale.GiftSale;
import Shop.Sale.Sale;
import Shop.Sale.MatchSale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/4/16.
 */
public class ShoppingCart {
    private List<Product> products = new ArrayList<Product>();
    private List<Discount> discounts = new ArrayList<Discount>();
    private List<Sale> sales = new ArrayList<Sale>();
    private BigDecimal totalCost = BigDecimal.ZERO;
    private BigDecimal totalCostWithoutDiscounts = BigDecimal.ZERO;
    private BigDecimal totalValueFormDiscounts = BigDecimal.ZERO;
    private BigDecimal totalDiscountFromProducts = BigDecimal.ZERO;

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public ShoppingCart(List<Product> selectedProducts) {

        for (Product item : selectedProducts) {
            products.add(new Product(item.getName(), item.getCost()));
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void calculateTotalCostWithoutDiscounts() {
        totalCostWithoutDiscounts = BigDecimal.ZERO;
        for (Product product : products) {
            totalCostWithoutDiscounts = totalCost.add(product.getCost());
        }
    }

    private void calculateTotalDiscountFromProducts() {
        totalValueFormDiscounts = BigDecimal.ZERO;
        for (Product product : products) {
            totalDiscountFromProducts = totalDiscountFromProducts.add(product.getDiscountValue());
        }
    }

    private BigDecimal calculateTotalDiscounts() {
        return totalValueFormDiscounts.add(totalDiscountFromProducts);
    }

    private void calculateTotalCost() {
        totalCost = totalCostWithoutDiscounts.subtract(calculateTotalDiscounts());
    }

    public void applyDiscounts() {
        totalValueFormDiscounts = BigDecimal.ZERO;
        for (Discount _disc : discounts) {
            totalValueFormDiscounts = totalValueFormDiscounts.add(_disc.getCalculatedDiscount(totalCost));
        }
    }

    public void applySales() {
        for (Sale _sale : sales) {
            if (_sale.applySale(products) != null)
                products.add(_sale.applySale(products));
        }
    }
    //- - - - - - - - - boring GETERS AND SETERS- - - - - - - - - - - - -

    public void refreshCartCosts() {
        calculateTotalCostWithoutDiscounts();
        calculateTotalDiscountFromProducts();
        calculateTotalCost();
    }

    public BigDecimal getTotalCost() {

        return totalCost;
    }

    public BigDecimal getTotalCostWithoutDiscounts() {
        return totalCostWithoutDiscounts;
    }

    public BigDecimal getTotalValueFormDiscounts() {
        return totalValueFormDiscounts;
    }

    public BigDecimal getTotalDiscount() {
        return totalValueFormDiscounts.add(totalDiscountFromProducts);
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public BigDecimal getTotalValueFormDiscount() {
        return totalValueFormDiscounts;
    }

    public void addSale(Sale saleBehavior) {
        sales.add(saleBehavior);
    }

    public void addProduct(Product _product) {
        products.add(_product);
    }

    public void addDiscount(Discount _discount) {
        discounts.add(_discount);
    }


    public List<Sale> getSalesList() {
        return sales;
    }

    public double getTotalDiscountFromProducts() {
        return totalDiscountFromProducts.doubleValue();
    }

    public void removeProduct(Product _product) {
        products.remove(_product);
    }

    public void removeSale(Sale saleBehavior) {
        sales.remove(saleBehavior);
    }

    public void removeDiscount(Discount _discount) {
        discounts.remove(_discount);
    }
}