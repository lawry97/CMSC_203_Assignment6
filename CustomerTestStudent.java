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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CustomerTestStudent {

    Customer customer;

    @Before
    public void setUp() throws Exception
    {
        customer = new Customer("Law", 23);
    }

    @After
    public void tearDown() throws Exception
    {
        customer = null;
    }

    @Test
    public void getCustomerNameTest()
    {
        assertEquals("Law", customer.getCustomerName());
    }

    @Test
    public void getCustomerAgeTest()
    {
        assertEquals(23, customer.getCustomerAge());
    }

    @Test
    public void toStringTest()
    {
        assertEquals("Name: Law" + "\n" + "Age: 23", customer.toString());
    }
}
