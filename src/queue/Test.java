package queue;

import java.util.Random;

public class Test {
    //测试队列运行 操作时间 秒
    private static double testQueue(Queue<Integer> queue,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i=0;i<opCount;i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i =0; i<opCount;i++)
            queue.dequeue();

        long endTime = System.nanoTime();
        return (endTime-startTime) /1_000_000_000.0;
    }

    public static void main(String[] args) {
        int opCount = 1_00_000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double v = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time"+v+" s");

       LoopQueue<Integer>  loopQueue = new  LoopQueue<>();
        double v1 = testQueue(arrayQueue, opCount);
        System.out.println("loopQueue, time"+v1+" s");


    }
}
