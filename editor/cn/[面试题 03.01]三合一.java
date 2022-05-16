//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
//stackNum表示栈下标，value表示压入的值。
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
//  输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
//  输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
// Related Topics 设计 
// 👍 19 👎 0

  
  package leetcode.editor.cn;
  class ThreeInOneLcci{
      public static void main(String[] args) {
          TripleInOne solution = new ThreeInOneLcci().new TripleInOne(5);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class TripleInOne {
    int[] arr;
    int index1, index2, index3, size;
    public TripleInOne(int stackSize) {
        size = stackSize;
        arr = new int[3*stackSize];
        index1 = 0;
        index2 = stackSize;
        index3 =  2*stackSize;
    }
    
    public void push(int stackNum, int value) {
        switch (stackNum){
            case 0:
                if (index1<size){
                    arr[index1++] = value;
                }
                break;
            case 1:
                if (index2<2*size){
                    arr[index2++] = value;
                }
                break;
            case 2:
                if (index3<3*size){
                    arr[index3++] = value;
                }
            default:
                break;
        }
    }
    
    public int pop(int stackNum) {
        switch (stackNum){
            case 0:
                if ((index1-1) >= 0){
                    return arr[--index1];
                }
                return -1;
            case 1:
                if ((index2-1) >= size){
                    return arr[--index2];
                }
                return -1;
            case 2:
                if ((index3-1) >= 2*size){
                    return arr[--index3];
                }
                return -1;
            default:
                return -1;
        }
    }
    
    public int peek(int stackNum) {
        switch (stackNum){
            case 0:
                if ((index1-1) >= 0){
                    return arr[index1-1];
                }
                return -1;
            case 1:
                if ((index2-1) >= size){
                    return arr[index2-1];
                }
                return -1;
            case 2:
                if ((index3-1) >= 2*size){
                    return arr[index3-1];
                }
                return -1;
            default:
                return -1;
        }
    }
    
    public boolean isEmpty(int stackNum) {
        switch (stackNum){
            case 0:
                return index1 <= 0;
            case 1:
                return index2 <= size;
            case 2:
                return index3 <= 2*size;
            default:
        }
        return false;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }