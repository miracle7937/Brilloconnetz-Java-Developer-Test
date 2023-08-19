package com.brilloconnetz.brilloconnetz.logic.non_concurrent;

import java.util.Random;

public class PanCakeMakerConcurrent {
        private int pancakesMade;

        public synchronized void makePancakes() {
            Random rand = new Random();
            pancakesMade = rand.nextInt(13); // Maximum 12 pancakes
        }

        public synchronized int getPancakesMade() {
            return pancakesMade;
        }
    }

    class User implements Runnable {
        private int pancakesEaten;
        private int maxPancakes;

        public User(int maxPancakes) {
            this.maxPancakes = maxPancakes;
        }

        @Override
        public void run() {
            Random rand = new Random();
            pancakesEaten = rand.nextInt(maxPancakes + 1); // Maximum 5 pancakes
        }

        public int getPancakesEaten() {
            return pancakesEaten;
        }
    }

