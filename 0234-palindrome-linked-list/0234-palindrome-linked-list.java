/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//Approach-1(Using extra space)
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         List<Integer> list = new ArrayList<>();
//         ListNode n = head;
//         while(n!=null){
//             list.add(n.val);
//             n = n.next;
//         }
//         int left = 0;
//         int right = list.size()-1;

//         while(left<=right){
//             if(list.get(left)!=list.get(right)){
//                 return false;
//             }
//             left++;
//             right--;
//         }

//         return true;
//     }
// }

//Approach-2(O(1)-space)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode prev = null;

        while(curr!=null){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        slow = head;
        curr = prev;
        while(curr!=null){
            if(slow.val!=curr.val){
                return false;
            }
            slow=slow.next;
            curr = curr.next;
        }

        return true;
    }
}