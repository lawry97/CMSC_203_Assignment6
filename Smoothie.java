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

public class Smoothie extends Beverage{

    private int num_Of_fruit; //store number of fruits in smoothie
    private boolean haveProteinPowdr; //boolean value (have protein powder or not)
    private final double PROTEIN_COST = 1.50; //cost of adding protein powder
    private final double FRUIT_COST = .50; // cost of each fruit added

    public Smoothie(String bevName, Size size, int numOfFruit, boolean haveProtein)
    {
        super(bevName, Type.SMOOTHIE, size);

        num_Of_fruit = numOfFruit;
        haveProteinPowdr = haveProtein;
    }

    public boolean getHaveProtein(){return haveProteinPowdr;}
    public int getNum_Of_fruit(){return num_Of_fruit;}
    public void setNumOfFruits(int number){num_Of_fruit = number;}
    public void setHaveProteinPowdr(boolean have){haveProteinPowdr = have;}

    public boolean equals(Smoothie other) // checks if other object is equal (field by field)
    {
        return super.equals(other) &&
                getNum_Of_fruit() == other.getNum_Of_fruit()
                && getHaveProtein() == other.getHaveProtein();
    }

    @Override
    public double calcPrice()
    {
        double cost = getBASE_PRICE();

        if(super.getBevSize() == Size.MEDIUM){ cost += getSIZE_PRICE();} // if size is medium, add size price

        else if(super.getBevSize() == Size.LARGE){cost += getSIZE_PRICE()*2;} // if size is large, add size price twice

        if(getHaveProtein()) {cost += PROTEIN_COST;} // add cost of adding protein

        if(getNum_Of_fruit() >= 1){cost += getNum_Of_fruit() * FRUIT_COST;} //add fruit price for each fruit added

        return cost;

    }


    public String toString()
    {
        return super.toString() + ", Have protein Powder: " + haveProteinPowdr +
                ", Number of Fruits: " +  getNum_Of_fruit() +
                ", Total Price: $" + calcPrice();
    }

}
