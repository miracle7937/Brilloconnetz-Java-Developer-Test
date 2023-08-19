package com.brilloconnetz.brilloconnetz.logic;

import java.util.Random;

public class PanCakeMaker {

        private int pancakesMade;

        public void makePancakes() {
            Random rand = new Random();
            pancakesMade = rand.nextInt(13); // Maximum 12 pancakes
        }

        public int getPancakesMade() {
            return pancakesMade;
        }
    }

    class User {
        private int pancakesEaten;

        public void eatPancakes(int maxPancakes) {
            Random rand = new Random();
            pancakesEaten = rand.nextInt(maxPancakes + 1); // Maximum 5 pancakes
        }

        public int getPancakesEaten() {
            return pancakesEaten;
        }
    }

