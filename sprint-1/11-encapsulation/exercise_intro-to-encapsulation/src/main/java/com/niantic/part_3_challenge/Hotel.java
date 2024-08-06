package com.niantic.part_3_challenge;

public class Hotel
{

    private int numberOfRooms;
    private int numberOfSuites;
    private int bookedRooms;
    private int bookedSuites;
    private int availableRooms;
    private int availableSuites;

    public Hotel(int numberOfRooms, int numberOfSuites)
    {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
    }

    public Hotel(int numberOfRooms, int numberOfSuites, int bookedRooms, int bookedSuites)
    {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedRooms = bookedRooms;
        this.bookedSuites = bookedSuites;
        this.availableRooms = numberOfRooms - bookedRooms;
        this.availableSuites = numberOfSuites - bookedSuites;
    }

    public int getNumberOfRooms()
    {
        return numberOfRooms;
    }

    public int getNumberOfSuites()
    {
        return numberOfSuites;
    }

    public int getBookedRooms()
    {
        return bookedRooms;
    }

    public int getBookedSuites()
    {
        return bookedSuites;
    }

    public int getAvailableRooms()
    {
        return availableRooms;
    }

    public int getAvailableSuites()
    {
        return availableSuites;
    }

    public boolean makeReservation(int numberOfRooms, boolean isSuite)
    {
        if(isSuite && (numberOfSuites - bookedSuites > 0) && numberOfRooms < availableSuites)
        {
            bookedSuites += numberOfRooms;
            availableSuites -= numberOfRooms;
            return true;
        }
        if(!isSuite && numberOfRooms < availableRooms)
        {
            bookedRooms += numberOfRooms;
            availableRooms -= numberOfRooms;
            return true;
        }
        return false;
    }
}
