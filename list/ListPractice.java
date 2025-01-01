package com.test.practices.list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;


public class ListPractice {
    public static void main(String[] args) {
        int[] a = {2,3,10,6,4,8,-70,89};
        int[] b = {30,10,8,2};
        /*
        * step 1 = [2,1],3,4,5,6 => reverse(0,d-1)
        * step 2 = 2,1,[6,5,4,3] => reverse(d,n-1)
        * step 3 = [3,4,5,6,1,2] => reverse(0,n-1)
        * */
        /*rotate1(a,2);//{3,4,5,6,1,2}
        Arrays.stream(a).forEach(i-> System.out.print(i+" "));*/

        /*int maxA = maxDiff1(a);
        System.out.println(maxA);
        int max = maxDiff1(b);
        System.out.println(max);*/

        /*int[] c = {2,0,2};
        int water = getWater1(c);
        System.out.println(water);

        int[] c1 = {3,0,1,2,5};
        int water1 = getWater1(c1);
        System.out.println(water1);*/


        /*int[] d = {1,-2,3,-1,2};
        int max = maxSumSubArray2(d);
        System.out.println(max);*/
        //System.out.println(maxSumSubArray2(a));
        /*int[] e = {1,2,3,5,6,8,7,8,9,10,11};
        System.out.println(longestEvenOddSubArray1(e));*/
        /*int[] f = {3,2,5,4};
        System.out.println(longestAlternatingSubarray(f,5));*/
        /*System.out.println(lengthOfLongestSubstring1("abcabcbb"));*/
        //int[] g = {5,-2,3,4};
        //System.out.println(maximumCircularSum(g));
        //int[] g1 = {3,-4,5,6,-8,7};
        //int[] g2 = {1,-2,3,-2};
        //System.out.println(maximumCircularSum(g1));
        //System.out.println(maximumCircularSum(g2));
        /*System.out.println("------Naive-------------");
        System.out.println(maximumCircularSum1(g));
        System.out.println(maximumCircularSum1(g1));
        System.out.println("------Efficient-------------");
        System.out.println(maximumCircularSum2(g));
        System.out.println(maximumCircularSum2(g1));*/

        /*int[] nums = {3,4,1,2};
        int[] nums1 = {1,2,3};

        System.out.println(checkRotatedAndSorted(nums,nums.length));
        System.out.println(checkRotatedAndSorted(nums1,nums1.length));*/

        /*int[] nums = {3,1,2,3};
        System.out.println(majorityElement1(nums));*/

        /*int[] nums = {1,0,0,1,1,1,0,0,1,1};
        System.out.println("{1,0,0,1,1,1,0,0,1,1}");
        groups(nums);*/

        /*int[] nums = {7,3,4,5,6};
        System.out.println(maximumSum(nums,4));*/

        /*int[] nums = {1,2,3,4,5};
        System.out.println(subarrayWithGivenSum(nums,120));*/
        /*int [] nums  = {2,3,5,4,6,1};
        System.out.println(getWSum(nums,2,3));*/

         /*   int[] nums = {3,4,8,-9,20,6};
        int[] nums1 = {4,2,-2};
        int[] nums2 = {4,2,2};
        System.out.println(equilibrium(nums));
        System.out.println(equilibrium(nums1));
        System.out.println(equilibrium(nums2));
        System.out.println("-----Efficient Solution");
        System.out.println(equilibrium2(nums));
        System.out.println(equilibrium2(nums1));
        System.out.println(equilibrium2(nums2));*/

        /*int[] nums = {5,2,6,1,1,1,1,4};
        System.out.println(canPartitionIntoThreeParts(nums));*/

        /*int[] left  = {1,2};
        int[] right = {5,4};
        int[] left1 = {1,2,5,15},  right1 = {5,8,7,18};
        //System.out.println(maximumAppearingElementInRanges(left,right));
        System.out.println(maximumAppearingElementInRanges1(left1,right1));*/
    }


