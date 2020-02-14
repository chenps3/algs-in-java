package com.chenps3.algs.impl.dp;

public class LeetCode198 {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return bigger(nums[0], nums[1]);
        }
        int[] func = new int[nums.length];
        func[0] = nums[0];
        func[1] = bigger(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            func[i] = bigger(func[i - 2] + nums[i], func[i - 1]);
        }
        int result = func[0];
        for (int i = 1; i < func.length; i++) {
            result = result > func[i] ? result : func[i];
        }
        return result;
    }

    private static int bigger(int a, int b) {
        return a > b ? a : b;
    }
}
