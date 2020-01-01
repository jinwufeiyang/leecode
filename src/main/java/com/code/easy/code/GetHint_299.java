package com.code.easy.code;

import java.util.*;

/**
 * @version v1.0
 * @ClassName: GetHint_299
 * @Description: 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，
 * 告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 * @Author: JW
 * @Date: 2020/1/1 16:24
 */
public class GetHint_299 {
    public static String getHint(String secret, String guess) {
        int aCount = 0;
        StringBuilder sb = new StringBuilder();
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int[] sList = new int[10];
        int[] gList = new int[10];
        for (int i=0;i<secret.length();i++) {
            if (s[i] == g[i]) {
                aCount++;
            } else {
                //以当前字符作为数组下标，方便统计奶牛数量
                sList[s[i]-'0']++;
                gList[g[i]-'0']++;
            }
        }
        int bCount = 0;
        for(int i=0; i<10; i++){
            if(sList[i] > 0 && gList[i] > 0)
                bCount += Math.min(sList[i], gList[i]);
        }
        sb.append(aCount + "A");
        sb.append(bCount + "B");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getHint2("1123", "0111"));
    }

    public static String getHint2(String secret, String guess) {
        int bull = 0,cow = 0;
        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();

        List<Character> secretList = new ArrayList<>();
        List<Character> guessList = new ArrayList<>();

        for (int i = 0; i < secretArray.length; i++) {

            if (secretArray[i] == guessArray[i]){
                bull++;
            }else {
                secretList.add(secretArray[i]);
                guessList.add(guessArray[i]);
            }
        }

        for (Character character : guessList) {
            if (secretList.contains(character)){
                cow++;
                secretList.remove(character);
            }
        }
        return bull+"A"+cow+"B";
    }


}
