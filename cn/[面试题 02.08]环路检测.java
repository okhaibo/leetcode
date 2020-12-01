//给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
// 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
//
// 示例 1： 
//
//输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
//输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
//输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。 
//
//
// 进阶： 
//
// 你是否可以不用额外空间解决此题？ 
//
// Related Topics 链表 
// 👍 45 👎 0


package leetcode.editor.cn;

/**
 * 1.利用快慢指针可以快速确定是否有环
 * 2.有环的情况下，在第一次相遇点，将快指针重新放至表头，然后快慢指针均以1为步长，继续走，第二次相遇点就是环的起点
 * https://leetcode-cn.com/problems/linked-list-cycle-lcci/solution/kuai-man-zhi-zhen-zheng-ming-bi-jiao-yan-jin-by-ch/
 */
class LinkedListCycleLcci {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null){
                return null;
            }
            ListNode fast = head, slow = head;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow){
                    break;
                }
            }

            if (fast == null || fast.next == null){
                return null;
            }

            fast = head;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}