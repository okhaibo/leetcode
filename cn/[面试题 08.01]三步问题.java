//三步问题
// 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
// 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
//
// 示例1: 
//
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 动态规划 
// 👍 32 👎 0


package leetcode.editor.cn;

class ThreeStepsProblemLcci {
    public static void main(String[] args) {
        Solution solution = new ThreeStepsProblemLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToStep(int n) {
            int mod = 1000000007;
            long[] dp = new long[n+1];
            if (n==1) {
                return 1;
            }
            if (n==2) {
                return 2;
            }
            if (n==3) {
                return 4;
            }

            dp[1]=1; dp[2]=2; dp[3]=4;
            for (int i = 4; i < n+1; i++) {
                dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%mod;
            }

            return (int)dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}