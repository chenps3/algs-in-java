package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * 滑动窗口
 * @Author chenguanhong
 * @Date 2020/4/21
 */
public class Problem1248 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }

    //找出每个最小的优美子数组，统计左右偶数的数量
    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int oddCnt = 0;
        int result = 0;
        while (right < nums.length) {
            if (isOdd(nums[right])) {
                oddCnt++;
            }
            right++;
            if (oddCnt == k) {
                //分别统计begin到第一个奇数 end到第k+1个奇数之间的偶数数量
                int leftEvenCnt = 0;
                int rightEvenCnt = 0;
                while (isEven(nums[left])) {
                    left++;
                    leftEvenCnt++;
                }
                int tmpRight = right;
                while (tmpRight < nums.length && isEven(nums[tmpRight])) {
                    tmpRight++;
                    rightEvenCnt++;
                }
                result += (leftEvenCnt + 1) * (rightEvenCnt + 1);
                left++;
                oddCnt--;
            }
        }
        return result;
    }

    private static boolean isOdd(int i) {
        return (i & 1) == 1;
    }

    private static boolean isEven(int i) {
        return (i & 1) == 0;
    }
}
