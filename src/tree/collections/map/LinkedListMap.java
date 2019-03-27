package tree.collections.map;

import tree.FileOperation;

import java.util.ArrayList;

public class LinkedListMap<K ,V> implements Map<K,V> {

    private int size;

    private Node dummyNode;

    private class Node{
        private K key;
        private V value;
        private Node next;

        public Node(K key,V value,Node next){
            this.key =key;
            this.value = value;
            this.next = next;

        }

        public Node(){
            this(null,null,null);
        }
        public Node(K key){
            this(key,null,null);
        }

        @Override
        public String toString() {
            return
                    "key=" + key.toString() +
                    " : value=" + value.toString()

                    ;
        }
    }


    public LinkedListMap(){

            dummyNode = new Node();
            size = 0;

    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if(node == null){
            dummyNode.next = new Node(k,v,dummyNode.next);
            size ++;
        }else
            node.value = v;

    }

    @Override
    public V remove(K key) {
        Node prev = dummyNode;
        while(prev.next != null){
            if(prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ?null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException(key+ " doesn't exist!");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private Node getNode(K key){
        Node cur = dummyNode.next;
        while(cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("G:\\data-structures\\src\\pride-and-prejudice.txt",words);
        System.out.println("Total words "+words.size());
        LinkedListMap<String,Integer> map = new LinkedListMap<>();
        for(String word:words){
            if(map.contains(word)){
                map.set(word,map.get(word)+1);
            }else
                map.add(word,1);
        }

        System.out.println("pride : "+map.getNode("pride"));
    }


}
