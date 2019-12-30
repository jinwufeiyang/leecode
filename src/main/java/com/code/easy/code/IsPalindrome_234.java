package com.code.easy.code;

import java.util.ArrayList;

/**
 * 回文链表
 * 判断一个链表是否为回文链表
 */
public class IsPalindrome_234 {

    /*
    利用数组实现：
    转化数组，然后头尾指针双向遍历比较，如果头尾指针不相等，那么当前链表就不是回文链表
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i<j) {
            if (list.get(i).compareTo(list.get(j))!=0) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome(new ListNode());
    }

    /**
     * 1：找到链表的中间节点  2：反转链表
     * 通过两个操作之后，原链表就以中间节点一分为二，前部分一个链表，后半部分（被反转）一个链表，遍历两个链表进行比对即可。
     * @param head head
     * @return 是否
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode p = new ListNode(-1);
        ListNode fast = p;
        ListNode low = p;
        p.next = head;
        //快慢指针不断迭代，找到中间节点
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        low.next = null;
        low = p.next;

        ListNode pre = null;
        ListNode cur = low.next;
        //将链表一分为二之后，反转链表后半部分
        while(cur!=null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        //将链表前半部分和 反转的后半部分对比
        while(pre!=null) {
            if(low.val!=pre.val) {
                return false;
            }
            low = low.next;
            pre = pre.next;
        }
        return true;
    }

}
