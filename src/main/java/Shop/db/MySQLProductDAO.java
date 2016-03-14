package Shop.db;

import Shop.CustomExceptions.SQLDataBaseException;
import Shop.ShopBase.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/14/16.
 */
//TODO write exception handlers
public class MySQLProductDAO implements ProductDAO{
    private final Connection connection;

    public MySQLProductDAO(Connection connection){
        this.connection = connection;
    }

    public Product create(Product product) {
        if(product != null){

        }
        String sql = "INSERT INTO shop.products ";
        return null;
    }

    public Product read(int key) throws SQLException{
        String sql = "SELECT * FROM shop.products WHERE id = ?;";
        PreparedStatement prstm = connection.prepareStatement(sql);
        prstm.setInt(1, key);
        ResultSet rs = prstm.executeQuery();
        Product pr = new Product();

        rs.next();
        pr.setId(rs.getInt("id"));
        pr.setName(rs.getString("name"));
        pr.setCost(rs.getBigDecimal("cost"));
        pr.setCategory(rs.getInt("category_id"));

        return pr;
    }

    public void update(Product product) throws SQLException{
        String sql = "UPDATE shop.products SET category_id = ?, name = ?, cost = ? WHERE id = ?;";
        try {
            PreparedStatement prstm = connection.prepareStatement(sql);

            prstm.setInt(1, product.getCategory());
            prstm.setString(2, product.getName());
            prstm.setBigDecimal(3, product.getCost());
            prstm.setInt(4, product.getId());

            int count = prstm.executeUpdate();
            if(count != 1) {
                throw new SQLDataBaseException("On update modify not 1 record: " + count);
            }
        } catch (SQLException e){
            throw new SQLException();
        }
    }

    public void delete(Product product) throws SQLException{
        String sql = "DELETE FROM shop.products WHERE id = ?";
        try {
            PreparedStatement prstm = connection.prepareStatement(sql);
            prstm.setInt(1, product.getId());
            int count = prstm.executeUpdate();
            if(count != 1){
                throw new SQLDataBaseException("On delete modify not 1 record: " + count);
            }
        } catch (SQLException e){
            throw new SQLException();
        }
    }

    public List<Product> getAll() throws SQLException{
        String sql = "SELECT * FROM shop.products";
        PreparedStatement prstm = connection.prepareStatement(sql);
        ResultSet rs = prstm.executeQuery();
        List<Product> productList = new ArrayList<Product>();
        while(rs.next()){
            Product pr = new Product();
            pr.setId(rs.getInt("id"));
            //TODO write trully pr.setCategory()
            pr.setCategory(rs.getInt("category_id"));
            //
            pr.setCost(rs.getBigDecimal("cost"));
            pr.setName(rs.getString("name"));
            productList.add(pr);
        }
        return productList;
    }
}
