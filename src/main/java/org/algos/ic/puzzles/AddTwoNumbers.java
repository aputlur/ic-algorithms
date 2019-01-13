package org.algos.ic.puzzles;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode listNode1_1  = new ListNode(2);
        ListNode listNode1_2  = new ListNode(4);
        ListNode listNode1_3  = new ListNode(3);

        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;

        ListNode listNode2_1  = new ListNode(5);
        ListNode listNode2_2  = new ListNode(6);
        ListNode listNode2_3  = new ListNode(4);

        listNode2_1.next = listNode2_2;
        listNode2_2.next = listNode2_3;

       ListNode result =  addTwoNumbers(listNode1_1, listNode2_1);
       print(result);

    }

    private static void print(ListNode result) {
        while(result != null){

            int val = result.val;
            System.out.println("val -> "+ val);
            result = result.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 2 -> 4 -> 3
        // 5 -> 6 -> 4
        // 2 + 5 = 7 ==>7/10 = 0 ; 7%10 = 0;
        // 4 + 6 = 10 ==> 10/10 = 1; 10%10 = 0; carryOver = 1

        ListNode pointer1 = l1;
        ListNode pointer2 = l2;

        ListNode result = new ListNode(0);
        ListNode resultPointer = result;

        int sum = 0;
        int digit = 0;
        int carryover = 0;

        while(pointer1!=null || pointer2!=null || carryover!=0){

            resultPointer.next = new ListNode(0);
            resultPointer = resultPointer.next;

            sum = 0;
            if(pointer1!=null){
                sum+= pointer1.val;
                pointer1 = pointer1.next;
            }

            if(pointer2!=null){
                sum+= pointer2.val;
                pointer2 = pointer2.next;
            }

            if(carryover!=0) sum+= carryover;

            digit = sum % 10;
            carryover = sum / 10;

            System.out.println("Digit -> "+ digit);

            resultPointer.val = digit;


        }
        return result.next;
    }

    static class ListNode{

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

}
