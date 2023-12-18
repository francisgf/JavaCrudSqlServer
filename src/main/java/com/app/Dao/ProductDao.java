package com.app.Dao;

import Config.Connections;
import com.app.Generic.CrudOperations;
import com.app.Model.Category;
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
    private static final String SELECT_PRODUCT = "SELECT * FROM PRODUCT WHERE REG_STATUS = 1 ";

    private CategoryDao categoryDao = new CategoryDao();
    private Category category = null;

    private static final Logger LOGGER = Logger.getLogger(ProductDao.class.getName());

    @Override
    public boolean insert(Product product) {
        boolean isInsert = false;
        Connections connection = new Connections();
        try {

            connection.st = connection.conn.createStatement();
            PreparedStatement smt = connection.conn.prepareStatement(INSERT_PRODUCT);

            smt.setString(1, product.getProductName());
            smt.setDouble(2, product.getProductPrice());
            smt.setInt(3, product.getCategory().getCategoryID());
            int insertValid = smt.executeUpdate();
            LOGGER.info("insert product succsess:" + product.toString());

            isInsert = insertValid == 1 || insertValid == 0;
            return isInsert;
        } catch (SQLException ex) {

            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, "duplicate value", ex.getCause());
            }
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, "insert product error", ex.getCause());
            isInsert = false;
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

        return isInsert;
    }

    @Override
    public Product update(Product Object) {
        return null;
    }

    @Override
    public List<Product> getAll() {

        List<Product> listProduct = new ArrayList<>();
        Connections connection = new Connections();
        try {
            Product product = null;
            connection.st = connection.conn.createStatement();
            PreparedStatement smt = connection.conn.prepareStatement(SELECT_PRODUCT);
            connection.rs = smt.executeQuery();

            while (connection.rs.next()) {
                category = new Category();

                product = new Product();
                product.setProductID(connection.rs.getInt("PRODUCT_ID"));
                product.setProductName(connection.rs.getString("PRODUCT_NAME"));
                product.setProductPrice(connection.rs.getDouble("PRODUCT_PRICE"));

                int catId = connection.rs.getInt("CATEGORY_ID");
                category = categoryDao.getById(catId);
                product.setCategory(category);

                listProduct.add(product);
            }
            product.toStringArray(listProduct);
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
    public List<Product> getByName(String name) {
        List<Product> listProduct = new ArrayList<>();
        Connections connection = new Connections();
        try {
            Product product = null;
            connection.st = connection.conn.createStatement();
            PreparedStatement smt = connection.conn.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE '%" + name + "%'");
            connection.rs = smt.executeQuery();

            while (connection.rs.next()) {
                category = new Category();

                product = new Product();
                product.setProductID(connection.rs.getInt("PRODUCT_ID"));
                product.setProductName(connection.rs.getString("PRODUCT_NAME"));
                product.setProductPrice(connection.rs.getDouble("PRODUCT_PRICE"));

                int catId = connection.rs.getInt("CATEGORY_ID");
                category = categoryDao.getById(catId);
                product.setCategory(category);

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
    public boolean delteById(int id) {

        boolean isDele = false;
        Connections connection = new Connections();
        try {

            connection.st = connection.conn.createStatement();
            PreparedStatement smt = connection.conn.prepareStatement(DELETE_PRODUCT);
            smt.setString(1, String.valueOf(id));

            int returnSQl = smt.executeUpdate();
            isDele = returnSQl == 1 || returnSQl == 0;
            Logger.getLogger(ProductDao.class.getName()).log(Level.INFO, "Se eleimino el producto");

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
        return isDele;

    }
}
