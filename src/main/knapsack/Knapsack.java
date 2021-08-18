package main.knapsack;

public class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return this.knapSackRecursive(profits, weights, capacity, 0);
    }

    private int knapSackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        //base case
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;
        int profit = 0, profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit = profits[currentIndex] + knapSackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);

        profit1 = knapSackRecursive(profits, weights, capacity, currentIndex + 1);
        return Math.max(profit, profit1);

    }
}
