package org.algos.ic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class QueueTwoStacks {

    public static void main(String[] args) {

        QueueWithTwoStacks obj = new QueueWithTwoStacks();
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);

        System.out.println("Dequeue result -> "+ obj.deQueue());
    }

    static class QueueWithTwoStacks{

        Deque<Integer> inStack  = new ArrayDeque<>();
        Deque<Integer> outStack = new ArrayDeque<>();


        public void enQueue(int data){

            inStack.push(data);
        }


        public int deQueue(){

            if(outStack.isEmpty()){

                while(!inStack.isEmpty()){

                    int val = inStack.pop();
                    outStack.push(val);
                }
                if(outStack.isEmpty()){
                    throw new NoSuchElementException("Can't deque from empty queue!");
                }
            }

            return outStack.pop();

        }


    }


}
