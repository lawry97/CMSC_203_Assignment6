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
public class Customer {

    private String customerName; //stores customer's name
    private int customerAge; //stores customer's age

    public Customer(String custmrName, int custmrAge)
    {
        customerName = custmrName;
        customerAge = custmrAge;
    }

    public Customer( Customer other) //checks if other object is equal (field by field)
    {
        this.customerName = other.getCustomerName();
        this.customerAge = other.getCustomerAge();
    }


    public String getCustomerName(){return customerName;}
    public int getCustomerAge(){return customerAge;}

    public void setCustomerAge(int age){customerAge = age;}
    public void setCustomerName(String name){customerName = name;}


    public String toString() {
        return "Name: " + customerName +
                "\nAge: " + customerAge;
    }
}
