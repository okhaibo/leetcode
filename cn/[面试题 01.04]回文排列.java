//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串 
// 👍 38 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

class PalindromePermutationLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLcci().new Solution();
        System.out.println(solution.canPermutePalindrome("tactcoa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            HashSet<Character> set = new HashSet<>();
            char[] arr = s.toCharArray();
            for (char c: arr) {
                if (set.contains(c)){
                    set.remove(c);
                }else{
                    set.add(c);
                }
            }
            return (set.size()<=1)? true: false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}