package com.zcc.puzzle.problems;

public class ReverseLinkedList {
    public static AddTwoNumbers.ListNode reverse(AddTwoNumbers.ListNode p) {
        AddTwoNumbers.ListNode h = p;
        AddTwoNumbers.ListNode pp = p.next;
        h.next = null;
        while (pp != null) {
            AddTwoNumbers.ListNode t = pp.next;
            pp.next = h;
            h = pp;
            pp = t;
        }
        return h;
    }

    public static void main(String[] args) {
        AddTwoNumbers.ListNode h = new AddTwoNumbers.ListNode(1);
        AddTwoNumbers.ListNode p = new AddTwoNumbers.ListNode(2);
        h.next = p;
        p.next = new AddTwoNumbers.ListNode(3);
        p = p.next;
        p.next = new AddTwoNumbers.ListNode(4);
        h = reverse(h);
        while (h != null) {
            System.out.print(h.val);
            System.out.print("\n");
            h = h.next;
        }

    }
}