    public static int[] rotate(int[] arr, int n){
        if(arr.length == 0 || n == 0){
            return arr;
        }
        if (arr.length == 1)
            return arr;
        int[] res = new int[arr.length];
        int j = 0;
        for (int i = n; n < arr.length; i++,j++) {
            res[j] = arr[i];
        }
        for (int k=0; j < res.length; j++,k++) {
            res[j] = arr[k];
        }
        return res;
    }
    public static void rotate1(int[] l, int d){
        if(l.length == 0 || l.length == 1 || d == 0 || d > l.length){
            return;
        }
        int n = l.length;
        reverse(l,0,d-1);
        reverse(l,d,n-1);
        reverse(l,0,n-1);
    }

    //0(n) & AS- 0(1)
    public static void reverse(int[] l,int b,int e){
        while (b<e){
            int temp = l[b];
            l[b] = l[e];
            l[e] = temp;
            b = b+1;
            e = e-1;
        }
    }

    //Maximum Difference=> O(n^2)
    public static int maxDiff(int[] a){
        int max = a[1]-a[0];
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (max < (a[j]-a[i]))
                    max = a[j]-a[i];
            }
        }
        return max;
    }

    /*
    * Approach
    * {2,3,10,6,4,8,1}
    * max = a[1]-a[0]
    * min = a[0]
    * iteration index 1 to n-1:-
    * i=1 => max = max(max,a[1]-min)
    *        min = min(min,a[1])
    * i=2 => max = max(max,a[2]-min)
    *        min = min(min,a[2])
    * i=3 => max = max(max,a[3]-min)
    *        min = min(min,a[3])
    * i=4 => max = max(max,a[4]-min)
    *        min = min(min,a[4])
    * i=5 => max = max(max,a[5]-min)
    *        min = min(min,a[5])
    * i=6 => max = max(max,a[6]-min)
    *        min = min(min,a[6])
    * Maximum difference = max (8)
    * */

    //Optimized Maximum Difference => O(n)
    public static int maxDiff1(int[] a){
        int max = a[1]-a[0];
        int minimal = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max,a[i]-minimal);
            minimal = Math.min(a[i],minimal);
        }
        return max;
    }

    //Stock buy & sell (part 1)
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
    public static int maxProfitII(int[] prices) {
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If there is an upward slope, add the profit
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
                System.out.println("total "+ totalProfit);
            }
        }
        return totalProfit;
    }

    //water trapping Time Complexity is 0(n^2) (Naive solution)
    public static int getWater(int[] a){
        int n = a.length;
        int res = 0;
        for (int i = 1; i < n-1; i++) {
            int lmax = a[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax,a[j]);
            }
            int rmax = a[i];
            for (int j = i+1; j < n; j++) {
                rmax = Math.max(rmax,a[j]);
            }
            res = res + (Math.min(lmax,rmax)-a[i]);
        }
        return res;
    }

    //Efficient Approach water trapping Time Complexity is 0(n)
    public static int getWater1(int[] a){
        System.out.print("Given Array : ");
        Arrays.stream(a).forEach(i-> System.out.print(i+" "));
        System.out.println();
        int n = a.length;//{3,0,1,2,5}
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int res = 0;
        lmax[0] = a[0];
        for (int i = 1; i < n; i++) {
            lmax[i]  = Math.max(lmax[i-1],a[i]);
        }
        System.out.print("lmax : ");
        Arrays.stream(lmax).forEach(i-> System.out.print(i+" "));
        System.out.println();
        rmax[n-1] = a[n-1];
        for (int i = n-2; i > 0; i--) {
            rmax[i]  = Math.max(rmax[i+1],a[i]);
        }
        System.out.print("rmax : ");
        Arrays.stream(rmax).forEach(i-> System.out.print(i+" "));
        System.out.println();
        for (int i = 1; i < n-1; i++) {
            res = res + (Math.min(lmax[i],rmax[i])-a[i]);
        }
        return res;
    }

    //Maximum sum subarray (Naive solution) worst case O(n^2)
    public static int maxSumSubArray(int[] a){
        int res = a[0];
        for (int i = 1; i < a.length; i++) {
            int curr = 0;
            for (int j = i; j < a.length ; j++) {
                curr += a[j];
                res = Math.max(res,curr);
            }
        }
        return res;
    }

    //Maximum sum subarray (Efficient solution) O(n)
    public static int maxSumSubArray1(int[] a){
        int res = a[0];
        int maxEnding = a[0];
        for (int i = 1; i < a.length; i++) {
            maxEnding = Math.max(maxEnding+a[i],a[i]);
            res = Math.max(res,maxEnding);
        }
        return res;
    }

    //Using java stream api
    public static int maxSumSubArray2(int[] a){
        /*int res = a[0];
        int maxEnding = a[0];
       *//* for (int i = 1; i < a.length; i++) {
            maxEnding = Math.max(maxEnding+a[i],a[i]);
            res = Math.max(res,maxEnding);
        }*///{1,-2,3,-1,2}
        int res = IntStream.range(1, a.length)
                .mapToObj(i -> a[i])
                .reduce(
                        new int[]{a[0], a[0]}, // Initial state: [maxEnding, res]
                        (state, current) -> new int[]{
                                Math.max(state[0] + current, current), // maxEnding
                                Math.max(state[1], Math.max(state[0] + current, current)) // res
                        },
                        (state1, state2) -> state1 // Combiner is unnecessary in sequential
                )[1];
        return res;
    }


    //Longest Even Odd Subarray (Naive Approach)  => O(n^2)
    public static int longestEvenOddSubArray(int[] nums){
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = 1;
            for (int j = i+1; j < nums.length; j++) {
                if((nums[j]%2 == 0 && nums[j-1] % 2 != 0)||(nums[j-1] % 2 == 0 && nums[j] % 2 != 0))
                    curr = curr+1;
                else
                    break;
            }
            res = Math.max(res,curr);
        }
        return res;
    }

    //Longest Even Odd Subarray (Efficient Approach)  => O(n)
    public static int longestEvenOddSubArray1(int[] nums) {
        int res = 0;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != nums[i - 1] % 2) {
                res = Math.max(res, ++curr);
            }else {
                curr = 1;
            }
        }
        return res;
    }
    /*

    Example 1:
    Input: nums = [3,2,5,4], threshold = 5
    Output: 3
    Explanation: In this example, we can select the subarray that starts at l = 1 and ends at r = 3 => [2,5,4]. This subarray satisfies the conditions.
    Hence, the answer is the length of the subarray, 3. We can show that 3 is the maximum possible achievable length.

    Example 2:
    Input: nums = [1,2], threshold = 2
    Output: 1
    Explanation: In this example, we can select the subarray that starts at l = 1 and ends at r = 1 => [2].
    It satisfies all the conditions and we can show that 1 is the maximum possible achievable length.

    Example 3:
    Input: nums = [2,3,4,5], threshold = 4
    Output: 3
    Explanation: In this example, we can select the subarray that starts at l = 0 and ends at r = 2 => [2,3,4].
    It satisfies all the conditions.
    Hence, the answer is the length of the subarray, 3. We can show that 3 is the maximum possible achievable length.
    * */
    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        for (int left = 0; left < nums.length;) {
            int right;
            if (nums[left] % 2 == 0 && nums[left] <= threshold) {
                for (right = left + 1; right < nums.length;) {
                    if ((nums[right] % 2 != nums[right - 1] % 2) && nums[right] <= threshold) {
                        right++;
                    }else
                        break;
                }
                res = Math.max(res, right - left);
                left = right;
            }else {
                left++;
            }
        }
        return res;
    }

    // maximum Circular sum sub-array (Naive approach)
    //{5,-2,3,4} = 12
    // ^   ^ ^
    //{2,3,-4} = 5
    // ^ ^
    //Time Complexity => O(n^2)
    public static int maximumCircularSum(int[] nums){
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currSum =nums[i];
            res = Math.max(res,currSum);
            int j = i+1;
            while (j<nums.length){
                currSum+=nums[j];
                res = Math.max(res,currSum);
                j++;
            }
            int k = 0;
            while (k<i){
                currSum+=nums[k];
                res = Math.max(res,currSum);
                k++;
            }
        }
        return res;
    }
    //Naive approach - 2 => O(n^2)
    public static int maximumCircularSum1(int[] nums){
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currMax = nums[i];
            int currSum = nums[i];
            for (int j = 1; j < nums.length; j++) {
                int index = (i+j) % nums.length;
                currSum += nums[index];
                currMax = Math.max(currMax,currSum);
            }
            res = Math.max(res,currMax);
        }
        return res;
    }

    //Efficient solution => O(n) ==> Kadane's algorithm
    public static int maximumCircularSum2(int[] nums){
        int maxNormal = normalMaxSum(nums);
        if(maxNormal < 0){
            return maxNormal;
        }
        int numSum=0;
        for (int i = 0; i < nums.length; i++) {
            numSum +=nums[i];
            nums[i] = -nums[i];
        }
        int maxCircular = numSum+normalMaxSum(nums);
        return Math.max(maxCircular,maxNormal);
    }

    private static int normalMaxSum(int[] nums) {
        int res = nums[0];
        int maxEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding+nums[i],nums[i]);
            res = Math.max(res,maxEnding);
        }
        return res;
    }

    /*
    * nums = arrays
    * num = size of array
    * */
    public static boolean checkRotatedAndSorted(int[] nums,int num){
        if (num <= 1) return false; // Single element or empty arrays are not rotated

        int countAscBreaks = 0; // Count rotation points for ascending
        int countDescBreaks = 0; // Count rotation points for descending

        for (int i = 0; i < num; i++) {
            // Check ascending order breaks
            if (nums[i] > nums[(i + 1) % num]) {
                countAscBreaks++;
            }
            // Check descending order breaks
            if (nums[i] < nums[(i + 1) % num]) {
                countDescBreaks++;
            }
        }

        // Check if there is exactly one break and the array is rotated
        if ((countAscBreaks == 1 && nums[0] > nums[num - 1]) ||
                (countDescBreaks == 1 && nums[0] < nums[num - 1])) {
            return true;
        }

        return false;
    }

    //Naive Approach (worst case - O(n^2))
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder s1 = new StringBuilder();
            s1.append(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                if (s1.indexOf(""+s.charAt(j)) == -1){
                    s1.append(s.charAt(j));
                }else {
                    break;
                }
            }
            res = Math.max(res,s1.length());
        }
        return res;
    }


    //Majority Element (Naive solution) => O(n^2)
    public static int majorityElement(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count += 1;
            }
            if (count > nums.length/2 ){
                return i;
            }
        }

        return -1;
    }

    //Majority Element (Efficient solution) => O(n) => arr = {3,2,3,1,3}
    public static int majorityElement1(int[] nums){
        int res = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[res])
                count += 1;
            else
                count -= 1;
            if (count == 0){
                res = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[res])
                count += 1;
        }

        if (count <= nums.length/2 ){
            return -1;
        }
        return res;
    }

    //Minimum group flips to make same. example input:- {1,0,0,1,1,1,0,0,1,1} => {1,1,1,1,1,1,1,1,1,1}
    public static void groups(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                if (nums[i] != nums[0]){
                    System.out.print("from "+i+" to ");
                }else {
                    System.out.print(i-1+"\n");
                }
            }
        }
        if (nums[nums.length-1]!=nums[0])
            System.out.println(nums.length-1);
    }

    //Find the maximum sum of k consecutive elements(sliding window problem)
    public static int maximumSum(int[] nums, int k){
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum +=nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            sum = Math.max(sum,sum + nums[i] -nums[i-k]);
        }
        return sum;
    }
    //check subarray with given sum => Naive solution with O(n^2)
    public static boolean subarrayWithGivenSum(int[] nums, int sum){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int res = 0;
            for (int j = i; j < n; j++) {
                res += nums[j];
                if(res == sum)
                    return true;
            }
        }
        return false;
    }
    //Efficient solution => check subarray with given sum O(n)
    public static boolean subarrayWithGivenSum1(int[] nums, int sum){
        int s=0,curr=0;
        for (int e = 0; e < nums.length; e++) {
            curr +=  nums[e];
            while (curr>sum){
                curr = curr-nums[s];
                s += 1;
            }
            if(curr == sum)
                return true;
        }
        return false;
    }
    public static int getSum(int[] nums,int l, int range){
        int res = 0;
        for (int i = l; i < range+1; i++) {
            res += nums[i];
        }
        return res;
    }
    //get prefix sum of array
    public static int[] prefixSum(int[] nums){
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        return prefixSum;
    }
    //using prefixSum technique
    public static int getSum1(int[] nums,int l, int r){
        int[] prefixSum = prefixSum(nums);
        if(l == 0)
            return prefixSum[r];
        else
            return prefixSum[r]-prefixSum[l-1];
    }

    public static int[] prefixWeightedSum(int[] nums) {
        int n = nums.length;
        int[] prefixWSum = new int[n];
        prefixWSum[0] = nums[0];
        for (int i = 1; i <n; i++) {
            prefixWSum[i] = (i+1)*nums[i]+prefixWSum[i-1];
        }
        return prefixWSum;
    }
    //using prefixSum technique
    public static int getWSum(int[] nums,int l, int r){
        int[] prefixSum = prefixSum(nums);
        int[] prefixWsum = prefixWeightedSum(nums);
        if(l == 0)
            return prefixWsum[r];
        else
            return prefixWsum[r] - prefixWsum[l - 1] - (l * (prefixSum[r] - prefixSum[l - 1]));
    }

    
    /*
    example 1:
     input: {3,4,8,-9,20,6}
     output: True
    example 2:
     input: {4,2,-2}
     output: True
    example 2:
     input: {4,2,2}
     output: False
     */
    // Equilibrium point => naive solution => O(n^2)
    public static boolean equilibrium(int[] nums){
        if (nums.length == 0){
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = i+1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum)
                return true;
        }
        return false;
    }

    // Equilibrium point => efficient solution => O(n)
    public static boolean equilibrium1(int[] nums){
        if (nums.length == 0){
            return true;
        }
        int[] prefixSum = prefixSum(nums);
        for (int i = 0; i < nums.length; i++) {
            int leftSum = i < 1 ? 0: prefixSum[i-1];
            int rightSum = i > nums.length - 1? 0 : prefixSum[nums.length - 1] - prefixSum[i];
            if (leftSum == rightSum)
                return true;
        }
        return false;
    }

    // Equilibrium point => efficient solution => O(n)
    public static boolean equilibrium2(int[] nums){
        if (nums.length == 0){
            return true;
        }
        int rightSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -=  nums[i];
            if (leftSum == rightSum)
                return true;
            leftSum += nums[i];
        }
        return false;
    }
    /*
    * Ex. 1:
    * arr = {5,2,6,1,1,1,1,4}
    * o/p = True
    * Ex. 2:
    * arr = {3,2,5,1,1,5}
    * o/p = False
    * */
    //Check if Array can be partitioned into three different parts with equal sum
    public static boolean canPartitionIntoThreeParts(int[] nums){
        if (nums.length == 0){
            return true;
        }
        int totalSum = Arrays.stream(nums).sum();
        // If the total sum is not divisible by 3, we cannot partition
        if (totalSum % 3 != 0) {
            return false;
        }

        int targetSum = totalSum / 3;
        int currentSum = 0;
        int partitions = 0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum == targetSum) {
                partitions++;
                currentSum = 0;
            }

            // If we've already found 3 partitions, we can return true
            if (partitions == 3) {
                return true;
            }
        }

        // If we finish the loop and have less than 3 partitions, return false
        return false;
    }

    /*
    *
    * Ex.1
    * i/p => left = {1,2,5,15},  right = {5,8,7,18}
    * o/p => 5
    *
    * Ex.2
    * i/p => left = {1,2}.  right = {5,4}
    * o/p => 2
    * Explanation => {1,2,3,4,5},{2,3,4} max appearing is element 2
    *  */
    //Maximum appearing element in Ranges (Naive Solution) => O(n*max)
    public static int maximumAppearingElementInRanges(int[] left,int[] right){
       int[] freq = new int[100];
        for (int i = 0; i < left.length; i++) {
            for(int j = left[i]; j < right[i] + 1; j++){
                freq[j] += 1;
            }
        }
        return IntStream.range(0, freq.length).reduce((i,j)->freq[i]>freq[j]?i:j).orElse(-1);
    }

    //Maximum appearing element in Ranges (Efficient Solution) => O(n+max)
    public static int maximumAppearingElementInRanges1(int[] left,int[] right){
        int[] freq = new int[101];
        for (int i = 0; i < left.length; i++) {
            freq[left[i]] += 1;
            freq[right[i]+1] -= 1;
        }
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i]+freq[i-1];
        }
        return IntStream.range(0, freq.length).reduce((i,j)->freq[i]>freq[j]?i:j).getAsInt();
    }





    //Efficient Approach (worst case - O(n))
    public static int lengthOfLongestSubstring1(String s) {
        int res = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            //if duplicate found we wil remove from set
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res = Math.max(res,right-left+1);
        }
        return res;
    }

}
