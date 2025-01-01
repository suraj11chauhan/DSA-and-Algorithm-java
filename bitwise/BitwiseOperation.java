package com.test.practices.bitwise;

import java.util.Arrays;

public class BitwiseOperation {

    public static void main(String[] args) {
        //System.out.println(countSetBits2(40));
        /*System.out.println(unset(25,1));
        System.out.println(unset(25,2));
        System.out.println(unset(25,3));
        System.out.println(unset(25,4))*/;

        /*int n = 29;
        System.out.println("Original Number: " + n + " (Binary: " + Integer.toBinaryString(n) + ")");

        n = flip(n,4);
        System.out.println("Flipped Number: " + n + " (Binary: " + Integer.toBinaryString(n) + ")");*/
        /*System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(5));*/

        /*int[] nums = {3,4};
        System.out.println(oneOddCount(nums));*/
        //Arrays.stream(twoOddCountNaive(nums)).forEach(i-> System.out.println(i));
        //isKthBitSet(32,1);

       // System.out.println(checkEvenOrOdd(1));
        //System.out.println(isPowOf2(2));

       // System.out.println(kthBitSetIfNotSet(25,3));
        /*System.out.println(multiply(25,7));*/
        System.out.println(division(100,2));




    }

    //Even or odd
    public static String checkEvenOrOdd(int n){
        return (n & 1) == 0 ? "EVEN":"ODD";
    }
    //isPowOf2
    public static String isPowOf2(int n){
        return (n & n-1) == 0 ? "YES":"NO";
    }
    //isPowOfX-- Not correct
    public static String isPowOfX(int n,int x){
        return (n & n-x) == 0 ? "YES":"NO";
    }
    //multiply
    public static int multiply(int x, int n) {
        int result = 0;
        int power = 0;

        // Iterate through each bit in n
        while (n > 0) {
            // Check if the current bit is set (1)
            if ((n & 1) == 1) {
                // Add x shifted by the current power of 2
                result += (x << power);
            }

            // Move to the next bit
            n >>= 1;
            power++;
        }

        return result;
    }
    public static int multiplyByPowerOfTwo(int x,int n) {
      return x << n;
    }
    public static int division(int x,int n) {
        return x >> n;
    }

    //using left shift
    public static void isKthBitSet(int n,int k){
        if((n & (1 << (k-1))) != 0){
            System.out.println("SET");
        }else {
            System.out.println("NOT SET");
        }
    }
    //using right shift
    public static void isKthBitSet1(int n,int k){
        if(((n >> (k-1)) & 1) != 0){
            System.out.println("SET");
        }else {
            System.out.println("NOT SET");
        }
    }

    //using left shift
    public static int kthBitSetIfNotSet(int n,int k){
        if((n & (1 << (k-1))) == 0){
            n = n | (1 << (k-1));
        }else {
            System.out.println("Already SET");
        }
        return n;
    }

    public static int countSetBits(int n){
        int res =0;
        while (n > 0){
           /* if(n%2 == 1)
                res += 1;*/
            //alternative of if condition
            res = res + (n & 1);
            n = n/2;
        }
        return res;
    }

    //Brian Kernigam's Algorithm
    public static int countSetBits2(int n){
        int res =0;
        while (n > 0){
            n = n & (n-1);
            res = res + 1;
        }
        return res;
    }
    // in a number
    public static int setBit(int n, int pos)
    {
        return n | (1 << pos);
    }

    // Unset (clear) a bit at position pos in number n
    public static int unset(int n, int pos) {
        n =  n & ~(1 << pos);
        return n;
    }

    // Flip (toggle) a bit at position pos in number n
    static int flip(int n, int pos) {
        return n ^= (1 << pos);
    }

    // Check if n is a power of two
    public static boolean isPowerOfTwo(int n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }

    public static int oneOddCount(int[] num){
        int res = 0;
        for (int n:num)
            res = res ^ n;
        return res;
    }

    public static int[] twoOddCountNaive(int[] num){
        int[] res = new int[2];

        int k = 0;
        for (int i = 0; i < num.length; i++) {
            int count = 0;
            for (int j = 0; j < num.length; j++) {
                if(num[i] == num[j])
                    count += 1;
            }
            if(count  % 2 != 0){
                System.out.println(num[i]);
            }
        }
        return res;
    }

    public static void twoOddCount(int[] num){
        int xor =0,res1=0,res2=0;
        for (int n :num) {//3,4,5,4,5
            xor = xor ^ n;
        }
        int sn = xor & ~(xor-1);

    }

    /*public static int[] twoOddCount(int[] num){
        int[] res = new int[2];
        for (int n:num)
            res = res ^ n;
        return res;
    }*/
}
