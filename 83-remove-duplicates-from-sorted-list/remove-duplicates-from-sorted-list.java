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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode curr1 = head;
        ListNode curr2 = head.next;

        while(curr2 != null){
            if(curr1.val == curr2.val){
                curr1.next = curr2.next;
                curr2 = curr2.next;
            }else{
                curr1 = curr2;
                curr2 = curr2.next;
            }
        }

        return head;
        
    }
}