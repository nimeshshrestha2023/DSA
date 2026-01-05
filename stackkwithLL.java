
public class stackkwithLL {

    public static void main(String[] args) {

        Stack stk = new Stack();

        stk.push(5);
        stk.push(55);
        stk.push(35);
        stk.push(25);

        stk.peek();
        stk.pop();
        stk.peek();

        stk.display();
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

class Stack {
    Node top;

    public Stack() {
        top = null;
    }

    // push
    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
    }

    // pop
    public void pop() {
        if (top == null) {
            System.out.println("Underflow");
            return;
        }
        top = top.next;
    }

    // peek
    public void peek() {
        if (top == null) {
            System.out.println("Underflow");
            return;
        }
        System.out.println("Top element: " + top.data);
    }

    // display stack
    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
