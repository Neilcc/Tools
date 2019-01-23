package com.zcc.puzzle.problems;

import com.zcc.puzzle.problems.AddTwoNumbers.ListNode;

public class LinkListPartialReverse {
    public static void main(String[] args) {
        LinkListPartialReverse linkListPartialReverse = new LinkListPartialReverse();
        ListNode head = new ListNode(1);
        ListNode pp = head;
        pp.next = new ListNode(4);
//        for (int i = 2; i < 6; i++) {
//            pp.next = new ListNode(i);
//            pp = pp.next;
//        }
        linkListPartialReverse.reverseBetween(head, 2, 2);
        new String("123");
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode rH = null;
        ListNode p = head;
        ListNode rL = null;
        ListNode nextP;
        for (int i = 1; ; i++) {
            if (p == null) {
                break;
            }
            if (i == m - 1) {
                rH = p;
                rL = p.next;
                p = p.next.next;
                continue;
            }
            if (i >= m && i <= n) {
                nextP = p.next;
                if(rH != null){
                    p.next = rH.next;
                    rH.next = p;
                }else {
                    if(p != head){
                        p.next = head;
                        head = p;
                    } else {
                        rL = p;
                    }
                }
                p = nextP;
            } else if (i < m) {
                p = p.next;
            } else if (i == n + 1) {
                rL.next = p;
                break;
            }
        }
        return head;
    }
}
