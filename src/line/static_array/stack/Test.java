package line.static_array.stack;

public class Test {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();

        for(int i =0;i<10;i++){
            arrayStack.push(i);
        }
        arrayStack.pop();
        System.out.println(arrayStack);




    }
}
