package com.code.easy.code;

import java.util.Stack;

/**
 * 反转链表
 */
public class ReserveStr {

    /**
     * 栈解：
     * 这方法比较挫
     * @param head 头结点
     * @return 链表
     */
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode pre = head;
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
//        return createNodeList(stack);
        return createNodeList2(stack, pre);
    }

    /*
    复用原来链表
     */
    private ListNode createNodeList2(Stack<Integer> stack, ListNode head) {
        ListNode returnNode = head;
        while (!stack.isEmpty()) {
            head.val = stack.pop();
            head = head.next;
        }
        return returnNode;
    }

    /*
    重新构造链表
     */
    private ListNode createNodeList(Stack<Integer> stack) {
        ListNode head = null;
        ListNode currentNode = null;
        boolean flag = true;
        while (!stack.isEmpty()) {
            if (flag) {
                head = new ListNode(stack.pop());
                currentNode = head;
                flag = false;
                continue;
            }
            ListNode node = new ListNode(stack.pop());
            currentNode.next = node;
            currentNode = node;
        }
        return head;
    }

    public static void main(String[] args) {
    }

    /*
    双指针迭代：
    遍历列表时候，将当前结点的next指针指向前一个元素。由于节点没有引用上一个节点，因为必须事先存储前一个元素。
    在更改引用前，还需要另一个指针存储下一个节点。。。最后返回新的头结点。
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode temp = null;
        while (current != null) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    /*
    递归实现
    递归的两个条件：
        终止条件是当前节点或者下一个节点==null
        在函数内部，改变节点的指向，也就是head的下一个节点指向head 递归函数那句
        head.next.next = head;


     简单理解就是 当前节点的下一个节点指向当前节点
     递归函数中每次返回的cur其实是最后一个节点，在递归函数内部，改变的是当前节点的指向
     */
    public ListNode reverseList3(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList3(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }


}
