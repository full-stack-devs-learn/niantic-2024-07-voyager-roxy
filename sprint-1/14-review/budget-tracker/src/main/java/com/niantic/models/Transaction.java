package com.niantic.models;

import java.time.LocalDate;

public class Transaction {
    private int transactionId;
    private int userId;
    private int subcategoryId;
    private int vendorId;
    private LocalDate date;
    private double amount;
    private String notes;

    public Transaction(int transactionId, int userId, int subcategoryId,
                       int vendorId, LocalDate date, double amount, String notes)
    {
        this.transactionId = transactionId;
        this.userId = userId;
        this.subcategoryId = subcategoryId;
        this.vendorId = vendorId;
        this.date = date;
        this.amount = amount;
        this.notes = notes;
    }

    public Transaction()
    {

    }

    public int getTransactionId()
    {
        return transactionId;
    }

    public void setTransactionId(int transactionId)
    {
        this.transactionId = transactionId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getSubcategoryId()
    {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId)
    {
        this.subcategoryId = subcategoryId;
    }

    public int getVendorId()
    {
        return vendorId;
    }

    public void setVendorId(int vendorId)
    {
        this.vendorId = vendorId;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }


}
