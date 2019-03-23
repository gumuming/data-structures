package line.dynamic_array.link;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyHead;


    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }


    //在指定位置插入元素 key 找到添加节点的前一个节点 注意头节点
    //
    public void add(int index,E e){
        if(index <0 || index >size)
            throw new IllegalArgumentException("Add failed,illegal index");

 /*       if(index == 0)
            addFirst(e);
        else{
            Node prev = head;
            for(int i = 0;i<index -1;i++)
                prev = prev.next;
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next= new Node(e,prev.next);
            size ++;
        }*/

        //引入虚拟头节点--->
        Node prev = dummyHead;
        for(int i =0;i < index;i++)
            prev = prev.next;
        prev.next= new Node(e,prev.next);
        size ++;
    }

    //在链表头添加元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next=head;
//        head = node;
/*        head = new Node(e,head);
        size ++;*/
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index <0 || index >size)
            throw new IllegalArgumentException("Add failed,illegal index");
        //遍历链表 找到当前节点
        Node cur = dummyHead.next;
        for(int i =0;i<index;i++)
            cur= cur.next;
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    //更新指定位置的元素
    public void set(int index,E e){
        if(index <0 || index >size)
            throw new IllegalArgumentException("Add failed,illegal index");
        Node cur = dummyHead.next;
        for(int i =0;i<index;i++)
            cur= cur.next;
        cur.e = e;
    }

    //判断链表是否含有元素
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e == e)
                return true;
            cur = cur.next;
        }
        return false;
    }

    //删除元素
    public E remove(int index){
        if(index <0 || index >size)
            throw new IllegalArgumentException("Add failed,illegal index");
        Node prev = dummyHead;
        for(int i =0;i<index;i++)
            prev = prev.next;
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
 //       Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur+"-->");
//            cur= cur.next;
//        }
        for(Node cur = dummyHead.next;cur!= null;cur=cur.next)
            res.append(cur+"-->");
        res.append(" null");
        return res.toString();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
