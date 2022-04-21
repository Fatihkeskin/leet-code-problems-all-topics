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
        ListNode tempHead = head;
        
        int size = 0;
        while (tempHead != null) {
            tempHead = tempHead.next;
            size++;
        }
        
        int indexOfElementToBeRemoved = size - n;
        tempHead = head;
        
        if (indexOfElementToBeRemoved == 0)
            return tempHead.next;

        ListNode nextNode;
        for (int i = 0; i < indexOfElementToBeRemoved-1; i++) {
            tempHead = tempHead.next;
        }
        
        
        tempHead.next = tempHead.next.next;
        
        return head;
    }   
}