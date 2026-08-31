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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int length = 0;
        ListNode tem = head;
        while(tem != null){
            tem = tem.next;
            length++;
        }

        k = k % length;
        for(int i = 1;i<=k ; i++){
            
        ListNode temp = head;
        ListNode prev = head;
        while(prev.next != null && prev.next.next != null){
            prev = prev.next;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        prev.next = null;
        head = temp;
        
        }
        return head;

    }
}