package com.code.easy.code;

/**
 * Description
 * DATE 2019/11/22.
 *
 * @author daijinwu.
 */
public class MedianNum {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        boolean flag = (m+n) % 2 == 0;
        int ms = flag ? (m+n)/2 : (m+n)/2 + 1;
        if (m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tp = m; m = n; n = tp;
        }
        int sum = 0;
        int count=0;
        int statueValue = 0;
        for (int i = 0; i < m; i++) {
            for (int j = statueValue; j < n; j++) {
                if (nums1[i] >= nums2[j]) {
                    count++;
                    statueValue++;
                    if (flag) {
                        if (count == ms) {
                            if (nums1[i] > nums2[j]) {
                                sum += nums2[j];
                            } else {
                                sum += nums1[i];
                            }
                        }
                        if (count == ms + 1) {
                            if (nums1[i] > nums2[j]) {
                                sum += nums2[j];
                            } else {
                                sum += nums1[i];
                            }
                        }
                    } else {
                        if (count == ms) {
                            if (nums1[i] > nums2[j]) {
                                sum += nums2[j];
                            } else {
                                sum += nums1[i];
                            }
                        }
                    }
                } else {
                    break;
                }
            }
            count++;
            if (flag) {
                if (count == ms) {
                    if (nums1[i] > nums2[--statueValue]) {
                        sum += nums2[--statueValue];
                    } else {
                        sum += nums1[i];
                    }
                }
                if (count == ms + 1) {
                    if (nums1[i] > nums2[--statueValue]) {
                        sum += nums2[--statueValue];
                    } else {
                        sum += nums1[i];
                    }
                }
            } else {
                if (count == ms) {
                    if (nums1[i] > nums2[--statueValue]) {
                        sum += nums2[--statueValue];
                    } else {
                        sum += nums1[i];
                    }
                }
            }
        }
        if (flag) {
            return sum / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3};
        int[] b = new int[]{2,4};
        System.out.println("findMedianSortedArrays(a,b) = " + findMedianSortedArrays(a, b));
    }
}
