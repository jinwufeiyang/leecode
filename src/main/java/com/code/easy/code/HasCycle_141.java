package com.code.easy.code;

import java.util.HashSet;

/**
 * 是否是环形链表
 */
public class HasCycle_141 {
    /*
    哈希:可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
     */
    public boolean hasCycle(ListNode head) {
        HashSet set = new HashSet();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /*
    快慢指针
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while (fastNode != slowNode) {
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return true;
    }

}
