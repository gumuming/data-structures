package line.dynamic_array.link;

//递归删除--->代价 函数调用 +系统栈空间
//leetcode 203
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

//     ListNode result = removeElements(head.next, val);
//      if(head.val == val)
//          return result;
//      else{
//          head.next = result;
//          return head;
//      }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

    }

    public static void main(String[] args) {
        int[] num = {1, 1, 4, 5, 6, 1, 7};
        ListNode head = new ListNode(num);
        System.out.println(head);
        System.out.println(new Solution3().removeElements(head, 1));
    }

}
