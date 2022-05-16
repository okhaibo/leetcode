//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。 
//
// 示例1:
// 
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
//
// 示例2: 
//
// 输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 回溯算法 
// 👍 35 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 所谓的回溯。用一颗树来表示的话就是不断向下深入然后在向上返回的过程。
 */
class PermutationILcci {
    public static void main(String[] args) {
        Solution solution = new PermutationILcci().new Solution();
        String[] strs = solution.permutation("qwe");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<String> res = new LinkedList<>();
        public String[] permutation(String S) {
            char[] candidate = S.toCharArray();
            boolean[] isUsed = new boolean[candidate.length];

            backTrack(candidate, isUsed, new StringBuilder());
            return res.toArray(new String[0]);
        }

        private void backTrack(char[] candidate, boolean[] isUsed, StringBuilder sb) {
            // 终止条件
            if (sb.length() == candidate.length){
                res.add(sb.toString());
                return;
            }

            for (int i = 0; i < candidate.length; i++) {
                // 做选择
                if (isUsed[i] == true){
                    continue;
                }
                sb.append(candidate[i]);
                isUsed[i] = true;

                // 回溯
                backTrack(candidate, isUsed, sb);

                // 撤销选择
                sb.deleteCharAt(sb.length()-1);
                isUsed[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}