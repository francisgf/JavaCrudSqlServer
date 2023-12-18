/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FRANCIS MCH
 */
public class Connections {

    public PropertiesConf prop = new PropertiesConf();

    public static Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;

    public Connections() {
        getSQLConnection();
    }

    public void getSQLConnection() {

        String connectionUrl
                = "jdbc:sqlserver://" + prop.getHostName() + ":" + prop.getPort() + ";"
                + "database=" + prop.getDataBase() + ";"
                + "user=" + prop.getUser() + ";"
                + "password=" + prop.getPassword() + ";"
                + "encrypting=" + prop.getEncrypting() + ";"
                + "loginTimeout=" + prop.getLoginTimeOut() + ";"
                + "trustServerCertificate=" + prop.getTrustServerCertificate()
                + ";";

        try {
            conn = DriverManager.getConnection(connectionUrl);

        } catch (SQLException e) {
            System.err.println("error conect" + e.getErrorCode());
            System.err.println("error sql messaje" + e.getMessage());
        }
    }
}
