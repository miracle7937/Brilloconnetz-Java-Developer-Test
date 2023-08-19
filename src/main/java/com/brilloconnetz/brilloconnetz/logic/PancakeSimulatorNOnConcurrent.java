package com.brilloconnetz.brilloconnetz.logic;

public class PancakeSimulatorNOnConcurrent {


    public static void make() {
        PanCakeMaker shopkeeper = new PanCakeMaker();
        User[] users = new User[3];
        int totalPancakesEaten = 0;

        for (int i = 0; i < 3; i++) {
            users[i] = new User();
        }

        for (int i = 0; i < 2; i++) { // Simulate two 30-second periods
            shopkeeper.makePancakes();
            int pancakesMade = shopkeeper.getPancakesMade();
            int maxPancakesForUsers = Math.min(5, pancakesMade);

            for (User user : users) {
                user.eatPancakes(maxPancakesForUsers);
                totalPancakesEaten += user.getPancakesEaten();
            }

            System.out.println("30-second period " + (i + 1));
            System.out.println("Pancakes made by shopkeeper: " + pancakesMade);
            System.out.println("Pancakes eaten by users: " + totalPancakesEaten);
            if (totalPancakesEaten <= pancakesMade) {
                System.out.println("Shopkeeper met user needs.");
                System.out.println("Pancakes wasted: " + (pancakesMade - totalPancakesEaten));
            } else {
                System.out.println("Shopkeeper couldn't meet user needs.");
                System.out.println("Unmet pancake orders: " + (totalPancakesEaten - pancakesMade));
            }
            System.out.println();
        }
    }
}
