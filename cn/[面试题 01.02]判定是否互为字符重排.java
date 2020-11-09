// 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
// 输出: true
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
// 输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串 
// 👍 20 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

class CheckPermutationLcci {
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
        System.out.println(solution.CheckPermutation("abc", "cab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()){
                return false;
            }

            HashMap<Character, Integer> map = new HashMap<>();
            char[] s1Arr = s1.toCharArray();
            char[] s2Arr = s2.toCharArray();
            for (int i = 0; i < s1Arr.length; i++) {
                if (map.containsKey(s1Arr[i])){
                    map.put(s1Arr[i], map.get(s1Arr[i])+1);
                }else {
                    map.put(s1Arr[i], 1);
                }
            }

            for (int i = 0; i < s2Arr.length; i++) {
                if (!map.containsKey(s2Arr[i])){
                    return false;
                }else {
                    int v;
                    if ((v = map.get(s2Arr[i])-1) == 0){
                        map.remove(s2Arr[i]);
                    }else {
                        map.put(s2Arr[i], v);
                    }
                }
            }

            return map.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}