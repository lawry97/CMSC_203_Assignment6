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
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
public class OrderTestStudent {

    Order test1, test2;

    @Before
    public void setUp() throws Exception
    {
        test1 = new Order(9, Day.SUNDAY, new Customer("John", 22));
        test2 = new Order(15, Day.THURSDAY, new Customer("Flans", 18));
    }

    @After
    public void tearDown()
    {
        test1= test2= null;
    }

    @Test
    public void getBeverageTest()
    {
        Alcohol alcoholTest = new Alcohol("Margarita", Size.SMALL, false);
        Smoothie smoothieTest = new Smoothie("Protein smoothie", Size.LARGE,4, true);
        Coffee coffeeTest = new Coffee("Decaf", Size.MEDIUM, false, false);


        test1.addNewBeverage("Margarita", Size.SMALL);
        test1.addNewBeverage("Protein smoothie", Size.LARGE,4, true);
        test1.addNewBeverage("Decaf", Size.MEDIUM, false, false);



        assertThat(test1.getBeverage(0)).usingRecursiveComparison().isNotEqualTo(alcoholTest);
        assertTrue(test1.getBeverage(1).equals(smoothieTest));
        assertTrue(test1.getBeverage(2).equals(coffeeTest));
    }
}
