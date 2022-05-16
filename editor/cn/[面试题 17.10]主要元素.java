//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。 
//
// 示例 1： 
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 
//
// 示例 2： 
//
// 输入：[3,2]
//输出：-1 
//
// 
//
// 示例 3： 
//
// 输入：[2,2,1,1,1,2,2]
//输出：2 
//
// 
//
// 说明： 
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？ 
// Related Topics 位运算 数组 分治算法 
// 👍 64 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

class FindMajorityElementLcci {
    public static void main(String[] args) {
        Solution solution = new FindMajorityElementLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int majorityElement(int[] nums) {
//            int length = nums.length;
//            HashMap<Integer, Integer> map = new HashMap<>();
//
//            for (int num: nums) {
//                map.put(num, map.getOrDefault(num, 0)+1);
//            }
//
//            for (Integer e : map.keySet()) {
//                if (map.get(e)>length/2){
//                    return e;
//                }
//            }
//            return -1;
//        }

        /**
         * 摩尔投票法(同归于尽法，两两厮杀)，两两比较，不相等则同归于尽
         * 摩尔投票默认条件是数组存在主要元素，如果没有这个条件需要在投票后加一个验证
         * 类似[2,7,3,5,5]这种, 直接按照投票算法, 结果是5, 但其实本题应该是并不存在，因为5的个数没有超过一半.
         *
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            int count = 1, candidate = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == candidate) {
                    count++;
                } else if (count != 0) {
                    count--;
                } else {
                    candidate = nums[i];
                    count = 1;
                }
            }

            // 验证是否满足要求
            int t = nums.length / 2 + 1;
            count = 0;
            for (int num : nums) {
                if (num == candidate) {
                    count++;
                }
                if (count == t) {
                    return candidate;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}