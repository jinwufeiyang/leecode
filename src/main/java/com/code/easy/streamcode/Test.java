package com.code.easy.streamcode;

/**
 * Description
 * DATE 2019/10/21.
 *
 * @author daijinwu.
 */
public class Test {
    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer integer = converter.covert("123");
        System.out.println("integer = " + integer);
    }
}
