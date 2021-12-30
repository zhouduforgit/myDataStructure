package stack;

public class MinStack2 {
    private ListNode head;

    //压栈，需要判断栈是否为空
    public void push(int x) {
            head = new ListNode(x, Math.min(x, head.min), head);
    }


}
