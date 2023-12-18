/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Util;

import com.app.View.Crud;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author FRANCIS MCH
 */
public class LoguerGenerate {

    private LocalDate date;
    private static final Logger LOGGER = Logger.getLogger(Crud.class.getName());

    public LoguerGenerate() {
        date = LocalDate.now();

        String nameFileLoguer = String.format("%d-%02d-%02d.log", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        
        try {
            FileHandler fileHandler = new FileHandler(nameFileLoguer, true);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            LOGGER.addHandler(fileHandler);
        } catch (Exception e) {
            System.err.println("error write log");  e.printStackTrace();
        }

    }

    public void logError(String messaje) {
        LOGGER.log(Level.SEVERE, messaje);
    }

    public void logInfo(String messaje) {

        LOGGER.log(Level.INFO, messaje);
    }

    public void logWarning(String messaje) {

        LOGGER.log(Level.WARNING, messaje);
    }
}
