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
public class AlcoholTestStudent {

    Alcohol test1, test2, test3, test4, test5, test6;

    @Before
    public void setUp() throws Exception
    {
        test1 = new Alcohol("Test1", Size.SMALL, false);
        test2 = new Alcohol("Test2", Size.MEDIUM, false);
        test3 = new Alcohol("Test3", Size.LARGE, false);

        test4 = new Alcohol("Test4", Size.SMALL, true);
        test5 = new Alcohol("Test5", Size.MEDIUM, true);
        test6 = new Alcohol("Test6", Size.LARGE, true);


    }

    @After
    public void tearDown() throws Exception
    {
        test1= test2= test3= test4= test5= test6= null;
    }

    @Test
    public void getBasePriceTest()
    {
        assertEquals(2.0, test1.getBASE_PRICE(), .001);
        assertEquals(2.0, test2.getBASE_PRICE(), .001);
        assertEquals(2.0, test3.getBASE_PRICE(), .001);
        assertEquals(2.0, test4.getBASE_PRICE(), .001);
        assertEquals(2.0, test5.getBASE_PRICE(), .001);
        assertEquals(2.0, test6.getBASE_PRICE(), .001);
    }

    @Test
    public void equalsTest()
    {
        Alcohol tempTest = new Alcohol("Test1", Size.SMALL, false);
        assertEquals(true, test1.equals(tempTest));

        Alcohol tempTest2 = new Alcohol("Test2", Size.SMALL, false);
        assertEquals(false, test1.equals(tempTest2));

    }

    @Test
    public void getIsWeekendTest()
    {
        assertEquals(false, test1.getIsWeekend());
        assertEquals(false, test2.getIsWeekend());
        assertEquals(false, test3.getIsWeekend());

        assertEquals(true, test4.getIsWeekend());
        assertEquals(true, test5.getIsWeekend());
        assertEquals(true, test6.getIsWeekend());

    }

    @Test
    public void toStringTest()
    {
        String test1String = "Test1, SMALL, Weekend?: false, Total Price: $2.0";
        assertEquals(test1String, test1.toString());

        String test2String = "Test2, MEDIUM, Weekend?: false, Total Price: $3.0";
        assertEquals(test2String, test2.toString());

        String test4String = "Test4, SMALL, Weekend?: true, Total Price: $2.6";
        assertEquals(test4String, test4.toString());

        String test6String = "Test6, LARGE, Weekend?: true, Total Price: $4.6";
        assertEquals(test6String, test6.toString());
    }
}
