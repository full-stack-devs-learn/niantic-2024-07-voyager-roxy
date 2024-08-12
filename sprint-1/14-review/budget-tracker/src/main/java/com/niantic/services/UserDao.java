package com.niantic.services;

import com.niantic.models.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class UserDao
{
    private JdbcTemplate jdbcTemplate;

    public UserDao()
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

    public User getUserByName(String userName)
    {
        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users
                WHERE user_name = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, userName);

        if (row.next())
        {
            int userId = row.getInt("user_id");
            userName = row.getString("user_name");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");
            String phone = row.getString("phone");
            String email = row.getString("email");

            return new User(userId, userName, firstName, lastName, phone, email);
        }

        return null;

    }

    public User getUserById(int userId)
    {
        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users
                WHERE user_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, userId);

        if (row.next())
        {
            userId = row.getInt("user_id");
            String userName = row.getString("user_name");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");
            String phone = row.getString("phone");
            String email = row.getString("email");

            return new User(userId, userName, firstName, lastName, phone, email);
        }

        return null;

    }

    public ArrayList<User> getAllUsers()
    {
        var users = new ArrayList<User>();

        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users;
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int userId = row.getInt("user_id");
            String userName = row.getString("user_name");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");
            String phone = row.getString("phone");
            String email = row.getString("email");

            var user = new User(userId, userName, firstName,
                    lastName, phone, email);

            users.add(user);

        }

        return users;
    }

    public void addUser(User user) {
        String sql = """
                INSERT INTO users
                    (user_name
                    , first_name
                    , last_name
                    , phone
                    , email)
                VALUES (?, ?, ?, ?, ?);
                """;

        jdbcTemplate.update(sql,
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail());
    }

    public void updateUser(User user)
    {
        String sql = """
                UPDATE users
                SET user_name = ?
                    , first_name = ?
                    , last_name = ?
                    , phone = ?
                    , email = ?
                WHERE user_id = ?;
                """;

        jdbcTemplate.update(sql,
                            user.getUserName(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getPhone(),
                            user.getEmail());
    }

    public void deleteUser(int userId)
    {
        String sql = "DELETE FROM users WHERE user_id = ?";

        jdbcTemplate.update(sql, userId);
    }
}
