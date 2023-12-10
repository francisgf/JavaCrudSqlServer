package com.app.Dao;

import Config.Connections;
import com.app.Generic.CrudOperations;
import com.app.Model.Product;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author FRANCIS MCH
 */
public class ProductDao implements CrudOperations<Product> {

    private static final String INSERT_PRODUCT = "EXEC [dbo].[INSERT_PRODUCT]?,?,?";
    private static final String DELETE_PRODUCT = "EXEC [dbo].[DELETE_PRODUCT_BY_ID]?";

    @Override
    public Product insert(Product Object) {

        Connections connection = new Connections();
        try {

            connection.st = connection.conn.createStatement();
            PreparedStatement smt = connection.conn.prepareStatement(INSERT_PRODUCT);

            smt.setString(1, Object.getProductName());
            smt.setDouble(2, Object.getProductPrice());
            smt.setInt(3, Object.getCategory().getCategoryID());
            smt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection.rs != null) {
                    connection.rs.close();
                }
                if (connection.st != null) {
                    connection.st.close();
                }
                if (connection.conn != null) {
                    connection.conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return Object;
    }

    @Override
    public Product update(Product Object) {
        return null;
    }

    @Override
    public List<Product> selectAll() {

        List<Product> listProduct = new ArrayList<>();
        Connections connection = new Connections();
        try {

            connection.st = connection.conn.createStatement();
            PreparedStatement smt = connection.conn.prepareStatement("SELECT PRODUCT_ID, PRODUCT_NAME FROM PRODUCT");
            connection.rs = smt.executeQuery();

            while (connection.rs.next()) {
                Product product = new Product();
                product.setProductID(connection.rs.getInt("PRODUCT_ID"));
                product.setProductName(connection.rs.getString("PRODUCT_NAME"));

                listProduct.add(product);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection.rs != null) {
                    connection.rs.close();
                }
                if (connection.st != null) {
                    connection.st.close();
                }
                if (connection.conn != null) {
                    connection.conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listProduct;
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public Product getByName(String name) {
        return null;
    }

    @Override
    public void delteById(int id) {

        Connections connection = new Connections();
        try {

            connection.st = connection.conn.createStatement();
            PreparedStatement smt = connection.conn.prepareStatement(DELETE_PRODUCT);
            smt.setString(1, String.valueOf(id));
            smt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection.rs != null) {
                    connection.rs.close();
                }
                if (connection.st != null) {
                    connection.st.close();
                }
                if (connection.conn != null) {
                    connection.conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
