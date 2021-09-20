package leetcode.dec_2020;

public class _24SwapNodesInPairs {
    private static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode first = head;
        ListNode second = first.next;

        ListNode ptr = head;
        head = second;
        ListNode prev = new ListNode();
        while(ptr != null && ptr.next != null){
            ptr = second.next;
            second.next = first;
            first.next = ptr;
            prev.next = second;
            prev = first;

            first = ptr;
            if(first != null) second = ptr.next;
        }
        return head;
    }
}
