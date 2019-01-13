package org.algos.ic.leetcode;

import java.util.List;

public class LinkedListDuplicates {

    public static void main(String[] args) {

         ListNode root = new ListNode(1);
         ListNode next = new ListNode(2);
         ListNode nextNext = new ListNode(2);
         next.next = nextNext;
         root.next = next;

         ListNode result = removeDuplicates(root);

         while(result!=null){
             System.out.print(result.val + "->");
             result = result.next;
         }
    }

   static class ListNode {

        int      val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode removeDuplicates(ListNode head) {

        //return head if given input is null or empty

        if (head == null)
            return head;

        // Initialize result node
        ListNode result = new ListNode(0);

        // Assuming that, if LinkedList has no duplicates
        result.next = head;

        //Iterate curr and next values.
        ListNode curr = result;
        ListNode next = result.next;

        boolean isDupFound = false;
        while (next != null) {

            //if next value is same as curr value. don't update current
            if (next.next != null && next.val == next.next.val) {
                isDupFound = true;
            }
            else if(isDupFound){
                curr.next = next.next;
                isDupFound = false;
            }
            else {
                curr = curr.next;
            }
            next = next.next;

        }
        return result.next;
    }

}
