package com.niantic.controllers;

import com.niantic.models.Product;
import com.niantic.services.ProductDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductApiController {
    private ProductDao productDao = new ProductDao();

    @GetMapping("/api/products/category/{catId}")
    public ArrayList<Product> getProducts(@PathVariable int catId)
    {
        ArrayList<Product> products;
        products = productDao.getProductsByCategory(catId);

        return products;
    }
}
