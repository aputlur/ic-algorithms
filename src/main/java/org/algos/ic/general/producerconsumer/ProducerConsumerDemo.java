package org.algos.ic.general.producerconsumer;

import java.util.LinkedList;

public class ProducerConsumerDemo {

    public static void main(String[] args) throws InterruptedException {

        ProducerAndConsumer pc = new ProducerAndConsumer();
        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {

            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        //join
        t1.join();
        t2.join();

    }

    static class ProducerAndConsumer {

        private LinkedList<Integer> linkedList = new LinkedList<>();
        private int                 capacity   = 3;
        private int                 value      = 1;

        public void produce() throws InterruptedException {

            while (true) {

                synchronized (this) {

                    if (linkedList.size() == capacity) {
                        wait();
                    }
                    value++;
                    System.out.println("Producer Thread, adding value -> "+ value);
                    linkedList.add(value);
                    notify();

                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {

                synchronized (this) {

                    if (linkedList.size() == 0)
                        wait();

                    Integer value = linkedList.removeFirst();
                    System.out.println("Consumer Thread: value ==> " + value);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

    }
}
