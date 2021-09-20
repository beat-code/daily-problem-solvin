package leetcode_top_interview;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //      1 <- 2 <- 3 <- 4
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseListIterative(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode next = head.next;
        ListNode prev = null;
        ListNode ptr = head;
        while(ptr.next != null){
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            next = ptr.next;
        }
        ptr.next = prev;
        return ptr;
    }
}
