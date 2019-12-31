package com.code.easy.code.array;

/**
 * @version v1.0
 * @ClassName: FirstBadVersion_278
 * @Description: 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。
 * 你应该尽量减少对调用 API 的次数。
 * @Author: JW
 * @Date: 2019/12/31 23:46
 */
public class FirstBadVersion_278 {

    /*
    二分查找
     */
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /*
    线性扫描 [超出时间限制]
     */
    public int firstBadVersion2(int n) {
        for (int i = 1; i < n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }


    /*
    这个函数系统自己提供，咱们直接调用即可，不用关心里面具体实现
    来判断版本号 version 是否在单元测试中出错
     */
    private static boolean isBadVersion(int curr) {
        if (curr <=3) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
