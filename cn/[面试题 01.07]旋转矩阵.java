// 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像顺时针旋转 90 度。
//
// 不占用额外内存空间能否做到？ 
//
// 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 136 👎 0


package leetcode.editor.cn;

class RotateMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new RotateMatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int N = matrix.length;

            // 先以住主对角线 (左上--右下)为轴进行翻转
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }

            // 以中间列为轴进行翻转
            int mid = N >> 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < mid; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][N-j-1];
                    matrix[i][N-j-1] = tmp;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}