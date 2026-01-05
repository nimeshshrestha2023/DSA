import java.util.Scanner;

public class circularLL {
    public static void main(String[] args) {

        circularLinkedList cll = new circularLinkedList();

        cll.addtoHead(5);
        cll.addtoHead(10);
       

        cll.addtoTail(15);

        cll.deleteHead();
        cll.deleteTail();

        cll.addanyPosition(0, 0);

        cll.display();
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

class circularLinkedList {
    Node head, tail;

    public circularLinkedList() {   
        head = tail = null;
    }

    // Empty list case:
    public boolean isEmpty() {   // Time complexity: O(1)
        return head == null;
    
    }

    // Add element to the head
    public void addtoHead(int val) {   // Time complexity: O(1)
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Add elements to the tail

    public void addtoTail(int val) {  // Time complexity: O(1)
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Delete head element
    public void deleteHead() {   // Time complexity: O(1)
        if (isEmpty()) {
            System.out.println("Empty list: ");
            return;
        }

        // Single node
        Node currNode = head;
        if (head == tail) {
            System.out.println(currNode.data + " deleted: ");
            head = tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        tail.next = head;

        temp.next = null;
    }

    // Delete tail elements

    public void deleteTail() {  // Time complexity: O(n)
        Node currNode = head;
        if (isEmpty()) {
            System.out.println("Empty list: ");
            return;
        }
        // single node
        if (head == tail) {
            System.out.println(currNode.data + " deleted: ");
            head = tail = null;
        }

        Node temp = tail;
        System.out.println(currNode.data + " deleted: ");
        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;

        }
        tail = prev;
        tail.next = head;
        temp.next = null;

    }

    // Add element in any position
    public void addanyPosition(int data, int pos) {  // Time complexity: O(n)
        if (pos < 0) {
            System.out.println("Invalid position: ");
            return;
        }

        if (pos == 0) {
            addtoHead(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of range: ");
                return;
            }
            temp = temp.next;
        }
        Node newNode = head;
        newNode.next = temp.next;
        temp.next = newNode;
        tail.next = head;

    }

    // Display
    public void display() {    // Time complexity: O(n)
        if (head == null) {
            System.out.println("Empty list: ");
            return;
        }

        Node currNode = head;
        while (true) {
            System.out.print(currNode.data + "<--->");
            currNode = currNode.next;
            if (currNode == head) // stop when we come back to head
                break;
        }
        System.out.println("null");
    }
}