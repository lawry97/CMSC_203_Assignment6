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

public class BevShop implements BevShopInterface{

    private int numOfAlcohol = 0; //stores number of alcohol
    private  Customer customer; // stores customer object
    private Order order; // stores order object
    private ArrayList<Order> orderList = new ArrayList<>(); //list of orders

    public BevShop()
    {

    }
    @Override
    public boolean isValidTime(int time) {
        return time >= 8 && time <= 23;
    }

    @Override
    public int getMaxNumOfFruits() {return MAX_FRUIT;}


    @Override
    public int getMinAgeForAlcohol() {return MIN_AGE_FOR_ALCOHOL;}

    @Override
    public boolean isMaxFruit(int numOfFruits) {return numOfFruits < MAX_FRUIT;}

    @Override
    public int getMaxOrderForAlcohol() {return MAX_ORDER_FOR_ALCOHOL;}

    @Override
    public boolean isEligibleForMore() {return numOfAlcohol < MAX_ORDER_FOR_ALCOHOL;}

    @Override
    public int getNumOfAlcoholDrink() {return numOfAlcohol;}

    @Override
    public boolean isValidAge(int age) {
        return age > MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) { //start order

        customer = new Customer(customerName, customerAge);
        order = new Order(time, day, customer);
        orderList.add(order);
        numOfAlcohol = 0;
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) { //process order for Coffee for each order
            order.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) { //process order for Alcohol order for each order
            order.addNewBeverage(bevName, size);
            numOfAlcohol++;
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) { //process order for smoothie order for each order
        order.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) { //find the order in the order list specified by the order number

        for(Order order : orderList)
        {
            if(order.getOrderNumber() == orderNo)
                    {return orderList.indexOf(order);}
        }

        return -1;
    }

    @Override
    public int totalNumOfMonthlyOrders() { //get the total order made
        int counter = 0;

        for( Order order : orderList)
        {
            if(order != null) counter++;
        }

        return counter;
    }

    @Override
    public double totalOrderPrice(int orderNo) { //returns the price of an order specified by order number

        int orderIndex = findOrder(orderNo);
        Order temp = orderList.get(orderIndex);
        return temp.calcOrderTotal();
    }

    @Override
    public double totalMonthlySale() { //calculates total cost of the orders made
        double total = 0;

        for(Order order : orderList)
        {
            total += order.calcOrderTotal();
        }

        return total;
    }

    @Override
    public Order getCurrentOrder() {
        return orderList.get(orderList.size() - 1);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orderList.get(index);
    }

    @Override
    public void sortOrders() { // sort the order from least to greatest by order number

        int minIndex = 0; // start the sort at the first element

        for(int current =0; current < orderList.size()-1; current++) // through each element
        {
            minIndex = current; //assign the current index to the minIndex

            for(int next = current+1; next < orderList.size(); next++) // through each next element
            {
                if(orderList.get(next).getOrderNumber() < orderList.get(minIndex).getOrderNumber()) // if the current index is less than next
                    minIndex = next; // assign the next index to minIndex
            }

            Order temp = orderList.get(minIndex); //create temporary order
            orderList.set(minIndex, orderList.get(current)); //assign the current index at minIndex in the orders list
            orderList.set(current, temp);// assign the temporary order at the current index of the list
        }
    }


}
