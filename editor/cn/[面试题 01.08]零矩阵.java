//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 19 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
        solution.setZeroes(new int[][]{{0, 0, 0, 5},{4, 3, 1, 4},{0, 1, 1, 4},{1, 2, 1, 3},{0,0,1,1}});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;
            HashSet<Integer> rowSet = new HashSet<>(), colSet = new HashSet<>();
            for (int i = 0; i < rows; i++) {
//                if (rowSet.contains(i)){
//                    continue;
//                }
                for (int j = 0; j < cols; j++) {
//                    if (colSet.contains(j)){
//                        continue;
//                    }

                    if (matrix[i][j] == 0){
                        rowSet.add(i);
                        colSet.add(j);
                    }
                }
            }

            for (Integer row : rowSet) {
                for (int i = 0; i < cols; i++) {
                    matrix[row][i] = 0;
                }
            }

            for (Integer col : colSet) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][col] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}