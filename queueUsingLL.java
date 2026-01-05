public class queueUsingLL {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);

        q.dequeue();

        q.display();

    }
}

class Node {
    int data;
    Node next;

    public Node(int val) {
        data = val;
        next = null;
    }
}

class Queue {
    Node head;
    Node tail;

    public Queue() {
        head = tail = null;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int val) {
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Empty queue cannot be deleted: ");
            return -1;
        }
        int removed = head.data;
        // single node
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return removed;
    }

    

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <---> ");
            current = current.next;
        }
        System.out.println("null")  ;
    }

}
