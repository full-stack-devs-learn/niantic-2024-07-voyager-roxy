package com.niantic.exercises;

import com.niantic.models.OrderLineItem;

import java.util.ArrayList;


/*
The exercises in this class are optional - this is the challenge exercise
 */
public class Order
{
    // this ArrayList is the container (shopping cart) for all items that are being ordered
    private ArrayList<OrderLineItem> shoppingCart = new ArrayList<>();

    public ArrayList<OrderLineItem> getShoppingCart()
    {
        return shoppingCart;
    }

    /*
    1. Add logic to allow a user to add an Item to a shopping cart
        - if the item already exists in the cart, update the quantity
        - search for a line item by name, and add the new quantity to the original quantity
     */
    public void addItem(OrderLineItem item)
    {
        for (var product : shoppingCart)
        {
            if (product.getProduct().equalsIgnoreCase(item.getProduct()))
            {
                product.setQuantity(product.getQuantity() + item.getQuantity());
                return;
            }
        }
                shoppingCart.add(item);
    }
//        method using streams shown in class
//        var existingItem = shoppingCart.stream().filter(lineItem -> lineItem.getProduct().equalsIgnoreCase(item.getProduct())).findFirst();
//
//        if(existingItem.isPresent())
//        {
//            var currentItem = existingItem.get();
//            int newQuantity = currentItem.getQuantity() + item.getQuantity();
//            currentItem.setQuantity(newQuantity);
//        }
//        else
//        {
//            shoppingCart.add(item);
//        }

    /*
    2. Add logic to allow a user to add an Item to a shopping cart
        - search for a line item by name, and remove it from the list
     */
    public void removeItem(OrderLineItem item)
    {
        getShoppingCart().remove(item);
    }

    /*
    3. Search for the highest priced item in the shopping cart and return the
        line item that contains that item.

        If the shopping cart is empty return null
     */
    public OrderLineItem findHighestPriceProduct()
    {
        var highestLineItem = getShoppingCart().getFirst();

        for (var item : shoppingCart)
        {
            if (item.getPrice() > highestLineItem.getPrice())
            {
                highestLineItem = item;
            }
        }

        return highestLineItem;
    }

    /*
    4. Search for the most expensive line item in the shopping cart
        and return it

        If the shopping cart is empty return null
     */
    public OrderLineItem findMostExpensiveLineItem()
    {

        var highestLineItem = getShoppingCart().getFirst();

        for (var item : shoppingCart)
        {
            if (item.getLineTotal() > highestLineItem.getLineTotal())
            {
                highestLineItem = item;
            }
        }

        return highestLineItem;
    }

    /*
    5. Calculate and return the order total
     */
    public double getOrderTotal()
    {
        double sum = 0;

        for (var item : shoppingCart)
        {
            sum += item.getLineTotal();
        }

        return sum;
    }

    /*
    6. Return the total number of items in the cart
     */
    public int getTotalItemCount()
    {
        return getShoppingCart().size();
    }

    /*
    7. Calculate the average price for all items in the shopping cart
     */
    public double getAveragePricePerItem()
    {
        double sum = 0;
        double quantity = 0;

        for(var item : shoppingCart)
        {
            sum += item.getLineTotal();
            quantity += item.getQuantity();
        }


        return sum / quantity;
    }
}
