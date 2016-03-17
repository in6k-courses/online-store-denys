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
import java.sql.Connection;
import java.sql.SQLException;
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

    private String firstName;
    private String lastName;
    private String telephone;

    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connectToDB();
        session = req.getSession();
        purchaseItems = (List<PurchaseItem>) session.getAttribute("purchaseItems");

        getUserInfoFromREQ(req);

        addUser();

        addOrder();

        addPurchaseItems();
        ////
        PrintWriter out = resp.getWriter();
        out.print("ADDED");
    }

    private void connectToDB() {
        try {
            factory = new MySQLDAOFactory();
            connection = factory.getContext();
        } catch (Exception e) {
            System.out.println("connection problem");
        }
    }

    private void getUserInfoFromREQ(HttpServletRequest req){
        firstName = req.getParameter("f_name");
        lastName = req.getParameter("l_name");
        telephone = req.getParameter("tel");
    }

    private void addUser(){
        user = new User(firstName, lastName, telephone);

        try {
            factory.getDAO(connection, User.class).create(user);
            user = factory.getDAO(connection, User.class).
        } catch (PersistException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

    private void addOrder(){
        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setUserId(user.getId());
    }

    private void addPurchaseItems(){
        for (PurchaseItem pi: purchaseItems) {
            factory.getDAO(connection, User.class).create(user);
        }
    }
}
