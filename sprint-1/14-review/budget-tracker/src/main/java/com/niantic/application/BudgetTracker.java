package com.niantic.application;

import com.niantic.services.TransactionDao;
import com.niantic.services.UserDao;
import com.niantic.services.SubcategoryDao;
import com.niantic.services.CategoryDao;
import com.niantic.services.VendorDao;
import com.niantic.models.Transaction;
import com.niantic.models.User;
import com.niantic.models.Category;
import com.niantic.models.Subcategory;
import com.niantic.models.Vendor;

import java.util.Date;

import java.time.LocalDate;
import java.util.Scanner;

import static java.util.FormatProcessor.FMT;

public class BudgetTracker
{
    Scanner userInput = new Scanner(System.in);

    TransactionDao transactionDao = new TransactionDao();
    UserDao userDao = new UserDao();
    SubcategoryDao subcategoryDao = new SubcategoryDao();
    CategoryDao categoryDao = new CategoryDao();
    VendorDao vendorDao = new VendorDao();

    public void run()
    {

        while(true)
        {
            int choice = homeScreenSelection();
            switch(choice)
            {
                case 1:
                    addTransaction();
                    break;
                case 2:
                    displayReports();
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    addCategory();
                    break;
                case 5:
                    addSubCategory();
                    break;
                case 6:
                    addVendor();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Thank you for using Northwind!");
                    System.out.println("Goodbye");
                    System.out.println();
                    System.exit(0);
                default:
                    System.out.println("invalid selection");
                    break;
            }
        }

    }

    private int homeScreenSelection()
    {
        System.out.println();
        System.out.println("Budget Tracker");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) Add Transaction");
        System.out.println("  2) Reports");
        System.out.println("  3) Add User");
        System.out.println("  4) Add Category");
        System.out.println("  5) Add Sub Category");
        System.out.println("  6) Add Vendor");
        System.out.println("  0) Quit");
        System.out.println();

