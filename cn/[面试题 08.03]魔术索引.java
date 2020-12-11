// 魔术索引。
// 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
// 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
// 若有多个魔术索引，返回索引值最小的一个。
//
// 示例1: 
//
//  输入：nums = [0, 2, 3, 4, 5]
//  输出：0
//  说明: 0下标的元素为0
// 
//
// 示例2: 
//
//  输入：nums = [1, 1, 1]
//  输出：1
// 
//
// 说明:
//  nums长度在[1, 1000000]之间
//  此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
// 
// Related Topics 数组 二分查找 
// 👍 76 👎 0


package leetcode.editor.cn;

/**
 * https://leetcode-cn.com/problems/magic-index-lcci/solution/yi-chong-gai-jin-de-bian-li-fang-fa-by-gzl-7/
 */
class MagicIndexLcci {
    public static void main(String[] args) {
        Solution solution = new MagicIndexLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMagicIndex(int[] nums) {
            int length = nums.length, i=0;

            while (i<length){
                if (i == nums[i]){
                    return i;
                }
                // nums[i]>i的时候，不再令 i+=1；而是直接i=nums[i],比如i=0,nums[0] = 10,
                // 那么至少i=10，才能使nums[i]=i成立，也就是全10的情况。
                i = nums[i] > i + 1 ? nums[i] : i + 1;
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}