package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyLinkedListRandomPointer {
    public Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }

        ArrayList<Node> arr = new ArrayList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        int count = 0;

        Node newHead = new Node(head.val);
        newHead.random = head.random;

        Node next;
        Node nextNext = new Node(0);

        arr.add(newHead);
        map.put(head, count);

        boolean first = true;
        while (head.next != null){
            count++;
            head = head.next;
            next = new Node(head.val);
            next.random = head.random;

            if (first){
                first = false;
                newHead.next = next;
                nextNext = next;
            }
            else {
                nextNext.next = next;
                nextNext = next;
            }


            arr.add(next);
            map.put(head, count);
        }

        next = newHead;
        while (next != null){
            if (next.random != null){
                next.random = arr.get(map.get(next.random));
            }
            next = next.next;
        }

        return newHead;
    }
}
