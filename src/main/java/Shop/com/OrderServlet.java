package Shop.com;

import Shop.CustomExceptions.PersistException;
import Shop.Order;
import Shop.User;
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
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by employee on 3/17/16.
 */
public class OrderServlet extends HttpServlet {
    private DAOFactory<Connection> factory;

    private Connection connection;
    private HttpSession session;

    private List<PurchaseItem> purchaseItems;
    private BigDecimal totalPrice = BigDecimal.ZERO;

    private String firstName;
    private String lastName;
    private String telephone;

    private User user;
    private Order order;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connectToDB();
        session = req.getSession();
        purchaseItems = (List<PurchaseItem>) session.getAttribute("purchaseItems");

        calculateTotalPriceOfOrder();

        getUserInfoFromREQ(req);
        try {
            addUser();
            addOrder();
            addPurchaseItems();
        } catch (PersistException e){
            resp.sendRedirect("error.jsp");
        }

        session.invalidate();

        resp.sendRedirect("succes.jsp");
    }

    private void connectToDB() {
        try {
            factory = new MySQLDAOFactory();
            connection = factory.getContext();
        } catch (Exception e) {
            System.out.println("connection problem");
        }
    }

    private void calculateTotalPriceOfOrder(){
        for (PurchaseItem pi: purchaseItems) {
            totalPrice = totalPrice.add(pi.getPrice());
        }
    }

    private void getUserInfoFromREQ(HttpServletRequest req){
        firstName = req.getParameter("f_name");
        lastName = req.getParameter("l_name");
        telephone = req.getParameter("tel");
    }

    private void addUser() throws PersistException{
        user = new User(firstName, lastName, telephone);

        user = (User) factory.getDAO(connection, User.class).create(user);
    }

    private void addOrder() throws PersistException{
        order = new Order();
        order.setUserId(user.getId());
        order.setTotalPrice(totalPrice);

        order = (Order) factory.getDAO(connection, Order.class).create(order);
    }

    private void addPurchaseItems() throws PersistException{
        for (PurchaseItem pi: purchaseItems) {
            pi.setOrderId(order.getId());

            pi = (PurchaseItem) factory.getDAO(connection, PurchaseItem.class).create(pi);
        }
    }
}
