package line.dynamic_array.link;

//设置虚拟头节点
//leetcode 203
public class Solution2 {
    public ListNode removeElements(ListNode head,int val){
        ListNode dummyHead = new ListNode((-1));
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else
                prev = prev.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] num ={1,1,4,5,6,1,7};
        ListNode head = new ListNode(num);
        System.out.println(head);

        System.out.println(new Solution2().removeElements(head,4));
    }

}
