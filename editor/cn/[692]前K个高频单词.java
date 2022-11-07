//给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。 
//
// 
//
// 示例 1： 
//
// 
//输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], 
//k = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 1 <= words.length <= 500 
// 1 <= words[i] <= 10 
// words[i] 由小写英文字母组成。 
// k 的取值范围是 [1, 不同 words[i] 的数量] 
// 
//
// 
//
// 进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
//
// Related Topics 字典树 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 509 👎 0


package leetcode.editor.cn;

import java.util.*;

class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((entry1, entry2) ->
                    entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue());
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            LinkedList<String> res = new LinkedList<>();
            while (!pq.isEmpty()) {
                res.addFirst(pq.poll().getKey());
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}