package line.static_array.queue;



import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 排序 NlogN
 * <p>
 * 优先队列 NlogM
 * <p>
 * 定义优先队列优先
 * Max -->min
 */


//在100_0000中选出前100名
public class Solution {

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        //自定义优先级
        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return 1;
            else if (this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        PriorityQueue<Freq> queue = new PriorityQueue<>();

        for (int key : map.keySet()) {
            //未到 k个元素
            if (queue.getSize() < k)
                queue.enqueue(new Freq(key, map.get(key)));
            else if (map.get(key) > queue.getFront().freq) {
                queue.dequeue();
                queue.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(! queue.isEmpty()){
            res.add(queue.dequeue().e);
        }

        return res;
    }


}
