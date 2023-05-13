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
public class Alcohol extends Beverage{

    private boolean isWeekend; // hold value of if weekend or not
    private final double ALCOHOL_Price = 0.6; // constant price for each alcohol addition

    public Alcohol(String bevName, Size bevSize, boolean isWknd)
    {
        super(bevName, Type.ALCOHOL, bevSize);
        isWeekend = isWknd;
    }

    public boolean getIsWeekend() {return isWeekend;} // return the value of isWeekend
    public double getALCOHOL_Price() {return ALCOHOL_Price;} // return value of alcohol price
    public void setIsWeekend(boolean isWknd){isWeekend = isWknd;} //set isWeekend value

    public boolean equals(Alcohol other){ // checks if other object is equal to current object
        return super.equals(other) && isWeekend == other.getIsWeekend();
    }

    @Override
    public double calcPrice() // calculates the price
    {
        double cost = super.getBASE_PRICE();

        if(super.getBevSize() == Size.MEDIUM) {cost += super.getSIZE_PRICE(); } // if medium add size price

        else if(super.getBevSize() == Size.LARGE) {cost += super.getSIZE_PRICE() * 2; } // if large add size price twice

        if(isWeekend){ cost += ALCOHOL_Price;} //is it's weekend add alcohol price to the cost

        return cost;

    }

    public String toString()
    {
        return super.toString() + ", Weekend?: "  + getIsWeekend() +
                ", Total Price: $" + calcPrice();
    }


}
