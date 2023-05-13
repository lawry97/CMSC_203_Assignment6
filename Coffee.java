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

public class Coffee extends Beverage{

    private boolean extraShot; //boolean value (whether to have extra shot or not)
    private boolean extraSyrup; // boolean value (whether to have extra syrup or not)
    private final double EXRASHOT_PRICE = .5; //constant price for having extra shot
    private final double EXTRASYRUP_PRICE = .5;//constant price for having extra shot

    public Coffee(String bevName, Size bevSize, boolean haveShot, boolean haveSyrup)
    {
        super(bevName, Type.COFFEE, bevSize);
        extraShot = haveShot;
        extraSyrup = haveSyrup;
    }

    public boolean getExtraShot() {return extraShot;}
    public boolean getExtraSyrup() {return extraSyrup;}
    public double getEXRASHOT_PRICE(){return EXRASHOT_PRICE;}
    public double getEXTRASYRUP_PRICE(){return EXTRASYRUP_PRICE;}

    public void setExtraShot(boolean extraShot) {this.extraShot = extraShot;}

    public void setExtraSyrup(boolean extraSyrup) {this.extraSyrup = extraSyrup;}

    public boolean equals(Coffee other) //checks if other object is equal (field by field)
    {
        if(super.equals(other) && extraShot == other.extraShot && extraSyrup == other.getExtraSyrup())
        {
            return true;
        }

        return false;
    }

    @Override
    public double calcPrice() // calculates the price
    {
       double cost = super.getBASE_PRICE();

        if(super.getBevSize() == Size.MEDIUM) {cost += super.getSIZE_PRICE(); } // if it is medium add size price

        else if(super.getBevSize() == Size.LARGE) {cost += super.getSIZE_PRICE() * 2; } // if it is large add size price twice

        if(getExtraShot()){cost += getEXRASHOT_PRICE();} // if have extra shot, add extra shot price

        if(getExtraSyrup()){cost += getEXTRASYRUP_PRICE();} // if have extra syrup, add extra syrup price

        return cost;
    }

    public String toString()
    {
       return super.toString() +
               ", Have Extra Shot?: " + getExtraShot()
               + ", Have Extra Syrup?: " + getExtraSyrup() +
               ", Total Price: $" + calcPrice();
    }
}
