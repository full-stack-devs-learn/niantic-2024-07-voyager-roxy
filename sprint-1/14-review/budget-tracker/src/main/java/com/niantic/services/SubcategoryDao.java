package com.niantic.services;

import com.niantic.models.Subcategory;
import com.niantic.models.Transaction;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class SubcategoryDao {
    private JdbcTemplate jdbcTemplate;

    public SubcategoryDao()
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

    public ArrayList<Subcategory> getSubcategoriesByCategory()
    {
        ArrayList<Subcategory> subcategories = new ArrayList<>();

        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM sub_categories
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int subcategoryId = row.getInt("sub_category_id");
            int categoryId = row.getInt("category_id");
            String name = row.getString("sub_category_name");
            String description = row.getString("description");

            Subcategory subcategory = new Subcategory(subcategoryId, categoryId, name, description);

            subcategories.add(subcategory);
        }

        return subcategories;
    }

    public Subcategory getSubcategoryById(int subcategoryId)
    {
        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM sub_categories
                WHERE sub_category_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, subcategoryId);

        if(row.next())
        {
            subcategoryId = row.getInt("sub_category_id");
            int categoryId = row.getInt("category_id");
            String name = row.getString("sub_category_name");
            String description = row.getString("description");

            return new Subcategory(subcategoryId, categoryId, name, description);
        }

        return null;
    }

    public Subcategory getSubcategoryByName(String name)
    {
        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM sub_categories
                WHERE sub_category_name = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, name);

        if(row.next())
        {
            int subcategoryId = row.getInt("sub_category_id");
            int categoryId = row.getInt("category_id");
            name = row.getString("sub_category_name");
            String description = row.getString("description");

            return new Subcategory(subcategoryId, categoryId, name, description);
        }

        return null;
    }

    public void addSubCategory(Subcategory subcategory)
    {
        String sql = """
                INSERT INTO sub_categories
                    (category_id
                    , sub_category_name
                    , description)
                VALUES (?, ?, ?);
                """;

        jdbcTemplate.update(sql,
                    subcategory.getCategoryId(),
                    subcategory.getName(),
                    subcategory.getDescription());
    }

    public void updateSubCategory(Subcategory subcategory)
    {
        String sql = """
                UPDATE sub_categories
                SET category_id = ?
                    , sub_category_name = ?
                    , description = ?
                WHERE sub_category_id = ?;
                """;

        jdbcTemplate.update(sql,
                subcategory.getCategoryId(),
                subcategory.getName(),
                subcategory.getDescription());
    }

    public void deleteSubCategory(int subcategory)
    {
        String sql = "DELETE FROM sub_categories WHERE sub_category_id = ?";

        jdbcTemplate.update(sql, subcategory);
    }
}
