package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: DeleteNode_237
 * @Description: 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点
 * @Author: JW
 * @Date: 2019/12/30 22:39
 */
public class DeleteNode_237 {
    /**
     * 当前节点即为要删除的节点，，，
     * @param node node
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
