package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;


@Controller
public class ProductsController
{
    ProductDao productDao = new ProductDao();
    CategoryDao categoryDao = new CategoryDao();

    @GetMapping("/products")
    public String getAllProducts(Model model, @RequestParam(required = false) int catId)
    {
        ArrayList<Product> products;

        products = productDao.getProductsByCategory(catId);


        var category = categoryDao.getCategoryById(catId);


        model.addAttribute("category", category);
        model.addAttribute("products", products);

        return "products/index";
    }

    @GetMapping("/products/{id}")
    public String getProductDetails(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);
        var category = categoryDao.getCategoryById(product.getCategoryId());
        var categoryName = category.getCategoryName();

        model.addAttribute("product", product);
        model.addAttribute("category", category);
        model.addAttribute("categoryName", categoryName);
        return "products/details";
    }

    @GetMapping("/products/add")
    public String addProduct(@RequestParam int catId, Model model)
    {
        Product product = new Product();
        product.setCategoryId(catId);

        model.addAttribute("product", product);
        model.addAttribute("catId", catId);
        model.addAttribute("action", "add");
        return "products/add_edit";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam int catId, @ModelAttribute("product") Product product)
    {
        product.setCategoryId(catId);
        productDao.addProduct(product);

        return "redirect:/products?catId=" + catId;
    }

    @GetMapping("/products/{id}/edit")
    public String editProduct(Model model, @PathVariable int id)
    {
        Product product = productDao.getProduct(id);
        ArrayList<Category> categories = categoryDao.getCategories();

        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        model.addAttribute("action", "edit");
        return "/products/add_edit";
    }

    @PostMapping("/products/{id}/edit")
    public String editProduct(@ModelAttribute("product") Product product, @PathVariable int id)
    {
        product.setProductId(id);
        productDao.updateProduct(product);
        return "redirect:/products?catId=" + product.getCategoryId();
    }

    @GetMapping("/products/{id}/delete")
    public String deleteProduct(Model model, @PathVariable int id)
    {
        Product product = productDao.getProduct(id);

        if(product == null)
        {
            model.addAttribute("message", String.format("There is no product with id %d", id));
            return "404";
        }
        model.addAttribute("product", product);
        model.addAttribute("action", "delete");
        return "/products/delete";
    }

    @PostMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable int id, @RequestParam int catId)
    {
        productDao.deleteProduct(id);

        return "redirect:/products?catId=" + catId;
    }
}
