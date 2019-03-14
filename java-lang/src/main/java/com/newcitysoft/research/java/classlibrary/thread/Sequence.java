package com.newcitysoft.research.java.classlibrary.thread;

public class Sequence {

    private int value;

    private synchronized int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
//
//        for(int i = 0; i < 10; i++) {
//            sequence.getNext();
//        }
//
//        System.out.println(sequence.value);
//        Thread thread1 = () -> {
//            while (true) {
//                sequence.getNext();
//            }
//        };

        Thread thread1 = new Thread(()-> {
            while (true) {
                System.out.println(sequence.getNext());
                 try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(()-> {
            while (true) {
                System.out.println(sequence.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(()-> {
            while (true) {
                System.out.println(sequence.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
