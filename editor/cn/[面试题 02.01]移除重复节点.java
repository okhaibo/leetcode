//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不能使用临时缓冲区，该怎么解决？
// Related Topics 链表 
// 👍 78 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;

class RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
        ListNode node1=new ListNode(1), node2=new ListNode(2), node3=new ListNode(3),
                node4=new ListNode(3), node5=new ListNode(2), node6=new ListNode(1);

        node1.next=node2;
        node2.next=node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next=null;

        ListNode newNode = solution.removeDuplicateNodes(node1);
        while(newNode != null){
            System.out.print(newNode.val);
            newNode = newNode.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null){
                return head;
            }

            ListNode root= new ListNode(0);
            ListNode cur = root;
            HashSet<Integer> set = new HashSet<>();

            while(head != null){

                if (set.contains(head.val)){
                    head = head.next;
                    continue;
                }

                cur.next = head;
                cur = cur.next;

                set.add(head.val);
                head = head.next;
            }
            cur.next=null;
            return root.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}