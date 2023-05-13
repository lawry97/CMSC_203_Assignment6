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
public class CoffeeTestStudent {

    Coffee test1, test2, test3;

    @Before
    public void setUp()
    {
        test1 = new Coffee("Test1", Size.SMALL, false, true);
        test2 = new Coffee("Test2,", Size.MEDIUM, true, true);
        test3 = new Coffee("Test3", Size.LARGE, true, false);
    }

    @After
    public void tearDown()
    {
        test1 = test2= test3= null;
    }

    @Test
    public void getBasePriceTest()
    {
        assertEquals(2.0, test1.getBASE_PRICE(), .001);
    }

    @Test
    public void calcPriceTest()
    {
        assertEquals(2.5, test1.calcPrice(), .001);
        assertEquals(4.0, test2.calcPrice(), .001);
        assertEquals(4.5, test3.calcPrice(), .001);
    }

    @Test
    public void toStringTest()
    {
        String test1String = "Test1, SMALL, Have Extra Shot?: false, Have Extra Syrup?: true, Total Price: $2.5";
        assertEquals(test1String, test1.toString());

        String test3String = "Test3, LARGE, Have Extra Shot?: true, Have Extra Syrup?: false, Total Price: $4.5";
        assertEquals(test3String, test3.toString());

    }
}

