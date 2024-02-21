package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        ListNode l1 = new ListNode(2);  ListNode l11 = new ListNode(4); l1.next(l11); ListNode l12 = new ListNode(9); l11.next(l12);
        ListNode l2 = new ListNode(5);  ListNode l21 = new ListNode(6); l2.next(l21); ListNode l22 = new ListNode(4); l21.next(l22); ListNode l23 = new ListNode(9); l22.next(l23);
        ListNode solution = main.addTwoNumbers(l1, l2);
        System.out.println(solution);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        int sum = 0;
        ListNode answer = null;
        ListNode prev = null;
        int kalan = 0;
        while(first != null || second != null) {
            int firstValue = first == null ? 0 : first.val;
            int secondValue = second == null ? 0 : second.val;
            ListNode newListNode = new ListNode((firstValue + secondValue + kalan)%10);
            if((firstValue + secondValue + kalan) >= 10)
                kalan = 1;
            else
                kalan = 0;
            if(prev != null)
                prev.next = newListNode;
            if(answer == null)
                answer = newListNode;
            prev = newListNode;
            if(first != null)
                first = first.next;
            if(second != null)
                second = second.next;
        }

        if(kalan==1) {
            ListNode newListNode = new ListNode(1);
            prev.next = newListNode;
        }
        return answer;
    }
}
