package Shop.com;

import Shop.CompletedOrder;
import Shop.CustomExceptions.PersistException;
import Shop.ShopBase.Category;
import Shop.db.dao.DAOFactory;
import Shop.db.dao.MySQLDAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by employee on 3/18/16.
 */
public class ChangeStatusToOrder extends HttpServlet {
    private List<CompletedOrder> completedOrders;
    private DAOFactory<Connection> factory;
    Connection connection;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connectToDB();
        int orderId = Integer.valueOf(req.getParameter("id_order"));
        changeStatus(orderId);


        resp.sendRedirect("admin.jsp");
    }

    public void connectToDB(){
        try {
            factory = new MySQLDAOFactory();
            connection = factory.getContext();
            completedOrders = factory.getDAO(connection, CompletedOrder.class).getAll();
        } catch (PersistException e){
            e.printStackTrace();
        }
    }

    public void changeStatus(int id){
        try {
        factory.getDAO(connection, CompletedOrder.class).update(completedOrders.get(id));
        } catch (PersistException e){
            e.printStackTrace();
        }
    }
}
