package line.dynamic_array.link;
//debug
//递归删除--->代价 函数调用 +系统栈空间
//leetcode 203
public class Solution4 {
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove" + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: "+head);
            return null;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove "+val+": "+res);

        ListNode ret;
        if(head.val == val){
            ret = res;
        }else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: "+ret);

        return ret;

    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("---");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(num);
        System.out.println(head);
        System.out.println(new Solution4().removeElements(head, 6, 4));
    }

}
