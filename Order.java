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

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface{

    private int orderNumber;
    private Day orderDay;
    private int orderTime;
    private Customer customer;
    private ArrayList<Beverage> orderList = new ArrayList<>();



    public Order(int time, Day day, Customer custmr)
    {
        orderTime = time;
        orderDay = day;
        customer = new Customer(custmr);
        orderNumber = random();
    }

    public int random()
    {
        int min = 10000;
        int max = 90000;

        Random randomNumber = new Random();
        return randomNumber.nextInt((max+1)-min) + min;
    }
    @Override
    public boolean isWeekend() {
        if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
        {
            return true;
        }

        return false;
    }

    @Override
    public Beverage getBeverage(int itemNo) {

        if(orderList.get(itemNo) == null) return null;
        else return orderList.get(itemNo);
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {

        orderList.add(new Alcohol(bevName, size, isWeekend()));

    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {

        orderList.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {

        orderList.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public double calcOrderTotal() {
        double cost = 0;

        for(Beverage beverage : orderList)
        {
            cost += beverage.calcPrice();
        }

        return cost;
    }

    @Override
    public int findNumOfBeveType(Type type) {

        int counter = 0;

        for(Beverage beverage: orderList)
        {
            if(beverage.getType() == type)
            {
                counter++;
            }
        }
        return counter;
    }

    public int getTotalItems()
    {
        int counter = 0;

        for(Beverage beverage : orderList)
        {
            if(beverage != null) counter++;
        }

        return counter;
    }

    public int compareTo(Order other)
    {
        if(getOrderNumber() == other.getOrderNumber()){ return 0;}

        else if( getOrderNumber() < other.getOrderNumber()){ return -1;}

        else return 1;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderTime(){return orderTime;}

    public void setOrderTime(int time){ orderTime =  time;}

    public Day getOrderDay() {return orderDay;}

    public void setOrderDay(Day day) { orderDay = day;}

    public int getOrderNumber(){return orderNumber;}

    public void setOrderNumber(int orderNumber) {orderNumber = orderNumber;}


    public String toString()
    {
        StringBuilder result = new StringBuilder();

        if(customer != null)
        {
            result.append("Order number: ").append(getOrderNumber()).append("\nName: ").append(customer.getCustomerName()).append("\n");

            for(Beverage beverage: orderList)
            {
                result.append(beverage.toString());
            }

            result.append("\nOrder Total: $").append(calcOrderTotal());
        }

        return result.toString();
    }
}
