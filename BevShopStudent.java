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
public class BevShopStudent {

    BevShop shop;

    @Before
    public void setUp() throws Exception
    {
        shop = new BevShop();
    }

    @After
    public void tearDown() throws Exception
    {
        shop = null;
    }

    @Test
    public void validTimeTest()
    {
        assertTrue(shop.isValidTime(8));
        assertTrue(shop.isValidTime(23));
        assertFalse(shop.isValidTime(1));
        assertFalse(shop.isValidTime(24));
    }

    @Test
    public void startNewOrder()
    {
        //set up
        shop.startNewOrder(12, Day.MONDAY, "Law", 23);
        //test
        assertEquals(12, shop.getCurrentOrder().getOrderTime());
        assertEquals(Day.MONDAY, shop.getCurrentOrder().getOrderDay());
        assertEquals("Law", shop.getCurrentOrder().getCustomer().getCustomerName());
        assertEquals(23, shop.getCurrentOrder().getCustomer().getCustomerAge());
    }

    @Test
    public void processAlcoholOrderTest()
    {
        //set up
        shop.startNewOrder(12, Day.MONDAY, "Law", 23);
        shop.processAlcoholOrder("Drink 1", Size.SMALL);
        //test
        assertEquals(1, shop.getCurrentOrder().getTotalItems());
        assertEquals("Drink 1", shop.getCurrentOrder().getBeverage(0).getBevName());
        assertEquals(Size.SMALL, shop.getCurrentOrder().getBeverage(0).getBevSize());
        assertEquals(Type.ALCOHOL, shop.getCurrentOrder().getBeverage(0).getType());
    }

    @Test
    public void processSmoothieOrderTest()
    {
        //set up
        shop.startNewOrder(12, Day.MONDAY, "Law", 23);
        shop.processSmoothieOrder("Drink 1", Size.MEDIUM, 4, true);
        //test
        assertEquals(1, shop.getCurrentOrder().getTotalItems());
        assertEquals("Drink 1", shop.getCurrentOrder().getBeverage(0).getBevName());
        assertEquals(Size.MEDIUM, shop.getCurrentOrder().getBeverage(0).getBevSize());
        assertEquals(Type.SMOOTHIE, shop.getCurrentOrder().getBeverage(0).getType());

        Smoothie test = (Smoothie) shop.getCurrentOrder().getBeverage(0);

        assertEquals(4, test.getNum_Of_fruit());
        assertTrue(test.getHaveProtein());

    }

    @Test
    public void processCoffeeOrderTest()
    {
        //set up
        shop.startNewOrder(12, Day.MONDAY, "Law", 23);
        shop.processCoffeeOrder("Drink 1", Size.SMALL, true, true);

        //test
        assertEquals(1, shop.getCurrentOrder().getTotalItems());
        assertEquals("Drink 1", shop.getCurrentOrder().getBeverage(0).getBevName());
        assertEquals(Size.SMALL, shop.getCurrentOrder().getBeverage(0).getBevSize());
        assertEquals(Type.COFFEE, shop.getCurrentOrder().getBeverage(0).getType());

        Coffee test = (Coffee) shop.getCurrentOrder().getBeverage(0);
        assertTrue(test.getExtraSyrup());
        assertTrue(test.getExtraShot());
    }


}
