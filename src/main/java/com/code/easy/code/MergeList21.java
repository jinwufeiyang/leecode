package com.code.easy.code;

/**
 * Description
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * DATE 2019/10/24.
 *
 * @author daijinwu.
 */
public class MergeList21 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode l1 = listNode1;
        l1 = (l1.next  = new ListNode(2));
        l1.next = new ListNode(4);
        dy(listNode1);
        ListNode listNode11 = new ListNode(1);
        ListNode l2 = listNode11;
        l2 = (l2.next  = new ListNode(2));
        l2.next = new ListNode(3);
        dy(listNode11);
        ListNode node = mergeTwoLists(listNode1, listNode11);
        System.out.println("-------");
        dy(node);
    }

    private static void dy(ListNode listNode1) {
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(-1);
        ListNode currentNode = result;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                currentNode.setVal(l2.getVal());
                currentNode.setNext(l2);
                l2 = l2.getNext();
            } else {
                currentNode.setVal(l1.getVal());
                currentNode.setNext(l1);
                l1 = l1.getNext();
            }
            currentNode = currentNode.getNext();
        }
        ListNode node = (l1 != null) ? l1 : l2;
        currentNode.setVal(node.getVal());
        currentNode.setNext(node.next);
        return result;
    }

    public static class ListNode {
        private int val;
        private ListNode next;
        private ListNode(int value) {
            this.val = value;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }
    }

}
