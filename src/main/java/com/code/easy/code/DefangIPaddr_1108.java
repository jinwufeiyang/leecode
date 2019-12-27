package com.code.easy.code;

/**
 * 好像是没啥意义
 */
public class DefangIPaddr_1108 {

    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }
}
