/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Dao;

import Config.Connections;
import com.app.Generic.CrudOperations;
import com.app.Model.Category;
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
public class CategoryDao implements CrudOperations<Category> {

    public static final String SELECT_CATEGORY_BY_ID = "[dbo].[EXEC SELECT_CATEGORY_BY_ID]";

    @Override
    public boolean insert(Category Object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Category update(Category Object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Category> getAll() {
        Connections connection = new Connections();

        List<Category> listCategorys = new ArrayList<>();

        try {

            connection.st = connection.conn.createStatement();
            PreparedStatement smt = connection.conn.prepareStatement("SELECT [CATEGORY_ID],[CATEGORY_NAME],[DATE_CREATE]FROM [dbo].[CATEGORY]");
            connection.rs = smt.executeQuery();

            while (connection.rs.next()) {
                Category category = new Category();
                category.setCategoryID(connection.rs.getInt("CATEGORY_ID"));
                category.setCategoryName(connection.rs.getString("CATEGORY_NAME"));
                System.err.println("categorias" + category.toString());
                listCategorys.add(category);

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

        return listCategorys;
    }

    @Override
    public Category getById(int id) {
        Connections connection = new Connections();
        Category category = new Category();
        try {

            connection.st = connection.conn.createStatement();
            PreparedStatement smt = connection.conn.prepareStatement("SELECT [CATEGORY_ID],[CATEGORY_NAME],[DATE_CREATE]FROM [dbo].[CATEGORY] WHERE CATEGORY_ID = ?");
            smt.setInt(1, id);
            connection.rs = smt.executeQuery();
            while (connection.rs.next()) {

                category.setCategoryID(connection.rs.getInt("CATEGORY_ID"));
                category.setCategoryName(connection.rs.getString("CATEGORY_NAME"));
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

        return category;
    }

    @Override
    public List<Category> getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delteById(int id) {
        return false;
    }

}
