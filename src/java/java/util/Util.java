/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author nyanj
 */
public class Util {
    public static Connection pgConnect() {
        String url = "jdbc:postgresql://localhost:5432/meuble";
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "meuble", "meuble");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
