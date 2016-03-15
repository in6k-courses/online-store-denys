package Shop.com;

import Shop.CustomExceptions.PersistException;
import Shop.ShopBase.Category;
import Shop.ShopBase.Product;
import Shop.db.MySQLCategoryDAO;
import Shop.db.MySQLProductDAO;
import Shop.db.dao.DAOFactory;
import Shop.db.dao.GenericDAO;
import Shop.db.dao.MySQLDAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by employee on 3/15/16.
 */
public class MainPageServlet extends HttpServlet {
    Connection connection;
    DAOFactory<Connection> factory = new MySQLDAOFactory();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        try {
            connection = factory.getContext();
            List<Category> c = factory.getDAO(connection, Category.class).getAll();
            out.println(c);
        } catch (PersistException e){
            out.print(e.getMessage());
        }


    }

}
