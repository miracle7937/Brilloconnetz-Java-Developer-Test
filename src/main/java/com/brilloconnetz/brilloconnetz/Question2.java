package com.brilloconnetz.brilloconnetz;

import com.brilloconnetz.brilloconnetz.logic.PancakeSimulatorNOnConcurrent;
import com.brilloconnetz.brilloconnetz.logic.non_concurrent.ConcurrentPancakeSimulator;

public class Question2 {
    public static void main(String[] args) {
        //for no concurrent
        new PancakeSimulatorNOnConcurrent().make();


        //for concurrent
        new ConcurrentPancakeSimulator().make();
    }
}
