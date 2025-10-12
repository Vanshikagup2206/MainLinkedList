import java.util.HashMap;

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


public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        // Step 1: Create a HashMap to map original nodes to their copies
        HashMap<Node, Node> map = new HashMap<>();  //original node -> copied node
        Node curr = head;

        // Step 2: First pass - create all copy nodes
        while(curr != null){
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        // Step 3: Second pass - set next and random pointers
        curr = head;
        while(curr != null){
            Node copy = map.get(curr);               // get copied node
            copy.next = map.get(curr.next);          // connect next
            copy.random = map.get(curr.random);      // connect random
            curr = curr.next;
        }

        return map.get(head);
    }
}

/*
 * | **Key (original node)** | **Value (copied node)** |
| ----------------------- | ----------------------- |
| 🟦 Node@A (val=7)       | 🟩 Node@A′ (val=7)      |
| 🟦 Node@B (val=13)      | 🟩 Node@B′ (val=13)     |
| 🟦 Node@C (val=11)      | 🟩 Node@C′ (val=11)     |
| 🟦 Node@D (val=10)      | 🟩 Node@D′ (val=10)     |
| 🟦 Node@E (val=1)       | 🟩 Node@E′ (val=1)      |

copy.next = map.get(original.next)
copy.random = map.get(original.random)

copy(7′).next = map.get(13) = 13′
copy(7′).random = map.get(null) = null

And importantly:
👉 No arrow in the new list points to an old node.
All arrows point only among new nodes.
 */