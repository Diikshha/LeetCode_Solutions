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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );
        for(int i=0;i<lists.length;i++){
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode temp=dummyNode;
        while(!pq.isEmpty()){
            ListNode it = pq.poll();
            if (it.next != null) {
                pq.add(it.next);
            }
            temp.next = it;
            temp = temp.next;
        }
        return dummyNode.next;
    }
}