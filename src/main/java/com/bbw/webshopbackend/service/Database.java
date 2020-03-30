package com.bbw.webshopbackend.service;

import com.bbw.webshopbackend.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public Statement getSqlConnection() {
        String connectionUrl = "jdbc:mysql://localhost:3306/webshop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        List<Product> products = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(connectionUrl, "root", "root");
            return con.createStatement();

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
