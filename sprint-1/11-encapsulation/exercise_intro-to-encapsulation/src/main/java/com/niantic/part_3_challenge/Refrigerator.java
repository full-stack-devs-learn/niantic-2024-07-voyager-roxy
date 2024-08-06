package com.niantic.part_3_challenge;

public class Refrigerator
{
    private final int MAX_TEMPERATURE = 35;
    private final int MIN_TEMPERATURE = 0;


    private int maxCapacity;
    private int currentTemperature;
    private int available;
    private boolean isDoorOpen = false;

    public Refrigerator(int currentTemperature, int maxCapacity)
    {
        this.currentTemperature = currentTemperature;
        this.maxCapacity = maxCapacity;
        this.available = maxCapacity;
    }

    public int getCurrentTemperature(){
        return currentTemperature;
    }

    public int getMaxCapacity()
    {
        return maxCapacity;
    }

    public int getAvailableCapacity()
    {
        return isDoorOpen ? available : 0;
    }

    public boolean isDoorOpen()
    {
        return isDoorOpen;
    }

    public void openDoor()
    {
        isDoorOpen = true;
    }

    public void closeDoor()
    {
        isDoorOpen = false;
    }

    public boolean addItem(int capacity)
    {
        if(isDoorOpen && capacity <= maxCapacity)
        {
            available -= capacity;
            return true;
        }
        else return false;
    }

    public boolean removeItem(int capacity)
    {
        if(isDoorOpen && (available - capacity) >= 0)
        {
            available += capacity;
            return true;
        }
        else return false;
    }
}
