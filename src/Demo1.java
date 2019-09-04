class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 链表相加
 */
public class Demo1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next=new ListNode(8);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next=new ListNode(6);
        ListNode newNode = addTwoNumbers(l1, l2);
        while (newNode != null) {
            System.out.println(newNode.val);
            if (newNode.next != null)
                newNode = newNode.next;
            else
                break;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode;
        int ten = 0;

        newNode = new ListNode((l1.val + l2.val) % 10);
        if (l1.val + l2.val >= 10) {
            ten = 1;
        }
        ListNode head = newNode;

        if (l1.next == null && l2.next == null) {
            if (ten == 1) {
                newNode.next = new ListNode(1);
            }
            return head;
        }

        while (l1.next != null || l2.next != null) {

            if (l1.next == null)
                l1.next = new ListNode(0);
            if (l2.next == null)
                l2.next = new ListNode(0);

            //判断是否有进一,并进行位数相加
            if (ten == 1) {
                if (l1.next.val + l2.next.val + 1 >= 10)
                    ten = 1;
                else
                    ten = 0;
                newNode.next = new ListNode((l1.next.val + l2.next.val + 1) % 10);
            } else {
                if (l1.next.val + l2.next.val >= 10)
                    ten = 1;
                else
                    ten = 0;
                newNode.next = new ListNode((l1.next.val + l2.next.val) % 10);
            }

            newNode = newNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (ten == 1)
            newNode.next = new ListNode(1);
        return head;
    }
}
