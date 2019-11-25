package com.code.easy.code;

import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * DATE 2019/2/19.
 *
 * @author daijinwu.
 */
public class SumOfNumbers {
    public static void main(String[] args) {
        int[] numS = {1,3,5,3,20};
        int target = 6;
        List<Integer> list = getIndex(numS, target);
        if (list.size() > 0) {
            System.out.println("[" + list.get(0) + "," + list.get(1) + "]");
        }
    }

    public static List<Integer> getIndex(int[] numS, int target) {
        List<Integer> list = new LinkedList<Integer>();
        int length = numS.length - 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if ((numS[i] + numS[j]) == target) {
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
        }
        return new LinkedList<Integer>();
    }
}
