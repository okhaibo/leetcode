// 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
//
// 示例:
// 给定有序数组: [-10,-3,0,5,9],
// 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//              0
//             / \
//           -3   9
//           /   /
//         -10  5
//
// Related Topics 树 深度优先搜索
// 👍 64 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 取数组中间的数建立根节点root，然后以中间为分界，将左边的子数组和右边的子数组分别传入sortedArrayToBST进行递归
 */
class MinimumHeightTreeLcci {
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTreeLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums.length == 0){
                return null;
            }
            int mid = nums.length/2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}