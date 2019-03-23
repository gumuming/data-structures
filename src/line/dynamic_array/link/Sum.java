package line.dynamic_array.link;

/**
 * 递归求和
 */
public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    //计算arr[l...n]区间的和
    private static int sum(int[] arr,int left){
        //求解最基本问题
        if(left == arr.length){
            return 0;
        }
        //把原问题转化成更小的问题
        //return arr[left]+sum(arr,left+1);

        int x = sum(arr,left+1);
        int res = arr[left]+x;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(sum(nums));
    }
}
