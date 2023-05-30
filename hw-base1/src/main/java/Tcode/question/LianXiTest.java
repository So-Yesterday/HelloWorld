package Tcode.question;

public class LianXiTest {


    // 合并两个有序链表
    public Node mergeNode(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        if (node1.getData() <= node2.getData()) {
            node1.next = mergeNode(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeNode(node1, node2.next);
            return node2;
        }
    }

    // 翻转链表
    public Node reverseNode(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> p = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
