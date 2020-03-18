package com.chenps3.algs.leetcode.problem;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @Author chenguanhong
 * @Date 2020-02-26
 */
public class Problem209 {

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(s, nums) == 2);
    }


    public static int minSubArrayLen(int s, int[] nums) {
//        return s1(s, nums);
//        return s2(s, nums);
//        return s3(s, nums);
        return s4(s, nums);

    }

    //法1 暴力搜索 O(n²)
    private static int s1(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                    }
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //法2 使用二分查找优化的暴力搜索 O(nlogn)
    private static int s2(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] sums = new int[nums.length];
        //第一轮遍历,sums[i]表示num[0]到nums[i]的和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        //第二轮遍历，内循环求j的最小值时，使用二分法优化
        for (int i = 0; i < nums.length; i++) {
            int lo = i;
            int hi = nums.length;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int tmpSum = sums[mid] - sums[i] + nums[i];   //坐标i到mid之间的和
                if (tmpSum >= s) {
                    if (mid - i + 1 < min) {
                        min = mid - i + 1;
                    }
                    hi = mid;
                } else if (tmpSum < s) {
                    lo = mid + 1;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //法3 对序列长度进行二分 O(nlogn)
    private static int s3(int s, int[] nums) {
        int lo = 1;
        int hi = nums.length;
        int minLen = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int maxSum = getMaxSum(mid, nums);
            if (maxSum >= s) {
                if (minLen > mid) {
                    minLen = mid;
                }
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    //求长度为len的子序列的最大和,相当于滑动窗口
    private static int getMaxSum(int len, int[] nums) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int maxSum = sum;       //初始值
        //滑窗更新maxSum
        for (int i = len; i < nums.length; i++) {
            sum -= nums[i - len];
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    //法4 双指针 O(n)
    private static int s4(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;       //指针1 left
        for (int right = 0; right < nums.length; right++) {     //指针2 right
            //增大窗口，直到和大于等于s
            sum += nums[right];
            while (sum >= s) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                }
                sum -= nums[left++]; //缩小窗口
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
