//
// 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
//
// 示例： 
//
// 输入：单向链表a->b->c->d->e->f中的节点c
// 结果：不返回任何数据，但该链表变为a->b->d->e->f
// 
// Related Topics 链表 
// 👍 70 👎 0


package leetcode.editor.cn;

class DeleteMiddleNodeLcci {
    public static void main(String[] args) {
        Solution solution = new DeleteMiddleNodeLcci().new Solution();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        solution.deleteNode(node2);
        ListNode cur = node1;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
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
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
            // 以下方式只是将node2指向了另一块内存地址，但是node1还是指向原来的node2地址，所以最终链表没有变化
//          node = node.next;

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