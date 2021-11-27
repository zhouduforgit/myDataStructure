package linkedlist;

/**
 *  https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class MergeTwoLists {
    /**
    * 思路1 ：比较2个升序链表头结点【l1.val和l2.val比较】
     * 把较小的移动到新的链表尾巴里（可以理解成删除一个结点，被删除的头结点的链表头指针向后移）
     * 刷新新链表的尾巴
     * while循环 当l1,l2的下一个节点不是空时一直比较。
     *
     *  */
    public static ListNode mergeTwoList(ListNode l1, ListNode l2){
        // 新建一个新的链表 存储合并后大的升序链表
        ListNode mergeListNode = new ListNode(); //新链表的头结点
        ListNode last = mergeListNode; //新链表的尾节点
        while (l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                last.next = l2; // l2删除头结点 ，l2的头结点移动到新链表mergeListNode的下一个
                l2 = l2.next; // l2 头结点指针向后移
            } else {
                last.next = l1;
                l1 = l1.next;
            }
            last = last.next; // 新链表尾节点向后移
        }
        if (l1 != null) { //若while循环结束后，l1的头指针还没有指向最后一个结点
            last.next = l1; // 把l1的剩下部分放在新链表尾部
        }
        if(l2 != null) {
            last.next = l2;
        }
        return mergeListNode.next;
    }
}
