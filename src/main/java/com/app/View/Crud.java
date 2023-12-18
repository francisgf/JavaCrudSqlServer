/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.View;

import com.app.Dao.CategoryDao;
import com.app.Dao.ProductDao;
import com.app.Model.Category;
import com.app.Model.Product;
import com.app.Util.LoguerGenerate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FRANCIS MCH
 */
public final class Crud extends javax.swing.JFrame {

    ProductDao productDao = new ProductDao();
    CategoryDao categoryDao = new CategoryDao();

    DefaultTableModel tableModel = new DefaultTableModel();
    List<Category> listCategorysItems = null;
    LoguerGenerate loguer = null;

    public Crud() {
        initComponents();
        fillComboBox();
        loguer = new LoguerGenerate();
        String titles[] = {"ID", "Product Name", "Product Price"};
        tableModel.setColumnIdentifiers(titles);
        tblProducts.setModel(tableModel);
        cbxCategory.setSelectedIndex(-1);
        getAllProductsRun();

        loguer.logInfo("appr run succsess");

    }

    public List<Product> getAllProducts() {
        List<Product> listProduct = null;
        try {
            listProduct = productDao.getAll();
            fillTableProduct(listProduct);

            System.out.println("lista:" + listProduct.toString());
        } catch (Exception e) {
            loguer.logInfo("error query" + e.getMessage());
        }
        return listProduct;
    }

    public List<Product> getAllProductsRun() {
        List<Product> listProduct = new ArrayList<>();
        try {

            listProduct = productDao.getAll();
            fillTableProduct(listProduct);
            System.out.println("lista:" + listProduct.toString());
            loguer.logInfo("getAllProductsRun():execute query success");

        } catch (Exception e) {
            loguer.logError("error query" + e.getMessage());

        }
        return listProduct;
    }

    public void insertProduct(Product product) {
        boolean isIsert;
        try {

            if (isIsert = productDao.insert(product)) {
                JOptionPane.showMessageDialog(null, "Se inserto");
                            loguer.logInfo("insertProduct():insert product success");

            } else {
                JOptionPane.showMessageDialog(null, "no se inserto");
                loguer.logWarning("the product did not inser");

            }
        } catch (Exception e) {
            loguer.logError("the product did not inser" + e.getMessage());

        }

    }

    void fillTableProduct(List<Product> listProduct) {
        tableModel.setRowCount(0);
        for (int i = 0; i < listProduct.size(); i++) {

            tableModel.addRow(new String[]{String.valueOf(listProduct.get(i).getProductID()), listProduct.get(i).getProductName(), String.valueOf(listProduct.get(i).getProductPrice())});
            this.tblProducts.setModel(tableModel);
        }
    }

    void fillComboBox() {
        cbxCategory.removeAllItems();
        listCategorysItems = categoryDao.getAll();
        for (int i = 0; i < listCategorysItems.size(); i++) {
            cbxCategory.addItem(listCategorysItems.get(i).getCategoryName());

        }
    }

    void searshProdcutByName(String nameProduc) {

        List<Product> lsProducts = productDao.getByName(nameProduc);
        if (lsProducts.isEmpty()) {
            tableModel.setRowCount(0);
        } else {
            fillTableProduct(lsProducts);
        }

    }

    Category getItemCategoryByIndex(List<Category> lsCategorys, int index) {
        Category category = null;
        if (cbxCategory.getSelectedIndex() > -1) {
            category = lsCategorys.get(index);
            System.err.println("cate: " + category.getCategoryName());
        }
        return category;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupsTableProdecut = new javax.swing.JPopupMenu();
        menuDelete = new javax.swing.JMenuItem();
        menuUpdate = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputProductPrice = new javax.swing.JTextField();
        inputProductName = new javax.swing.JTextField();
        btnSaveProduct = new javax.swing.JButton();
        cbxCategory = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        inputSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        popupsTableProdecut.setToolTipText("delete product");

        menuDelete.setText("Delete");
        menuDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDeleteMouseClicked(evt);
            }
        });
        menuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteActionPerformed(evt);
            }
        });
        popupsTableProdecut.add(menuDelete);

        menuUpdate.setText("Update");
        menuUpdate.setActionCommand("Update");
        popupsTableProdecut.add(menuUpdate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProducts.setComponentPopupMenu(popupsTableProdecut);
        tblProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducts);

        jLabel1.setText("Product");

        jLabel2.setText("Precio:");

        btnSaveProduct.setText("Guardar");
        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductActionPerformed(evt);
            }
        });

        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCategoryItemStateChanged(evt);
            }
        });
        cbxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoryActionPerformed(evt);
            }
        });

        jLabel3.setText("Category");

        inputSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSearchActionPerformed(evt);
            }
        });
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputSearchKeyTyped(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveProduct)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(inputProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveProduct)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed

        Product product = new Product();
        product.setProductName(this.inputProductName.getText());
        product.setProductPrice(Double.parseDouble(inputProductPrice.getText()));
        Category category = this.getItemCategoryByIndex(listCategorysItems, cbxCategory.getSelectedIndex());
        product.setCategory(category);
        insertProduct(product);
        getAllProducts();
    }//GEN-LAST:event_btnSaveProductActionPerformed

    private void inputSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        searshProdcutByName(inputSearch.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void inputSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputSearchKeyTyped
        if (inputSearch.getText().isEmpty()) {
            getAllProductsRun();
        } else {
            searshProdcutByName(inputSearch.getText());

        }

    }//GEN-LAST:event_inputSearchKeyTyped

    private void cbxCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCategoryItemStateChanged

    }//GEN-LAST:event_cbxCategoryItemStateChanged

    private void cbxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoryActionPerformed

    private void tblProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMousePressed
        if (SwingUtilities.isRightMouseButton(evt)) {
            int row = tblProducts.rowAtPoint(evt.getPoint());
            tblProducts.clearSelection(); // Limpiar la selección actual
            tblProducts.addRowSelectionInterval(row, row); // Seleccionar la fila en la que se hizo clic
            popupsTableProdecut.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblProductsMousePressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void menuDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDeleteMouseClicked

    }//GEN-LAST:event_menuDeleteMouseClicked

    private void menuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteActionPerformed

        int selectedRow = tblProducts.getSelectedRow();
        if (selectedRow > -1) {
            int productId = Integer.parseInt(String.valueOf(tableModel.getValueAt(selectedRow, 0)));
            String productName = String.valueOf(tableModel.getValueAt(selectedRow, 1));
            System.err.println("fila: " + productId + productName);

            if (productDao.delteById(productId)) {
                getAllProductsRun();
            }

        }
    }//GEN-LAST:event_menuDeleteActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JTextField inputProductName;
    private javax.swing.JTextField inputProductPrice;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenuItem menuUpdate;
    private javax.swing.JPopupMenu popupsTableProdecut;
    private javax.swing.JTable tblProducts;
    // End of variables declaration//GEN-END:variables
}
