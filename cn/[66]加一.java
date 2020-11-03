//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 570 👎 0


package leetcode.editor.cn;

class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            if (digits==null || digits.length==0) {
                return new int[0];
            }

            int size = digits.length, i=size-1;
            while(true){
                digits[i]=(digits[i]+1)%10;
                if (digits[i] != 0){
                    return digits;
                }
                //有进位
                i--;
                if (i<0){
                    int[] res = new int[size+1];
                    res[0] = 1;
                    return res;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}