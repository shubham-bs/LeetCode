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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstCritical = -1;
        int prevCritical = -1;
        int minDistance = Integer.MAX_VALUE;
        
        ListNode prev = head;
        ListNode curr = head.next;
        int currentIndex = 1; 

        while (curr.next != null) {
            ListNode nextNode = curr.next;

            boolean isMaxima = curr.val > prev.val && curr.val > nextNode.val;
            boolean isMinima = curr.val < prev.val && curr.val < nextNode.val;

            if (isMaxima || isMinima) {
                if (firstCritical == -1) {
                    firstCritical = currentIndex;
                } else {
                    minDistance = Math.min(minDistance, currentIndex - prevCritical);
                }
                prevCritical = currentIndex;
            }

            prev = curr;
            curr = nextNode;
            currentIndex++;
        }

        if (firstCritical == prevCritical) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevCritical - firstCritical;

        return new int[]{minDistance, maxDistance};
    }
}
