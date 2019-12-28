package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: RemoveElements_203
 * @Description: 删除链表中等于给定值 val 的所有节点
 * @Author: JW
 * @Date: 2019/12/28 23:14
 */
public class RemoveElements_203 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            if (curr.val == val) {
                if (pre == null) {
                    curr = curr.next;
                    head = curr;
                } else {
                    //待移除节点不是头结点
                    pre.next = curr.next;
                    curr = curr.next;
                }
            } else {
                //当前节点不是待移除的节点
                pre = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
