package com.bbw.webshopbackend.controller;

import com.bbw.webshopbackend.model.CartRepository;
import com.bbw.webshopbackend.model.Product;
import com.bbw.webshopbackend.service.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Controller // This means that this class is a Controller
public class CartController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CartRepository cartRepository;

    @GetMapping(path="/cart")
    public @ResponseBody
    Iterable<Product> getCart() {
        Database database = new Database();
        Statement stmt = database.getSqlConnection();
        List<Product> products = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM cart";
            ResultSet cartResult = null;
            cartResult = stmt.executeQuery(SQL);
            while (cartResult.next()) {
                String productId = cartResult.getString("product_id");
                SQL = "SELECT * FROM products WHERE id=" + productId;
                Database db = new Database();
                Statement statement = db.getSqlConnection();
                ResultSet productResult = null;
                productResult = statement.executeQuery(SQL);
                while (productResult.next()) {
                    Product product = new Product();
                    product.setId(productResult.getInt("id"));
                    product.setName(productResult.getString("product_name"));
                    product.setDescription(productResult.getString("product_description"));
                    product.setPrice(productResult.getDouble("product_price"));
                    products.add(product);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }
}