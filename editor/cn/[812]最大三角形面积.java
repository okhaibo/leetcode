//给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。 
//
// 
//示例:
//输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//输出: 2
//解释: 
//这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
// 
//
// 
//
// 注意: 
//
// 
// 3 <= points.length <= 50. 
// 不存在重复的点。 
// -50 <= points[i][j] <= 50. 
// 结果误差值在 10^-6 以内都认为是正确答案。 
// 
// Related Topics 几何 数组 数学 👍 155 👎 0


package leetcode.editor.cn;

class LargestTriangleArea {
    public static void main(String[] args) {
        int[][] points = {{-35,19},{40,19},{27,-20},{35,-3},{44,20},{22,-21},{35,33},{-19,42},{11,47},{11,37}};
        Solution solution = new LargestTriangleArea().new Solution();
        System.out.println(solution.largestTriangleArea(points));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestTriangleArea(int[][] points) {
            int length = points.length;
            double maxS = 0.0;
            for (int i = 0; i < length-2; i++) {
                for (int j = i+1; j < length-1; j++) {
                    for (int k = j+1; k < length; k++) {
                        int[] point1 = points[i];
                        int[] point2 = points[j];
                        int[] point3 = points[k];
                        //  海伦公式
                        double a = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
                        double b = Math.sqrt(Math.pow(point2[0] - point3[0], 2) + Math.pow(point2[1] - point3[1], 2));
                        double c = Math.sqrt(Math.pow(point3[0] - point1[0], 2) + Math.pow(point3[1] - point1[1], 2));
                        double p = (a+b+c)/2;

                        double s = Math.sqrt(p*Math.abs(p-a)*Math.abs(p-b)*Math.abs(p-c));
                        maxS = Math.max(maxS, s);
                    }
                }
            }
            return maxS;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}