/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;

        while(curr != null){
            length++;
            curr = curr.next;
        }

        int m = length - n ;
        curr = head;

        if(m == 0){
            return head.next;
        }
        while(m > 1){
            curr = curr.next;
            m--;
        }
        curr.next = curr.next.next;

        return head;
    }
}