package Tcode.question;

import lombok.Data;
import lombok.val;

@Data
public class Node<T> {

    public Node<T> pre;

    public Node<T> next;

    public T data;

    public Node(T data) {
        this.data = data;
    }

}
