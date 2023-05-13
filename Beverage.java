/*
Class: CMSC203 CRN 30376
 Program: Assignment 6 Implementation
 Instructor: Grinberg, Grigoriy
 Summary of Description:
Bradley shop is a family owned store that sells beverages.  The store offers 3 types of beverages: Coffee, Alcohol, and Smoothie. The store is open from 8 in the morning to 11 pm in the afternoon.  The owner of the shop likes to automate the order transactions and reports and purchase a software for testing order activities for one month. You are asked to implement this software based on the following requirements.
 Due Date: <05/13/2023>
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: Full Name : Lawrence Aryeh
 */

public abstract class Beverage {

    private String bevName;
    private Type bevType;
    private Size bevSize;

    private final double BASE_PRICE = 2.0; //constant base price for beverage
    private final double SIZE_PRICE = 1.0; // constant size price (increases with each size after size SMALL)




    public Beverage(String name, Type type, Size size)
    {
        bevName = name;
        bevType = type;
        bevSize = size;
    }

    public String getBevName() {return bevName;}
    public Type getType() {return bevType;}
    public Size getBevSize() {return bevSize;}
    public double getBASE_PRICE(){return BASE_PRICE;}
    public double getSIZE_PRICE(){return SIZE_PRICE;}
    public void setBevName(String name){ bevName = name;}
    public void setType(Type type){bevType =type;}

    public void setBevSize(Size bevSize){bevSize = bevSize;}

    public boolean equals(Beverage other){ //checks if the other object is equal field by field

        if(bevName.equals(other.getBevName())
        && bevType.equals(other.getType())
        && bevSize.equals(other.bevSize))  {return true;}

        return false;
    }

    public abstract double calcPrice();


    public String toString()
    {
        return bevName + ", " + bevSize;
    }
}
