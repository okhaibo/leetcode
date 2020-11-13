// 字符串轮转。
// 给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
//
// 示例1: 
//
// 输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
//
// 示例2: 
//
//  入：s1 = "aa", s2 = "aba"
// 输出：False
//
//
// 提示：
// 
// 字符串长度在[0, 100000]范围内。 
//
// 说明:
// 你能只调用一次检查子串的方法吗？ 
// 
// Related Topics 字符串 
// 👍 45 👎 0


package leetcode.editor.cn;

class StringRotationLcci {
    public static void main(String[] args) {
        Solution solution = new StringRotationLcci().new Solution();
        System.out.println(solution.isFlipedString("waterbottle", "erbottlewat"));
        // true
        System.out.println(solution.isFlipedString("PvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmb", "SvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDW"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 != len2){
                return false;
            }

            // 长度不相等，肯定不符合要求
            if (s1.length() != s2.length()) {
                return false;
            }

            /**
             * 长度相等时，若s2是s1旋转而成的，那么把s2和自身拼接一次，s1就会出现在其中
             * "erbottlewat" + "erbottlewat" = erbottle waterbottle wat
             * 如果s2不是s1旋转而成的，那么那么把s2和自身拼接一次，s1就肯定不会出现在其中
             */
            return (s2 + s2).indexOf(s1) != -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}