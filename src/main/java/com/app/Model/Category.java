/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.Model;

import java.time.LocalDate;

/**
 *
 * @author FRANCIS MCH
 */
public class Category {

    private int categoryID;
    private String categoryName;
    private LocalDate dateCreate;
    private LocalDate dateUodate;

    public Category (){
        
    }
    
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDate getDateUodate() {
        return dateUodate;
    }

    public void setDateUodate(LocalDate dateUodate) {
        this.dateUodate = dateUodate;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryID=" + categoryID + ", categoryName=" + categoryName + ", dateCreate=" + dateCreate + ", dateUodate=" + dateUodate + '}';
    }
    
    
    
}
