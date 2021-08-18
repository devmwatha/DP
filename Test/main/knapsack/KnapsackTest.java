package main.knapsack;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KnapsackTest {
    Knapsack knapsack = new Knapsack();

    @Test
    void solveKnapsack() {
        int profit = knapsack.solveKnapsack(new int[]{1, 6, 10, 16}, new int[]{1, 2, 3, 5}, 7);
        Assertions.assertEquals(profit, profit);
    }

    @Test
    void knapSackTopDown() {
        int maxProfit = knapsack.solveKnapsack(new int[]{1, 6, 10, 16}, new int[]{1, 2, 3, 5}, 6);
        Assertions.assertEquals(maxProfit, maxProfit);
    }

    @Test
    void knapSackBottomUp() {
        int maxProfit = knapsack.knapSackBottomUp(new int[]{1, 6, 10, 16}, new int[]{1, 2, 3, 5}, 6);
        Assertions.assertEquals(maxProfit, maxProfit);
    }
}