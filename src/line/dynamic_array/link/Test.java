package line.dynamic_array.link;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i =0;i<5;i++)
            linkedList.addFirst(i);
        linkedList.add(3,55555);
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);


    }
}
