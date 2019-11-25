package com.code.easy.code;

/**
 * Description
 * DATE 2019/2/28.
 *
 * @author daijinwu.
 */
public class addBinary {
    public static void main(String[] args) {
        String a = "1011";
        String b = "1010";
        String c = sumBinary(a,b);
        int d = 100;
        Math.sqrt((double)d);
        System.out.println(c);
    }

    private static String sumBinary(String a, String b) {
        int as = a.length()-1;
        int bs = b.length()-1;
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        while (as>=0&&bs>=0) {
            int temp = 0;
            if (flag) {
                int ta = Integer.parseInt(String.valueOf(a.charAt(as)));
                int tb = Integer.parseInt(String.valueOf(b.charAt(bs)));
                temp = ta + tb + 1;
            } else {
                int ta = Integer.parseInt(String.valueOf(a.charAt(as)));
                int tb = Integer.parseInt(String.valueOf(b.charAt(bs)));
                temp = ta + tb;
            }
            if (temp == 2) {
                sb.append(0);
                flag = true;
            } else if (temp >2) {
                sb.append(1);
                flag = true;
            } else {
                sb.append(temp);
                flag = false;
            }
            as--;
            bs--;
        }
        while (as>=0) {
            if (flag) {
                int tp = Integer.parseInt(String.valueOf(a.charAt(as))) + 1;
                if (tp>=2){
                    sb.append(0);
                    flag = true;
                }else {
                    sb.append(tp);
                    flag = false;
                }
            } else {
                sb.append(Integer.parseInt(String.valueOf(a.charAt(as))));
            }
            as--;
        }
        while (bs>=0){
            if (flag) {
                int tp = Integer.parseInt(String.valueOf(b.charAt(bs))) + 1;
                if (tp>=2){
                    sb.append(0);
                    flag = true;
                }else {
                    sb.append(tp);
                    flag = false;
                }
            } else {
                sb.append(Integer.parseInt(String.valueOf(b.charAt(bs))));
            }
            bs--;
        }
        if (flag) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
