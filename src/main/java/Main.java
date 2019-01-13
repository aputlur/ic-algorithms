import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

class Main {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode node = removeDuplicates(head);

        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode removeDuplicates(ListNode head){

        if(head == null) return head;

        ListNode result = new ListNode(0);

        result.next = head;

        ListNode curr = result;
        ListNode next = result.next;

        boolean isDupFound = false;
        while(next!=null){

            if(next.next!=null && next.val == next.next.val){
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

    static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }




}


