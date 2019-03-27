package tree.collections.map;

import tree.FileOperation;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }


    @Override
    public void add(K k, V v) {
       root = add(root,k,v);
    }

    private Node add(Node node,K key,V value){
        if (node == null) {
            size++;
            return new Node(key,value);
        }
        //小问题
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key,value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key,value);
        else
            node.value = value;
        return node;
    }

    private Node getNode(Node node,K key){
        if(node == null)
            return null;
        if(key.compareTo(node.key) <0)
            return getNode(node.left,key);
        else if(key.compareTo(node.key) > 0)
            return getNode(node.right,key);
        else
            return node;
    }

    @Override
    public V remove(K k) {
        Node node = getNode(root,k);
        if(node != null){
            root = remove(root,k);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node,K k){
        if(node == null)
            return null;
        if(k.compareTo(node.key) <0){
            node.left = remove(node.left,k);
            return node;
        }else if(k.compareTo(node.key) >0){
            node.right = remove(node.right,k);
            return node;
        }else{
            // e ==node.e
            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node nodeRight =node.right;
                node.right = null;
                size --;
                return nodeRight;
            }
            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node nodeLeft = node.left;
                node.left = null;
                size --;
                return nodeLeft;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            //size ++;  取消
            successor.left = node.left;
            node.left = node.right = null;
            //size --;
            return successor;
        }

    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K k) {
        return getNode(root,k) != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(root,k);
        return node == null ?null:node.value;
    }

    @Override
    public void set(K k, V newValue) {
        Node node = getNode(root,k);
        if(node == null)
            throw new IllegalArgumentException(k+" key does'nt exist");
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

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("G:\\data-structures\\src\\pride-and-prejudice.txt ", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
