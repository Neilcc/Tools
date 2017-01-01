
others' solution:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
}


mine solution:

do it step by step
use while method
but im not quite sure why this recursive way is more efficent;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        ListNode p = null;
        while(p1 != null && p2 !=null ){
            if(p1.val < p2.val){
                if(head == null){
                    head = p1;
                    p = head;
                }else{
                    p.next = p1;
                    p = p1;
                }
                p1 = p1.next;
            }else{
                if(head == null){
                    head = p2;
                    p = head;
                }else{
                    p.next = p2;
                    p = p2;
                }
                p2 = p2.next;
            }
        }
        
        if(p1 == null){
            p.next = p2;
        }else{
            p.next = p1;
        }
        return head;
    }
}
