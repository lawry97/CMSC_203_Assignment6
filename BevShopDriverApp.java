/*Class: CMSC203 CRN 30376
         Program: Assignment 6 Implementation
        Instructor: Grinberg, Grigoriy
         Summary of Description:
        Bradley shop is a family owned store that sells beverages.  The store offers 3 types of beverages: Coffee, Alcohol, and Smoothie. The store is open from 8 in the morning to 11 pm in the afternoon.  The owner of the shop likes to automate the order transactions and reports and purchase a software for testing order activities for one month. You are asked to implement this software based on the following requirements.
         Due Date: <05/13/2023>
         Integrity Pledge: I pledge that I have completed the programming assignment independently.
         I have not copied the code from a student or any source.
        Student: Full Name : Lawrence Aryeh
*/

import java.util.Scanner;
public class BevShopDriverApp {

    int age, orderNumber;

    Customer customer;
    int minTime = 8 , maxTime = 24;


    public static void main(String []args)
    {
        int age, orderNumber;
        String name;
        Customer customer;
        BevShop shop = new BevShop();
        Scanner input = new Scanner(System.in);

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");
        System.out.println("Please start a new order:");
        System.out.println("Your Total Order for now is 0.0");

        System.out.print("Would you please enter your name: ");
        name = input.nextLine();

        System.out.print("Would you please enter your age: ");
        age = input.nextInt();

        shop.startNewOrder(11, Day.MONDAY, name, age);

        if(shop.isValidAge(age))
        {
            order_With_Alcohol(shop);
        }

        input.nextLine();
        System.out.println("Would you please start a new order");
        System.out.print("Would you enter your name: ");
        name = input.nextLine();
        System.out.print("Would you enter your age: ");
        age = input.nextInt();

        shop.startNewOrder(16, Day.SUNDAY, name, age);
        System.out.println("The total price on the order: $" + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("Would you please add a Smoothie to order");
        shop.processSmoothieOrder("Drink 1", Size.LARGE, 2, true);
        System.out.println("The total price on the order: $" + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("Would you please add a Coffee to order");
        shop.processCoffeeOrder("Drink 2", Size.MEDIUM, false, false);
        System.out.println("The total price on the order: $" + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("Would you please add a drink");
        if(shop.isValidAge(age)) System.out.println("You are eligible to add drink");
        else System.out.println("Your age is not appropriate for alcohol drink!!");

        System.out.println("The current order order of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The total price on the order is $" + shop.getCurrentOrder().calcOrderTotal() );
        shop.processSmoothieOrder("Drink 3", Size.LARGE, 5, false);
        System.out.println("The total number of fruits is 5" );
        if(shop.isMaxFruit(5)) System.out.println("You have reached a maximum number of fruits");
        System.out.println();

        System.out.println("Total price on the second order: $" + shop.getCurrentOrder().calcOrderTotal());
        System.out.println("Total amount for all orders: $" + shop.totalMonthlySale());




    }

     static public void order_With_Alcohol(BevShop shop)
    {
        System.out.println("Your age is above 21 and you are eligible to order alcohol");
        System.out.println("Would you please add an alcohol drink");
        shop.processAlcoholOrder("Drink 1", Size.SMALL);
        System.out.println("The current order of drinks is " + shop.getNumOfAlcoholDrink());
        System.out.println("The total price on the Order is $" + shop.getCurrentOrder().calcOrderTotal());
        if(shop.isEligibleForMore()) System.out.println("Your current alcohol drink is less than 4");
        else System.out.println("You have a maximum alcohol drinks for this order");

        System.out.println("Would you please add a second alcohol drink");
        shop.processAlcoholOrder("Drink 2", Size.LARGE);
        System.out.println("The current order of drinks is " + shop.getNumOfAlcoholDrink());
        System.out.println("The total price on the Order is $" + shop.getCurrentOrder().calcOrderTotal());
        if(shop.isEligibleForMore()) System.out.println("Your current alcohol drink is less than 4");
        else System.out.println("You have a maximum alcohol drinks for this order");

        System.out.println("Would you please add a third alcohol drink");
        shop.processAlcoholOrder("Drink 3", Size.SMALL);
        System.out.println("The current order of drinks is " + shop.getNumOfAlcoholDrink());
        System.out.println("The total price on the Order is $" + shop.getCurrentOrder().calcOrderTotal());
        if(shop.isEligibleForMore()) System.out.println("Your current alcohol drink is less than 4");
        else System.out.println("You have a maximum alcohol drinks for this order");

        System.out.println("Would you please add a Coffee to your order:");
        shop.processCoffeeOrder("Drink 4", Size.SMALL, true, true);
        System.out.println("The total items on your order: " + shop.getCurrentOrder().getTotalItems());
        System.out.println("The total price on the order is: $" + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("#---------------------------------------------------------#");
        System.out.println();
    }



}
