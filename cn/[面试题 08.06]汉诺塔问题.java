// 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。
// 一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。
//
// 移动圆盘时受到以下限制:
//      (1) 每次只能移动一个盘子;
//      (2) 盘子只能从柱子顶端滑出移到下一根柱子;
//      (3) 盘子只能叠在比它大的盘子上。
//
// 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。 
//
// 你需要原地修改栈。 
//
// 示例1: 
//
//  输入：A = [2, 1, 0], B = [], C = []
// 输出：C = [2, 1, 0]
// 
//
// 示例2: 
//
//  输入：A = [1, 0], B = [], C = []
// 输出：C = [1, 0]
// 
//
// 提示: 
//
// 
// A中盘子的数目不大于14个。 
// 
// Related Topics 递归 
// 👍 68 👎 0


package leetcode.editor.cn;

import java.util.List;

class HanotaLcci {
    public static void main(String[] args) {
        Solution solution = new HanotaLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            movePlate(A.size(), A, B, C);
        }

        /**
         * 将原柱子上的所有盘子，借助辅助柱子，移动到目标柱子上
         * @param size      需要移动的数量
         * @param origin    原柱子
         * @param auxiliary 辅助柱子
         * @param target    目标柱子
         */
        private void movePlate(int size, List<Integer> origin, List<Integer> auxiliary, List<Integer> target) {
            // 只剩一个盘子时，直接移动即可
            if (size == 1){
                // 为了保证顺序，需要限制搬动的位置，只将最上面的搬走
                target.add(origin.remove(origin.size()-1));
                return;
            }
            // 将 size-1 个盘子，从 original 移动到 auxiliary
            movePlate(size-1, origin, target, auxiliary);
            // 将 第size个盘子，从 original 移动到 target
            movePlate(1, origin, auxiliary, target);
            // 将 size-1 个盘子，从 auxiliary 移动到 target
            movePlate(size-1, auxiliary, origin, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}