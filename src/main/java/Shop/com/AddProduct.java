package Shop.com;

import Shop.ShopBase.Product;
import Shop.ShopBase.PurchaseItem;
import Shop.db.dao.DAOFactory;
import Shop.db.dao.MySQLDAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/15/16.
 */

//TODO think about changing List<PurchaseItem> to ShoppingCart entity

public class AddProduct extends HttpServlet {
    private DAOFactory<Connection> factory;
    private Connection connection;
    private List<Product> productsBase;
    private List<PurchaseItem> purchaseItems;
    private BigDecimal amount;
    private HttpSession session;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connectToDB();
        session = req.getSession();
        amount = validateAmount(req.getParameter("amount"));
        int product_id = Integer.valueOf(req.getParameter("product_id")) - 1;


        setPurchaseItems();

        PurchaseItem newPurchaseItem = new PurchaseItem(productsBase.get(product_id), amount);

        addProduct(newPurchaseItem);

        session.setAttribute("purchaseItems", purchaseItems);
        session.setAttribute("cartSize", purchaseItems.size());
        resp.sendRedirect("cart.jsp");
    }



    private void connectToDB() {
        try {
            factory = new MySQLDAOFactory();
            connection = factory.getContext();
            productsBase = factory.getDAO(connection, Product.class).getAll();
        } catch (Exception e) {
            System.out.println("connection problem");
        }
    }

    private BigDecimal validateAmount(String amount){
        return new BigDecimal(amount).doubleValue() < 0 ? BigDecimal.ZERO : new BigDecimal(amount);
    }

    private void setPurchaseItems(){
        if (session.getAttribute("purchaseItems") == null ) {
            purchaseItems = new ArrayList<PurchaseItem>();
        } else {
            purchaseItems = (List<PurchaseItem>) session.getAttribute("purchaseItems");
        }
    }

    private void addProduct(PurchaseItem newPurchaseItem){
        int index = purchaseItems.indexOf(newPurchaseItem);
        if(index == -1){
            purchaseItems.add(newPurchaseItem);
        } else {
            purchaseItems.get(index).addAmount(amount);
        }
    }



}
