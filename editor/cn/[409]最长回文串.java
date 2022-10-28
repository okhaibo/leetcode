//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输入:1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 477 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new LongestPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            HashMap<Character, Integer> charCount = new HashMap<>();
            int coupleCount = 0, res=0;
            boolean hasSingle = false;
            for (int i = 0; i < s.length(); i++) {
                charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
            }
            Set<Character> keys = charCount.keySet();
            for (Character c: keys) {
                if (charCount.get(c)%2!=0) {
                    hasSingle = true;
                }
                coupleCount = coupleCount+charCount.get(c)/2;
            }

            return hasSingle? coupleCount*2+1:coupleCount*2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}