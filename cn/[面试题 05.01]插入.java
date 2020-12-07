// 插入
// 给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。
// 假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。
// 例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
//
// 示例1: 
//
//  输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
// 输出：N = 1100(10001001100)
// 
//
// 示例2: 
//
//  输入： N = 0, M = 31(11111), i = 0, j = 4
// 输出：N = 31(11111)
// 
// Related Topics 位运算 
// 👍 21 👎 0


package leetcode.editor.cn;

// 傻逼题目 j-i+1有多少位就必须替换多少位
class InsertIntoBitsLcci {
    public static void main(String[] args) {
        Solution solution = new InsertIntoBitsLcci().new Solution();
       // System.out.println(solution.insertBits(1024, 19, 2, 6));
       // System.out.println(solution.insertBits(0, 31, 0, 4));
        System.out.println(solution.insertBits(2032243561, 10, 24, 29));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int insertBits(int N, int M, int i, int j) {
            //将整数放入一个long中，在其左侧添加一个位，这意味着toBinaryString将有33个数字，然后取右侧的32个数字（去掉添加的额外1）
            char[] Nbinary = Long.toBinaryString( N & 0xffffffffL | 0x100000000L ).substring(1).toCharArray();
            char[] Mbinary = Integer.toBinaryString(M).toCharArray();
            if ((j-i+1) < Mbinary.length){
                return -1;
            }

            int indexM = Mbinary.length-1;
            for (int k = Nbinary.length-1-i; k >= Nbinary.length-1-j; k--) {
                if (indexM<0){
                    Nbinary[k]='0';
                }else {
                    Nbinary[k] = Mbinary[indexM--];
                }
            }
            return Integer.parseInt(String.valueOf(Nbinary), 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}