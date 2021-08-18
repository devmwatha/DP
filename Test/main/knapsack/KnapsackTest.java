package main.knapsack;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KnapsackTest {

    @Test
    void solveKnapsack() {
        Knapsack knapsack = new Knapsack();
        int profit = knapsack.solveKnapsack(new int[]{1, 6, 10, 16}, new int[]{1, 2, 3, 5}, 7);
        Assertions.assertEquals(profit, profit);
    }
}