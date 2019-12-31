package com.code.easy.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class Generate_118 {
    private static List<List<Integer>> lists = new ArrayList<>();
    public static List<List<Integer>> generate(int nums) {
        for (int i=0;i<nums;i++) {
            List<Integer> list = generateList(i);
            lists.add(list);
        }
        return lists;
    }

    private static List<Integer> generateList(int i) {
        List<Integer> list = new ArrayList<>();
        if (i==0) {
            list.add(1);
            return list;
        } else if (i==1) {
            list.add(1);
            list.add(1);
            return list;
        } else {
            list.add(0,1);
            List<Integer> preList = lists.get(i - 1);
            for (int j=1;j<i;j++) {
                list.add(j, preList.get(j-1) + preList.get(j));
            }
            list.add(i,1);
            return list;
        }
    }

    public static void main(String[] args) {
        generate(5);
        for (int i=0;i<lists.size();i++) {
            for (int j=0;j<lists.get(i).size();j++) {
                System.out.printf(lists.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
}
