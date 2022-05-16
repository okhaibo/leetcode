//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 168 👎 0


package leetcode.editor.cn;

class SuccessorLcci {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            // 终止条件
            if (root == null) {
                return null;
            }

            // 当前值小于目标值，则在右子树
            if (root.val <= p.val){
                return inorderSuccessor(root.right, p);
            }
            TreeNode leftRes = null;
            // 可能在左子树中，或者当前节点
            // 因此，先搜索左子树，如果结果为null，说明当前节点就是结果
            leftRes = inorderSuccessor(root.left, p);
            return leftRes == null? root: leftRes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}