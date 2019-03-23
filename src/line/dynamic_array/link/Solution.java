package line.dynamic_array.link;

public class Solution {
    public ListNode removeElements(ListNode head,int val){

        while(head != null && head.val==val){
//            ListNode delNode = head;
//            head = head.next;
//            delNode = null;
            head = head.next;
        }

        if(head == null)
            return head;

        //Head 不是删除节点
        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val ==val){
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            }else
                prev = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] num ={1,1,4,5,6,1,7};
        ListNode head = new ListNode(num);
        System.out.println(head);

        System.out.println(new Solution().removeElements(head,1));
    }
}
