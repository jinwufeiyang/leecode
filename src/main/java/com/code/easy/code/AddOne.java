package com.code.easy.code;

/**
 * Description
 * DATE 2019/2/27.
 *
 * @author daijinwu.
 */
public class AddOne {

    public static void main(String[] args) {
        int[] date = {9};
        int[] result = addOne(date);
        for (int i=0;i<result.length;i++){
            System.out.print(result[i]);
        }
    }

    private static int[] addOne(int[] digits) {

        int length = digits.length;
        boolean newLength = false;
        boolean t = false;
        int count = 0;
        for (int j=length-1;j>=0;j--){
            if (j==length-1&&digits[j]+1>9){
                t = true;
                count++;
            }else {
                if (t){
                    if (digits[j]+1>9){
                        t = true;
                        count++;
                    }
                }else {
                    t=false;
                    break;
                }
            }
        }

        if (count==length){
            newLength = true;
        }

        int[] newArray = new int[length+1];
        if (newLength) {
            for (int z=0;z<digits.length;z++) {
                newArray[z+1] = digits[z];
            }
        }

        if (newLength){
            boolean flag = false;
            for (int i=newArray.length-1;i>=0;i--) {
                int temp = newArray[i];
                if (temp+1>9){
                    flag = true;
                    newArray[i] = 0;
                }else {
                    newArray[i] = temp+1;
                    break;
                }
            }
            return newArray;
        }else {
            boolean flag = false;
            for (int i=length-1;i>=0;i--) {
                int temp = digits[i];
                if (temp+1>9){
                    flag = true;
                    digits[i] = 0;
                }else {
                    digits[i] = temp+1;
                    break;
                }
            }
            return digits;
        }
    }
}
