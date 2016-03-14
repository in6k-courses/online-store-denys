/**
 * Created by employee on 3/14/16.
 */

import Shop.ShopBase.Product;
import Shop.db.DAOFactory;
import Shop.db.MySQLDAOFactory;
import Shop.db.ProductDAO;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MySQLProductDAOTest {

    @Test
    public void testGetAll(){
        DAOFactory daoFactory = new MySQLDAOFactory();
        List<Product> productList = null;
        try{
            Connection con = daoFactory.getConnection();
            ProductDAO dao  = daoFactory.getProductDAO(con);
            productList = dao.getAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull(productList);
        assertTrue(productList.size()>0);
    }

    //TODO test this after exception handling
    @Ignore
    public void testRead(){
        DAOFactory daoFactory = new MySQLDAOFactory();
        Product product = null;
        try{
            Connection con = daoFactory.getConnection();
            ProductDAO dao = daoFactory.getProductDAO(con);
            product = dao.read(1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertTrue(product!=null);
    }

    //TODO ignore them later
    @Test
    public void testUpdate(){
        DAOFactory daoFactory = new MySQLDAOFactory();
        Product product = new Product();
        product.setCategory(1);
        product.setName("name");
        product.setId(1);
        product.setCost(BigDecimal.ZERO);
        try{
            Connection con = daoFactory.getConnection();
            ProductDAO dao  = daoFactory.getProductDAO(con);
            dao.update(product);
        }
        catch(SQLException e){
            System.out.println("update fail");
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        DAOFactory daoFactory = new MySQLDAOFactory();
        Product product = new Product();
        product.setCategory(1);
        product.setName("name");
        product.setId(12);
        product.setCost(BigDecimal.ZERO);
        try{
            Connection con = daoFactory.getConnection();
            ProductDAO dao  = daoFactory.getProductDAO(con);
            dao.delete(product);
        }
        catch(SQLException e){
            System.out.println("delete fail");
            e.printStackTrace();
        }

    }
}
