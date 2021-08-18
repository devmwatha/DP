package main.Fibonacci;

public class Fibonacci {

    /*
    Dynamic programming top -down with memoization
    solve bigger problems by recursively finding the solution to smaller sub-problems. whenever, we solve a sub-problem
    we cache the result so that we don't end up solving it repeatedly if it called multiple times. Instead, we return the saved result
    this technique is called memoization where we store the results of already solved sub-problems
     */
    public static int calculateFibonacci(int n) {
        int[] memoize = new int[n + 1];
        return calculateFibonacciRecursive(memoize, n);
    }

    private static int calculateFibonacciRecursive(int[] memoize, int n) {
        if (n < 2) return n;

        if (memoize[n] != 0)
            return memoize[n];

        memoize[n] = calculateFibonacciRecursive(memoize, n - 1) + calculateFibonacciRecursive(memoize, n - 2);
        return memoize[n];
    }

    public static int calculateFibBottomUp(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];


        //base cases
        dp[0] = 0;
        dp[1] = 1;

        int i = 2;
        while (i <= n) {
            dp[i] = dp[i - 1] + dp[i - 2];
            i++;
        }

        return dp[n];
    }


}
