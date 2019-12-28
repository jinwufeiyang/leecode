package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: TrailingZeroes_172
 * @Description: 给定一个整数 n，返回 n! 结果尾数中零的数量
 * @Author: JW
 * @Date: 2019/12/28 11:54
 */
public class TrailingZeroes_172 {

    /*
    思路：末尾有多少个0，只需要给当前数乘以一个10，就可以加一个0.。10可以分解为2*5，其实题目就可以理解为能够找到多少对2*5。。
    对于每个含有5因子的数，前面一定会出现2因子，所以题目就可以等价于阶乘中可以找到多少个5，即n/5。
    但是要考虑到这只找到了n中是5倍数的所有数，例如25，即在25!中找到了5个是5的倍数的数分别为5,10,15,20,25，
    要注意这之中的25依然可以分解为5的倍数，因此n//5其实是少计入了一部分情况的。
    要对接下来的这部分情况进行统计，我们可以对n取25的商，即n//25，这样就找到了包含有2个5的数（且因为是对5×5取商，没有重复计入），
    依此类推，可以循环对n取5, 25, 125...的商，将所有的情况都包括，最终将所有的商汇总即0的个数。
     */

    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i=0;i<=n;i++) {
            while (n>=5) {
                count += n/5;
                n=n/5;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(50));
    }
}
