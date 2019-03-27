package tree.collections.set;

import tree.FileOperation;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("G:\\data-structures\\src\\pride-and-prejudice.txt",words);
        System.out.println("Total words "+words.size());

        System.out.println("a table city");
        BSTSet<String> set = new BSTSet<>();
        for(String s:words)
            set.add(s);
        System.out.println("Total words "+set.getSie());


    }

}
