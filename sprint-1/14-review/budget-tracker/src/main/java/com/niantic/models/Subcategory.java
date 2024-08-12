package com.niantic.models;

import java.util.ArrayList;

public class Subcategory {
    private int subcategoryId;
    private int categoryId;
    private String name;
    private String description;

    private ArrayList<Transaction> transactions;

    public Subcategory()
    {

    }

    public Subcategory(int subcategoryId, int categoryId, String name, String description)
    {
        this.subcategoryId = subcategoryId;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public int getSubcategoryId()
    {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId)
    {
        this.subcategoryId = subcategoryId;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
