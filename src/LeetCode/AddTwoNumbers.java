package LeetCode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode retNext = ret;

        boolean carry = false;
        while ((l1 != null || l2!= null) || carry){
            int val1;
            int val2;

            if (l1 == null){
                val1 = 0;
            }
            else {
                val1 = l1.val;
                l1 = l1.next;
            }

            if (l2 == null){
                val2 = 0;
            }
            else {
                val2 = l2.val;
                l2 = l2.next;
            }

            int add = 0;
            if (carry){
                add = val1 + val2 + 1;
            }
            else {
                add = val1 + val2;
            }

            if (add > 9){
                add = add % 10;
                carry = true;
            }
            else {
                carry = false;
            }

            retNext.val = add;
            if ((l1 != null || l2!= null) || carry){
                ListNode retNew = new ListNode(0);
                retNext.next = retNew;
                retNext = retNew;
            }

        }

        return ret;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}