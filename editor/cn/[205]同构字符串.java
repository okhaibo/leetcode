//给定两个字符串 s 和 t ，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
//
// Related Topics 哈希表 字符串 👍 535 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;

class IsomorphicStrings{
  public static void main(String[] args) {
       Solution solution = new IsomorphicStrings().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && (!map.get(s.charAt(i)).equals(t.charAt(i)))) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
            if (map2.containsKey(t.charAt(i)) && (!map2.get(t.charAt(i)).equals(s.charAt(i)))) {
                return false;
            }
            map2.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}