        System.out.print("Enter an option: ");
        return Integer.parseInt(userInput.nextLine());
    }

    private void displayReports()
    {
        while (true)
        {
            int choice = reportsSelection();
            switch (choice)
            {
                case 0:
                    return;
                case 1:
                    transactionByUser();
                    break;
                case 2:
                    transactionByMonth();
                    break;
                case 3:
                    transactionByYear();
                    break;
                case 4:
                    transactionBySubcategory();
                    break;
                case 5:
                    transactionByCategory();
                    break;
            }
        }
    }

    private void addTransaction()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Add Transaction");
        System.out.println("-".repeat(100));
        System.out.println("Enter Transaction Information");
        System.out.println();

        double amount = getUserDouble("Amount: ");
        LocalDate date = getUserDate("Date: " );
        String notes = getUserString("Notes: ");
        String userName = getUserString("Username: ");
        String vendorName = getUserString("Vendor: ");
        String subcategoryName = getUserString("Sub Category: ");

        var vendor = vendorDao.getVendorByName(vendorName);
        var user = userDao.getUserByName(userName);
        var subCategory = subcategoryDao.getSubcategoryByName(subcategoryName);

        int userId = user.getUserId();
        int vendorId = vendor.getVendorId();
        int subcategoryId = subCategory.getSubcategoryId();


        var transaction = new Transaction()
        {{
            setAmount(amount);
            setDate(date);
            setNotes(notes);
            setUserId(userId);
            setSubcategoryId(subcategoryId);
            setVendorId(vendorId);
        }};

        transactionDao.addTransaction(transaction);

        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transaction has been added.");


    }

    private void addUser()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Add User");
        System.out.println("-".repeat(100));
        System.out.println("Enter User Information");
        System.out.println();

        String userName = getUserString("User Name: ");
        String firstName = getUserString("First Name: ");
        String lastName = getUserString("Last Name: ");
        String phone = getUserString("Phone Number: ");
        String email = getUserString("Email: ");

        var user = new User()
        {{
            setUserName(userName);
            setFirstName(firstName);
            setLastName(lastName);
            setPhone(phone);
            setEmail(email);
        }};

        userDao.addUser(user);

        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("User has been added.");

    }

    private void addCategory()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Add Category");
        System.out.println("-".repeat(100));
        System.out.println("Enter Category Information");
        System.out.println();

        String categoryName = getUserString("Category Name: ");
        String description = getUserString("Description: ");

        var category = new Category()
        {{
            setName(categoryName);
            setDescription(description);
        }};

        categoryDao.addCategory(category);

        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Category has been added.");

    }

    private void addSubCategory()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Add Sub Category");
        System.out.println("-".repeat(100));
        System.out.println("Enter Sub Category Information");
        System.out.println();

        int categoryId = getUserInt("Category Id: ");
        String subCategoryName = getUserString("Sub Category Name: ");
        String description = getUserString("Description: ");

        var subcategory = new Subcategory()
        {{
            setCategoryId(categoryId);
            setName(subCategoryName);
            setDescription(description);
        }};

        subcategoryDao.addSubCategory(subcategory);

        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Sub Category has been added.");

    }

    private void addVendor()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Add Vendor");
        System.out.println("-".repeat(100));
        System.out.println("Enter Vendor Information");
        System.out.println();

        String vendorName = getUserString("Vendor Name: ");
        String website = getUserString("Website: ");

        var vendor = new Vendor()
        {{
            setName(vendorName);
            setWebsite(website);
        }};

        vendorDao.addVendor(vendor);

        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Vendor has been added.");

    }

    private int reportsSelection()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Reports");
        System.out.println("-".repeat(100));
        System.out.println("  1) Transaction By User");
        System.out.println("  2) Transaction By Month");
        System.out.println("  3) Transaction By Year");
        System.out.println("  4) Transaction By Sub Category");
        System.out.println("  5) Transaction By Category");
        System.out.println("  0) Back");
        System.out.println();

        return getUserInt("Enter an option: ");
    }

    private void transactionByUser()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transactions By User");
        System.out.println("-".repeat(100));

        String findUser = getUserString("Enter User Name: ");
        System.out.println();

        var user = userDao.getUserByName(findUser);

        int userId = user.getUserId();

        var transactions = transactionDao.getTransactionByUser(userId);
        
        for (var transaction : transactions) {
            displayTransaction(transaction);
        }

        waitForUser();

    }

    private void transactionByMonth()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transactions By Month");
        System.out.println("-".repeat(100));

        int findMonth = getUserInt("Enter Month: ");
        System.out.println();

        var transactions = transactionDao.getTransactionByMonth(findMonth);

        for (var transaction : transactions) {
            displayTransaction(transaction);
        }

        waitForUser();
    }

    private void transactionByYear()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transactions By Year");
        System.out.println("-".repeat(100));

        int findYear = getUserInt("Enter Year: ");
        System.out.println();

        var transactions = transactionDao.getTransactionByYear(findYear);

        for (var transaction : transactions) {
            displayTransaction(transaction);
        }

        waitForUser();
    }

    private void transactionBySubcategory()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transactions By Sub Category");
        System.out.println("-".repeat(100));

        String findSubcategory = getUserString("Enter Sub Category: ");
        System.out.println();

        var subcategory = subcategoryDao.getSubcategoryByName(findSubcategory);

        int subcategoryId = subcategory.getSubcategoryId();

        var transactions = transactionDao.getTransactionBySubcategory(subcategoryId);

        for (var transaction : transactions) {
            displayTransaction(transaction);
        }

        waitForUser();
    }

    private void transactionByCategory()
    {
        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transactions By Category");
        System.out.println("-".repeat(100));

        String findCategory = getUserString("Enter Category: ");
        System.out.println();

        var category = categoryDao.getCategoryByName(findCategory);

        int categoryId = category.getCategoryId();

        var transactions = transactionDao.getTransactionByCategory(categoryId);

        for (var transaction : transactions) {
            displayTransaction(transaction);
        }

        waitForUser();
    }

    private void displayTransaction(Transaction transaction)
    {
        System.out.println("-".repeat(100));
        String format = "%-10s %-10s %-30s%n";
        System.out.printf(format, "Date", "Amount", "Notes");
        System.out.printf(format, "-".repeat(10), "-".repeat(10), "-".repeat(30));
        System.out.printf(format, transaction.getDate(), transaction.getAmount(), transaction.getNotes());
    }

    private void waitForUser()
    {
        System.out.println();
        System.out.println("Press ENTER to continue...");
        userInput.nextLine();
    }

    private String getUserString(String message)
    {
        System.out.print(message);
        return userInput.nextLine();
    }

    private int getUserInt(String message)
    {
        return Integer.parseInt(getUserString(message));
    }

    private double getUserDouble(String message)
    {
        return Double.parseDouble(getUserString(message));
    }

    private LocalDate getUserDate(String message)
    {
        return LocalDate.parse(getUserString(message));
    }
}
