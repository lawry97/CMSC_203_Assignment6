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
public class SmoothieTestStudent {
    Smoothie test1, test2;

    @Before
    public void setUp()
    {
        test1 = new Smoothie("Test1", Size.LARGE, 4, false);
        test2 = new Smoothie("Test2", Size.SMALL, 3, true);
    }

    @After
    public void tearDown()
    {
        test1= test2= null;
    }

    @Test
    public void getBasePriceTest()
    {
        assertEquals(2.0, test1.getBASE_PRICE(), .001);
        assertEquals(2.0, test2.getBASE_PRICE(), .001);
    }

    @Test
    public void calPriceTest()
    {
        assertEquals(6.0, test1.calcPrice(), .001);
        assertEquals(5.0, test2.calcPrice(), .001);

    }

    @Test
    public void toStringTest()
    {

        String test1String = "Test1, LARGE, Have protein Powder: false, Number of Fruits: 4, Total Price: $6.0";
        assertEquals(test1String, test1.toString());

        String test2String = "Test2, SMALL, Have protein Powder: true, Number of Fruits: 3, Total Price: $5.0";
        assertEquals(test2String, test2.toString());

    }

    @Test
    public void getHaveProteinTest()
    {
        assertEquals(false, test1.getHaveProtein());
        assertEquals(true, test2.getHaveProtein());
    }

    @Test
    public void getNumOfFruits()
    {
        assertEquals(4, test1.getNum_Of_fruit());
        assertEquals(3, test2.getNum_Of_fruit());
    }

}
