package org.algos.ic;

import org.junit.Test;

import static org.junit.Assert.*;


public class DoesLinkedListHaveCycle {

    public static void main(String[] args) {

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


    public static class LinkedListNode {

        public int            value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static boolean containsCycle(LinkedListNode firstNode) {

        // check if the linked list contains a cycle
        if (firstNode == null)
            return false;

        int landMark = firstNode.value;
        LinkedListNode next = firstNode.next;

        while (next != null) {

            int val = next.value;
            if (landMark == val) {
                break;
            }
            next = next.next;
        }

        return false;
    }

    @Test
    public void twoNodeCycleAtEndTest() {
        final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] {1, 2, 3, 4, 5});
        nodes[4].next = nodes[3];
        final boolean result = containsCycle(nodes[0]);
        assertTrue(result);
    }


}
