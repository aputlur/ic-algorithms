package org.algos.ic;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListCycle {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static boolean containsCycle(LinkedListNode firstNode) {

        LinkedListNode slowRunner = firstNode;
        LinkedListNode fastRunner = firstNode;

        //1, 2, 3, 4
        while(fastRunner!=null && fastRunner.next!=null && fastRunner.next.next.next!=null){

            slowRunner = slowRunner.next;
            System.out.println("slow-runner -> "+ slowRunner.value +" ");
           int fastRunnerStep =  fastRunner.next.next.next!=null ? fastRunner.next.next.next.value : fastRunner.next.next.next.value;

            fastRunner = fastRunner.next.next.next;
            System.out.println("fast-runner -> "+ fastRunnerStep +" ");

            if(slowRunner == fastRunner) {
                System.out.println("print..");
                return true;

            }
        }
        return false;
    }


    @Test
    public void cycleLoopsToBeginningTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        nodes[3].next = nodes[0];
        final boolean result = containsCycle(nodes[0]);
        assertTrue(result);
    }

    @Test
    public void noCycleToBeginningTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4});
        final boolean result = containsCycle(nodes[0]);
        assertFalse(result);
    }


    private static LinkedListNode[] valuesToLinkedListNodes(int[] values) {
        final LinkedListNode[] nodes = new LinkedListNode[values.length];
        for (int i = 0; i < values.length; ++i) {
            nodes[i] = new LinkedListNode(values[i]);
            if (i > 0) {
                nodes [i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

}
