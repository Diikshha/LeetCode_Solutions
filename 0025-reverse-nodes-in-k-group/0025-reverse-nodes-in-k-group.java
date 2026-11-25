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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode groupPrev=dummy;
        dummy.next=head;
        while(true){
            ListNode knode = findKNode(groupPrev, k);
            if(knode==null){
                break;
            }
            ListNode groupNext = knode.next;
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while(curr!=groupNext){
                ListNode temp = curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next=knode;
            groupPrev=temp;
        }
        return dummy.next;
    }
    private ListNode findKNode(ListNode curr, int k){
        while(k>0 && curr!=null){
            curr=curr.next;
            k--;
        }
        return curr;
    }
}