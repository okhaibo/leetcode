//
// 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
//
// 示例： 
//  输入： a = 1, b = 2
//  输出： 2
// 
// Related Topics 位运算 数学 
// 👍 70 👎 0


package leetcode.editor.cn;

class MaximumLcci {
    public static void main(String[] args) {
        Solution solution = new MaximumLcci().new Solution();
        System.out.println(solution.maximum(2147483647, -2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximum(int a, int b) {
            long x = (long)a-(long)b;
            int flag = (int)(x>>63);

            return (1+flag)*a-flag*b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}