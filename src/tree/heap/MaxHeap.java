package tree.heap;

import line.static_array.array.Array;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }


    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int k){
        //不能是根节点
        while(k >0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            //位置交换
            data.swap(k,parent(k));
            k= parent(k);
        }
    }

    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("heap is empty");
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax(){
        E ret = findMax();
        //交换元素
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }


    private void siftDown(int k){

        while(leftChild(k) < data.getSize()){
            int j = leftChild(k);

            if(j+1 < data.getSize()
                    && data.get(j+1).compareTo(data.get(j))>0){
                j = rightChild(k);
                //data[j]是leftChild 和rightChild中的最大值
            }
            if(data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k,j);
            k = j;
        }
    }

    // 取出最大元素后，放入一个新元素 O(logn))
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    //将任意数组整理成堆的形状 O(n)
    //最后一个非叶子节点
    //最后一个节点的父节点
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length -1);i >=0;i--)
            siftDown(i);
    }

    //返回完全二叉树的数组中，一个索引所表示的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index-1)/2;
    }

    //左节点
    private int leftChild(int index){
        return index*2 +1;
    }

    //右节点
    private int rightChild(int index){
        return index*2 +2;
    }

    public static void main(String[] args) {
        int n = 1_000_000;
        MaxHeap<Integer> integerMaxHeap = new MaxHeap<>();
        Random random = new Random();

        for(int i = 0;i<n;i++)
            integerMaxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];

        for(int i = 0; i<n;i++)
            arr[i] = integerMaxHeap.extractMax();

        for(int i =1;i<n;i++)
            if(arr[i-1] < arr[i])
                throw new RuntimeException("ddd");
    }

}
