package com.niantic.services;

import com.niantic.models.Category;
import com.niantic.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MySqlProductDao implements ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlProductDao(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Product> getProducts()
    {
        List<Product> products = new ArrayList<>();

        String sql = """
        SELECT product_id
               , product_name
               , supplier_id
               , category_id
               , quantity_per_unit
               , unit_price
               , units_in_stock
               , units_on_order
               , reorder_level
               , discontinued
        FROM products
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int supplier_id = row.getInt("supplier_id");
            int category_id = row.getInt("category_id");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");
            boolean discontinued = row.getBoolean("discontinued");

            Product product = new Product(productId, productName, supplier_id, category_id, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);

            products.add(product);
        }

        return products;

    }

    public List<Product> getProductsByCategory(int categoryId)
    {
        List<Product> products = new ArrayList<>();

        String sql = """
        SELECT product_id
               , product_name
               , supplier_id
               , category_id
               , quantity_per_unit
               , unit_price
               , units_in_stock
               , units_on_order
               , reorder_level
               , discontinued
        FROM products
        WHERE category_id = ?
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        while(row.next())
        {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int supplier_id = row.getInt("supplier_id");
            int category_id = row.getInt("category_id");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");
            boolean discontinued = row.getBoolean("discontinued");

            Product product = new Product(productId, productName, supplier_id, category_id, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);

            products.add(product);
        }

        return products;

    }

    public Product getProductById(int productId)
    {
        Product product = null;

        String sql = """
        SELECT product_id
               , product_name
               , supplier_id
               , category_id
               , quantity_per_unit
               , unit_price
               , units_in_stock
               , units_on_order
               , reorder_level
               , discontinued
        FROM products
        WHERE product_id = ?
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, productId);

        if(row.next())
        {
            productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int supplier_id = row.getInt("supplier_id");
            int category_id = row.getInt("category_id");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");
            boolean discontinued = row.getBoolean("discontinued");

            product = new Product(productId, productName, supplier_id, category_id, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);

        }

        return product;

    }

    public Product addProduct(Product product) {
        String sql = """
                INSERT INTO products
                       (product_name
                       , supplier_id
                       , category_id
                       , quantity_per_unit
                       , unit_price
                       , units_in_stock
                       , units_on_order
                       , reorder_level
                       , discontinued)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getSupplierId());
            statement.setInt(3, product.getCategoryId());
            statement.setString(4, product.getQuantityPerUnit());
            statement.setDouble(5, product.getUnitPrice());
            statement.setInt(6, product.getUnitsInStock());
            statement.setInt(7, product.getUnitsOnOrder());
            statement.setInt(8, product.getReorderLevel());
            statement.setBoolean(9, product.isDiscontinued());
            return statement;
        }, keyHolder);

        int newId = keyHolder.getKey().intValue();

        return getProductById(newId);
    }

    public void updateProduct(int productId, Product product) {
        String sql = """
                UPDATE products
                SET product_name = ?
                       , supplier_id = ?
                       , category_id = ?
                       , quantity_per_unit = ?
                       , unit_price = ?
                       , units_in_stock = ?
                       , units_on_order = ?
                       , reorder_level = ?
                       , discontinued = ?
                WHERE product_id = ?
                """;

        jdbcTemplate.update(sql, product.getProductName()
                                , product.getSupplierId()
                                , product.getCategoryId()
                                , product.getQuantityPerUnit()
                                , product.getUnitPrice()
                                , product.getUnitsInStock()
                                , product.getUnitsOnOrder()
                                , product.getReorderLevel()
                                , product.isDiscontinued()
                                , productId);
    }

    public void deleteProduct(int productId) {
        String sql = """
                DELETE FROM products
                WHERE product_id = ?
                """;

        jdbcTemplate.update(sql, productId);
    }

}
