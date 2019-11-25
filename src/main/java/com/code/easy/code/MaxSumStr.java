package com.code.easy.code;

/**
 * Description
 * DATE 2019/2/26.
 *
 * [-2,1,-3,4,-1,2,1,-5,4],
 *
 * @author daijinwu.
 */
public class MaxSumStr {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-2,-1};
//        int maxSum = maxSum(nums);
        int maxSum = maxSubArray(nums);
        System.out.println(maxSum);
    }

    private static int maxSum(int[] nums) {
        int size = nums.length;
        int maxSum = 0;
        int sum = 0;
        if (nums.length==1){
            return nums[0];
        }
        for (int i=0;i<size;i++){
            if (i==0){
                maxSum = nums[i];
                sum = nums[i];
            }
            if (nums[i]>maxSum) {
                maxSum = nums[i];
            }
            for (int j=i+1;j<size;j++){
                if (sum<= (nums[i] + nums[j])){
                    sum = nums[i] + nums[j];
                    if (sum>maxSum){
                        maxSum = sum;
                    }
                    nums[i] = nums[i] + nums[j];
                }else {
                    nums[i] = nums[i] + nums[j];
                    if (maxSum<nums[i]){
                        maxSum = nums[i];
                    }
                }
            }
//            if (sum>maxSum){
//                maxSum = sum;
//            }
            sum = 0;
        }

        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

}
