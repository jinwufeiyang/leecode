package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: RemoveElements_203
 * @Description: 删除链表中等于给定值 val 的所有节点
 * @Author: JW
 * @Date: 2019/12/28 23:14
 */
public class RemoveElements_203 {

    /*
    思路：采用迭代方式，首先确定两个节点：当前节点以及当前节点的上一节点，如果当前节点的val与需移除的val相等时，将当前节点移除，
    即将上一节点的下一节点指向当前节点的下一节点，当前节点置为当前节点的下一节点，这里有种临界情况：头节点的val就为需要排除的val，
    此时便将头节点向后移动至下一节点即可。val不相等的情况，就将上一节点置为当前节点，当前节点的下一节点置为当前节点即可。最后，返回头节点。
     */
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

    /**
     * 方式2：可以采用添加一个虚拟头结点，来避开对头结点删除时的特殊处理
     *
     */
    public static ListNode removeElements2(ListNode head, int val) {
        ListNode p = new ListNode(-1);
        p.next = head;
        //因为要删除的可能是链表的第一个元素，所以用一个h节点来做处理
        //最后只要返回h的下一个节点即可
        ListNode h = p;
        //注意遍历的条件是p.next不为空
        while(p.next!=null) {
            //如果p的下一个节点的值==val
            //P就指向下下一个，这就删掉了指定的节点
            if(p.next.val==val) {
                p.next = p.next.next;
                //注意这里的continue
                //因为循环最后还有一个P=p.next，所以要跳过
                continue;
            }
            //不用continue用else的方式也是可以的
            p = p.next;
        }
        return h.next;
    }

}
