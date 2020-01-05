package com.code.easy.code.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: FizzBuzz_412
 * @Description: 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”
 * @Author: JW
 * @Date: 2020/1/5 16:04
 */
public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for (int i=1;i<=n;i++) {
            String result = rv(i);
            list.add(result);
        }
        return list;
    }

    private String rv(int i) {
        if (i%15==0) {
            return "FizzBuzz";
        }
        if (i%3==0) {
            return "Fizz";
        }
        if (i%5==0) {
            return "Buzz";
        }
        return Integer.toString(i);
    }

    public static void main(String[] args) {

    }


    /**
     * 用散列表
     * @param n
     * @return
     */
    public List<String> fizzBuzz2(int n) {

        List<String> ans = new ArrayList<String>();

        HashMap<Integer, String> fizzBizzDict =
                new HashMap<Integer, String>() {
                    {
                        put(3, "Fizz");
                        put(5, "Buzz");
                    }
                };

        for (int num = 1; num <= n; num++) {

            String numAnsStr = "";

            //被3/5任何一个整除，只能添加一个映射值，同时被3/5整除，就会把两个值都拼接起来
            for (Integer key : fizzBizzDict.keySet()) {
                if (num % key == 0) {
                    numAnsStr += fizzBizzDict.get(key);
                }
            }
            //都不满足
            if (numAnsStr.equals("")) {
                numAnsStr += Integer.toString(num);
            }

            ans.add(numAnsStr);
        }

        return ans;
    }

}
