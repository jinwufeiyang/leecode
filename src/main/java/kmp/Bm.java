package kmp;

import java.util.Random;

/**
 * Description
 * b-m算法用于搜索匹配字符串，应用比较广泛的一种算法，各种文本编译器“查找”功能
 * DATE 2019/11/25.
 *
 * @author daijinwu.
 */
public class Bm {

    /**
     * 利用坏字符规则计算移动位数
     * @param moudleString 模式串
     * @param badChar 坏字符
     * @param badCharSuffix 坏字符所对应模式串发生不匹配时索引位置
     * @return 移动位数
     */
    private static int badCharacter(String moudleString, char badChar, int badCharSuffix) {
        /**
         * 计算该坏字符在模式串出现的最右位置，如果存在多个位置的时候，选择非最右位置可能会错失正确的匹配索引。
         * 模式串存在返回对应的索引下标，不存在则返回-1；
         */
        int index = moudleString.lastIndexOf(badChar, badCharSuffix);
        return badCharSuffix - index;
    }

    /**
     *
     * @param moduleString 模式串
     * @param goodCharSuffix 好字符后缀所对应模式串索引位置
     * @return 利用好后缀规则计算移动位数
     */
    private static int goodCharacter(String moduleString, int goodCharSuffix) {
        int result = -1;
        //模式串长度
        int moduleLength = moduleString.length();
        //好字符数
        int goodCharNum = moduleLength - 1 - goodCharSuffix;
        for (;goodCharNum > 0;goodCharNum--) {
            String endSection = moduleString.substring(moduleLength - goodCharNum, moduleLength);
            String startSection = moduleString.substring(0, goodCharNum);
            if (startSection.equals(endSection)) {
                result = moduleLength - goodCharNum;
            }
        }
        return result;
    }

    /**
     * BM匹配字符串
     * @param originString 主串
     * @param moduleString 模式串
     * @return 若匹配成功，返回下标，否则返回-1
     */
    private static int match(String originString, String moduleString) {
        // 主串
        if (originString == null || originString.length() <= 0){
            return  -1;
        }
        // 模式串
        if (moduleString == null || moduleString.length() <= 0) {
            return -1;
        }
        // 如果模式串的长度大于主串的长度，那么一定不匹配
        if (originString.length() < moduleString.length()) {
            return -1;
        }

        int moduleSuffix = moduleString.length() - 1;
        int moduleIndex = moduleSuffix;
        int originIndex = moduleSuffix;

        for (int ot = originIndex; originIndex < originString.length() && moduleIndex >= 0;) {
            char oc = originString.charAt(originIndex);
            char mc = moduleString.charAt(moduleIndex);
            /*
            当检查到第一个字符(索引为0)的时候满足相等，则会多减一次，所以当moduleIndex小于0的时候
            就需要在后面把多减的一次加回去。
             */
            if (oc == mc) {
                originIndex--;
                moduleIndex--;
            } else {
                // 坏字符规则
                int badMove = badCharacter(moduleString, oc, moduleIndex);
                // 好字符规则
                int goodMove = goodCharacter(moduleString, moduleIndex);
                // 下面两句代码可以这样理解，主串位置不动，模式串向右移动
                originIndex = ot + Math.max(badMove, goodMove);
                moduleIndex = moduleSuffix;
                // ot就是中间变量
                ot = originIndex;
            }
        }

        System.out.println("originIndex = " + originIndex + "\t moduleIndex = " + moduleIndex);
        if(moduleIndex < 0){
            // 多减了一次
            return originIndex + 1;
        }
        return -1;
    }

    /**
     * 随机生成字符串
     * @param length 表示生成字符串的长度
     * @return String
     */
    private static String generateString(int length) {
        String baseString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<length;i++) {
            result.append(baseString.charAt(random.nextInt(baseString.length())));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //主串
//        String originString = generateString(10);
        String originString = "HERE IS A SIMPLE EXAMPLE";
        //模式串
//        String moduleString = generateString(4);
        String moduleString = "EXAMPLE";


        System.out.println("主串：" + originString);
        System.out.println("模式串：" + moduleString);

        int index = match(originString, moduleString);
        System.out.println("匹配的下标：" + index);

    }

}
