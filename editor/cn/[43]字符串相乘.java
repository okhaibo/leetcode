//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1093 👎 0


package leetcode.editor.cn;

class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            // https://www.bilibili.com/video/BV1ba4y1J7yh/?spm_id_from=333.337.search-card.all.click&vd_source=da19533f890bd5dee5843dc3f3a34436
            int len1 = num1.length(), len2 = num2.length();
            if (len1 == 0 || len2 == 0 || (len1 == 1&& num1.charAt(0)=='0')|| (len2 == 1&& num2.charAt(0)=='0')) return "0";
            int[] ans = new int[len1+len2];
            for (int i = len2-1; i>=0; i--) {
                int bit1 = num2.charAt(i) - '0';
                for (int j = len1-1; j >= 0; j--) {
                    int bit2 = num1.charAt(j) - '0';
                    ans[i+j+1] += bit1*bit2;
                }
            }
            // 统一处理进位
            for (int i = len1+len2-1; i > 0; i--) {
                ans[i-1] += ans[i] / 10;
                ans[i] = ans[i] % 10;
            }
            // 拼接结果
            StringBuilder sb = new StringBuilder();
            int firstIndex = ans[0]!=0?0:1;
            for (int i = firstIndex; i < ans.length; i++) {
                sb.append(ans[i]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}