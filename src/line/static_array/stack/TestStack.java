package line.static_array.stack;

import line.static_array.queue.ArrayQueue;
import line.static_array.queue.LoopQueue;
import line.static_array.queue.Queue;

import java.util.Random;

public class TestStack {

    //测试队列运行 操作时间 秒
    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i=0;i<opCount;i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i =0; i<opCount;i++)
            stack.pop();

        long endTime = System.nanoTime();
        return (endTime-startTime) /1_000_000_000.0;
    }

    public static void main(String[] args) {
        int opCount = 1_0_000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double v = testStack(arrayStack, opCount);
        System.out.println("arrayStack, time"+v+" s");

        LinkedListStack<Integer> linkedListStack = new  LinkedListStack<>();
        double v1 = testStack(linkedListStack, opCount);
        System.out.println("linkedListStack, time"+v1+" s");


    }
}
