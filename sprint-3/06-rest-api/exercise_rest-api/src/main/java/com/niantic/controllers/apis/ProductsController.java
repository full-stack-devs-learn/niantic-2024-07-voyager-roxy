package com.niantic.controllers.apis;

import com.niantic.models.HttpError;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.MySqlCategoryDao;
import com.niantic.services.MySqlProductDao;
import com.niantic.services.ProductDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {
    private ProductDao productDao = new MySqlProductDao();
    private CategoryDao categoryDao = new MySqlCategoryDao();

    @GetMapping("/api/products")
    public ResponseEntity<?> getProductsByCategory(@RequestParam int catId)
    {
        try {
            var products = productDao.getProductsByCategory(catId);
            var category = categoryDao.getCategory(catId);
            if(category == null)
            {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(products);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/api/products/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable int productId)
    {
        try{
           var product = productDao.getProductById(productId);
           if (product == null)
           {
               return ResponseEntity.notFound().build();
           }
           return ResponseEntity.ok(product);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/api/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product)
    {
        return productDao.addProduct(product);
    }

    @PutMapping("/api/products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable int productId, @RequestBody Product product)
    {
        productDao.updateProduct(productId, product);
    }

    @DeleteMapping("/api/products/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int productId)
    {
        productDao.deleteProduct(productId);
    }
}
