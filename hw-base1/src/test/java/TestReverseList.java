import Tcode.question.ListNode;
import Tcode.question.Node;

public class TestReverseList {
    public static void main(String[] args) {
        // 创建链表：1->2->3->4->5
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        // 翻转链表
        ListNode newHead = reverseList(head.next);
        // 打印翻转后的链表：5->4->3->2->1
        while (newHead != null) {
            System.out.print(newHead.val + "->");
            newHead = newHead.next;
        }
        System.out.println("null");
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
