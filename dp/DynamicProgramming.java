package com.test.practices.dp;

public class DynamicProgramming {
    public static void main(String[] args) {
        /*long fibold = fib_old(5000);
        System.out.println(fibold);
        long fib = fib(5000);
        System.out.println(fib);*/
        long f = facto(20);
        System.out.println(f);
    }

    public static long fib(int num){
        if (num <= 0) {
            // Handle invalid input; you can also throw an exception instead
            return 0;
        }
//        int[] memo = new int[num+1];
//        memo[1] = 1;
//        memo[2] = 1;
//        // Compute Fibonacci numbers iteratively
//        for (int i = 3; i <= num; i++) {
//            memo[i] = memo[i - 1] + memo[i - 2];
//        }
//        return memo[num];
        if (num == 1 || num == 2) {
            return 1;
        }

        // Only store the last two values
        long prev1 = 1; // Represents dp[i - 1]
        long prev2 = 1; // Represents dp[i - 2]

        // Compute Fibonacci numbers iteratively
        for (int i = 3; i <= num; i++) {
            long current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static long fib_old(int num) {
        if (num <= 0) {
            // Handle invalid input; you can also throw an exception instead
            return 0;
        }
        long[] memo = new long[num+1];
        memo[1] = 1;
        memo[2] = 1;
        return fib(num,memo);


    }
    private static long fib(int num, long[] memo) {
        if(memo.length > 0 && memo[num] > 0 )
            return memo[num];
        if(num == 1 || num == 2)
            return 1;
        memo[num] = fib(num-1,memo)+fib(num-2,memo);
        return memo[num];
    }

    public static long facto(int num){
        if(num < 2)
            return 1;
        long sum = 1;
        for (int i = 2 ; i <=num; i++){
            sum = sum*i;
        }
        //return num * facto(num-1);
        return sum;
    }
}
