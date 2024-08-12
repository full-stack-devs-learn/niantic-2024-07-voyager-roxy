package com.niantic.services;

import com.niantic.models.Transaction;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.cglib.core.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionDao {
    private JdbcTemplate jdbcTemplate;

    public TransactionDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/budget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource() {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Transaction> getTransactionByUser(int userId) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT user_id
                    , transaction_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE user_id = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);

        while (row.next()) {
            userId = row.getInt("user_id");
            int transactionId = row.getInt("transaction_id");
            int subcategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");
            String notes = row.getString("notes");

            Transaction transaction = new Transaction(userId, transactionId, subcategoryId,
                    vendorId, transactionDate, amount, notes);

            transactions.add(transaction);
        }

        return transactions;
    }


    public void addTransaction(Transaction transaction) {
        String sql = """
                INSERT INTO transactions
                (amount, transaction_date, notes, user_id, vendor_id, sub_category_id)
                VALUES
                (?, ?, ?, ?, ?, ?);
                """;
        jdbcTemplate.update(sql,
                transaction.getAmount(),
                transaction.getDate(),
                transaction.getNotes(),
                transaction.getUserId(),
                transaction.getVendorId(),
                transaction.getSubcategoryId());
    }


    public ArrayList<Transaction> getTransactionByMonth(int month) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT user_id
                    , transaction_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE MONTH(transaction_date) = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, month);

        while (row.next()) {
            int userId = row.getInt("user_id");
            int transactionId = row.getInt("transaction_id");
            int subcategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");
            String notes = row.getString("notes");

            Transaction transaction = new Transaction(userId, transactionId, subcategoryId,
                    vendorId, transactionDate, amount, notes);

            transactions.add(transaction);
        }

        return transactions;
    }


    public ArrayList<Transaction> getTransactionByYear(int year)
    {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT user_id
                    , transaction_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE YEAR(transaction_date) = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, year);

        while (row.next()) {
            int userId = row.getInt("user_id");
            int transactionId = row.getInt("transaction_id");
            int subcategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");
            String notes = row.getString("notes");

            Transaction transaction = new Transaction(userId, transactionId, subcategoryId,
                    vendorId, transactionDate, amount, notes);

            transactions.add(transaction);
        }

        return transactions;
    }

    public ArrayList<Transaction> getTransactionBySubcategory(int subcategoryId)
    {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT user_id
                    , transaction_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE sub_category_id = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, subcategoryId);

        while (row.next()) {
            int userId = row.getInt("user_id");
            int transactionId = row.getInt("transaction_id");
            subcategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");
            String notes = row.getString("notes");

            Transaction transaction = new Transaction(userId, transactionId, subcategoryId,
                    vendorId, transactionDate, amount, notes);

            transactions.add(transaction);
        }

        return transactions;
    }


    public ArrayList<Transaction> getTransactionByCategory(int categoryId)
    {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT user_id
                    , transaction_id
                    , sub_categories.sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                JOIN sub_categories ON transactions.sub_category_id = sub_categories.sub_category_id
                JOIN categories ON sub_categories.category_id = categories.category_id
                WHERE categories.category_id = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        while (row.next()) {
            int userId = row.getInt("user_id");
            int transactionId = row.getInt("transaction_id");
            int subcategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");
            String notes = row.getString("notes");

            Transaction transaction = new Transaction(userId, transactionId, subcategoryId,
                    vendorId, transactionDate, amount, notes);

            transactions.add(transaction);
        }

        return transactions;
    }

    public ArrayList<Transaction> getTransactionById(int transactionId)
    {
        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT user_id
                    , transaction_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE transaction_id = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, transactionId);

        while (row.next()) {
            int userId = row.getInt("user_id");
            transactionId = row.getInt("transaction_id");
            int subcategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");
            String notes = row.getString("notes");

            Transaction transaction = new Transaction(userId, transactionId, subcategoryId,
                    vendorId, transactionDate, amount, notes);

            transactions.add(transaction);
        }

        return transactions;
    }

    public void updateTransaction(Transaction transaction) {
        String sql = """
                UPDATE transactions
                SET amount = ?
                    , transaction_date = ?
                    , notes = ?
                    , user_id = ?
                    , vendor_id = ?
                    , sub_category_id = ?
                WHERE transaction_id = ?;
                """;
        jdbcTemplate.update(sql,
                transaction.getAmount(),
                transaction.getDate(),
                transaction.getNotes(),
                transaction.getUserId(),
                transaction.getVendorId(),
                transaction.getSubcategoryId());
    }

    public void deleteTransaction(int transaction) {
        String sql = "DELETE FROM transactions WHERE transaction_id = ?";
        jdbcTemplate.update(sql, transaction);
    }
}
