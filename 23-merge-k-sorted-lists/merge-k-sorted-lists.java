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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode l: lists){
            if(l != null){
                minHeap.offer(l);
            }
        }

        ListNode ans = new ListNode(0);
        ListNode curr = ans;

        while(!minHeap.isEmpty()){
            ListNode dummy = minHeap.poll();
            curr.next = dummy;
            curr = curr.next;
            if(dummy.next != null){
                minHeap.offer(dummy.next);
            }
        }

        return ans.next;
    }
}