package com.bbw.webshopbackend.controller;

import com.bbw.webshopbackend.model.User;
import com.bbw.webshopbackend.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<User> getAllUsers() {
//        // Create a variable for the connection string.
//        String connectionUrl = "jdbc:sqlserver://localhost:3360;databaseName=webshop;user=root;password=root";
//
//        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
//            String SQL = "SELECT * FROM users";
//            ResultSet rs = stmt.executeQuery(SQL);
//
//            // Iterate through the data in the result set and display it.
//            User[] users;
//            while (rs.next()) {
//                User user = new User();
//                user.setId(rs.getInt("ID"));
//                user.setName(rs.getString("username"));
//                user.setEmail(rs.getString("email"));
//                user.setPassword(rs.getString("pwd"));
//            }
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}