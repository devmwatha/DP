package main.knapsack;

import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.knapsackBUImproved(new int[]{1, 6, 10, 16}, new int[]{1, 2, 3, 5}, 6));
        System.out.println(knapsack.solveKnapsack(new int[]{1, 6, 10, 16}, new int[]{1, 2, 3, 5}, 6));
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapSackTopDown(dp, profits, weights, capacity, 0);

//        return this.knapSackRecursive(profits, weights, capacity, 0);
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

    private int knapSackTopDown(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
       /*
       Space complexity O(N*C +N), time complexity O(N*C)
        */

        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        if (dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];


        int profit = 0;
        if (weights[currentIndex] <= capacity)
            profit = profits[currentIndex] + knapSackTopDown(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);

        int profit2 = knapSackTopDown(dp, profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit, profit2);
        return dp[currentIndex][capacity];
    }

    public int knapSackBottomUp(int[] profits, int[] weights, int capacity) {
        //base case
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                dp[0][c] = profits[0];
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit = 0, profit1 = 0;
                if (weights[i] <= c)
                    profit = profits[i] + dp[i - 1][c - weights[i]];
                profit1 = dp[i - 1][c];
                dp[i][c] = Math.max(profit, profit1);
            }
        }
        return dp[n - 1][capacity];
    }

    public int knapsackBUImproved(int[] profits, int[] weights, int capacity) {
        //base case
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[] dp = new int[capacity + 1];

        //one weight only
        for (int c = 0; c <= capacity; c++)
            if (weights[0] <= c)
                dp[c] = profits[0];


        for (int i = 1; i < n; i++) {
            for (int c = capacity; c >= 0; c--) {
                int profit = 0, profit1 = 0;
                if (weights[i] <= c)
                    profit = profits[i] + dp[c - weights[i]];
                profit1 = dp[c];
                dp[c] = Math.max(profit, profit1);
            }
        }
        return dp[capacity];
    }
}
