package com.zcc.puzzle.problems;

import com.zcc.puzzle.problems.AddTwoNumbers.ListNode;

public class PLinkedList {
    public static void main(String[] args) {
        PLinkedList linkedList = new PLinkedList();
        AddTwoNumbers.ListNode h = new AddTwoNumbers.ListNode(1);
        AddTwoNumbers.ListNode p = new AddTwoNumbers.ListNode(2);
        h.next = p;
        p.next = new AddTwoNumbers.ListNode(2);
        p.next = new AddTwoNumbers.ListNode(2);
        p = p.next;
        p.next = new AddTwoNumbers.ListNode(1);
        linkedList.isPalindrome(h);
    }

    public boolean isPalindrome(ListNode head) {
        int i = 0;
        ListNode p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        if (i < 2) return true;
        int sec = 0;
        if (i % 2 == 1) {
            int mid = i / 2 + 1;
            sec = mid + 1;
        } else {
            sec = i / 2 + 1;
        }
        ListNode p2 = null;
        p = head;
        i = 0;
        while (p != null) {
            i++;
            if (i == sec - 1) {
                p2 = p.next;
                p.next = null;
                break;
            }
            p = p.next;
        }
        if (p2.next == null) {
            return head.val == p2.val;
        }
        p2 = reverse(p2);
        p = head;
        while (p != null && p2 != null) {
            if (p.val != p2.val) {
                return false;
            }
            p = p.next;
            p2 = p2.next;
        }
        return p == null && p2 == null;
    }

    public ListNode reverse(ListNode p) {
        ListNode h = p;
        ListNode pp = p.next;
        h.next = null;
        while (pp != null) {
            ListNode t = pp.next;
            pp.next = h;
            h = pp;
            pp = t;
        }
        return h;
    }
}
