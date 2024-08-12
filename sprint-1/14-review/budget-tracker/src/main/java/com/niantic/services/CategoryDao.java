package com.niantic.services;

import com.niantic.models.Category;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class CategoryDao {
    private JdbcTemplate jdbcTemplate;

    public CategoryDao()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/budget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Category> getAllCategories()
    {
        ArrayList<Category> categories = new ArrayList<>();

        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            Category category = new Category(categoryId, categoryName, description);

            categories.add(category);
        }

        return categories;
    }

    public Category getCategoryByName(String name)
    {
        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories
                WHERE category_name = ?
                """;

        var row = jdbcTemplate.queryForRowSet(sql, name);

        if (row.next())
        {
            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            return new Category(categoryId, categoryName, description);
        }

        return null;
    }

    public Category getCategoryById(int categoryId)
    {
        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories
                WHERE category_id = ?
                """;

        var row = jdbcTemplate.queryForRowSet(sql, categoryId);

        if (row.next())
        {
            categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            return new Category(categoryId, categoryName, description);
        }

        return null;
    }

    public void addCategory(Category category)
    {
        String sql = """
                INSERT INTO categories
                    (category_name
                    , description)
                VALUES (?, ?);
                """;

        jdbcTemplate.update(sql,
                category.getName(),
                category.getDescription());

    }

    public void updateCategory(Category category)
    {
        String sql = """
                UPDATE categories
                SET category_name = ?
                    , description = ?
                WHERE category_id = ?;
                """;

        jdbcTemplate.update(sql,
                category.getName(),
                category.getDescription());

    }

    public void deleteCategory(int categoryId)
    {
        String sql = "DELETE FROM categories WHERE category_id = ?";

        jdbcTemplate.update(sql, categoryId);

    }

}
