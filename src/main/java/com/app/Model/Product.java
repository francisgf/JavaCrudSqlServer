package com.app.Model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author FRANCIS MCH
 */
public class Product {

    private int productID;
    private String productName;
    private double productPrice;
    private Category category;
    private LocalDate dateCreate;
    private char status;

    public Product() {

    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void toStringArray(List<Product> listProduc) {

        for (int i = 0; i < listProduc.size(); i++) {
            int count = 0;
            count++;
            System.out.println(count + "Product{" + "productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice + ", category=" + category.getCategoryName() + ", dateCreate=" + dateCreate + ", status=" + status + '}');

        }

    }

}
