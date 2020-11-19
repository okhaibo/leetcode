//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 35 👎 0


package leetcode.editor.cn;

/**
 * 1. 双指针+栈  空间复杂度不满足
 * 2. 三指针 满足： 先通过双指针确定中间位置，中间位置往后反转，然后第三个指针从头节点开始遍历到中间位置
 */
class PalindromeLinkedListLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedListLcci().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            if (head == null){
                return true;
            }
            if (head.next == null){
                return true;
            }

            ListNode fast = head, slow = head, third = head;
            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            //如果fast不为空，说明链表的长度是奇数个
            if (fast != null){
                slow = slow.next;
            }

            slow = reverse(slow);

            while(slow != null){
                if (third.val != slow.val){
                    return false;
                }
                slow = slow.next;
                third = third.next;
            }
            return true;
        }


        //反转链表，并返回反转后的头节点
        public ListNode reverse(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}