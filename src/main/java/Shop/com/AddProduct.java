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

public class AddProduct extends HttpServlet {
    DAOFactory<Connection> factory;
    Connection connection;
    List<Product> productsBase;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connectToDB();
        int amount = Integer.valueOf(req.getParameter("amount"));
        int product_id = Integer.valueOf(req.getParameter("product_id"));
        List<PurchaseItem> purchaseList;
        HttpSession session = req.getSession(true);

        PrintWriter out = resp.getWriter();

        if (session.getAttribute("purchaseList") == null ) {
            purchaseList = new ArrayList<PurchaseItem>();
        } else {
            purchaseList = (List<PurchaseItem>) session.getAttribute("purchaseList");
        }
        purchaseList.add(new PurchaseItem(productsBase.get(product_id-1), new BigDecimal(amount)));
        session.setAttribute("purchaseList", purchaseList);

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

}
