public class doublyCircularLL {
    public static void main(String[] args) {

        doublyCircularLinkedList dcll = new doublyCircularLinkedList();

        dcll.addToHead(10);
        dcll.addToHead(5);
        dcll.addToTail(20);
        dcll.addToTail(30);

        dcll.deleteHead();
        dcll.deleteTail();
        dcll.displayFront();
        dcll.displayReverse();
    }
}


class Node{
    int data;
    Node prev;
    Node next;

    public Node(int val) {
        data = val;
        prev = next = null;
    }
}

class doublyCircularLinkedList {
    Node head, tail;

    public doublyCircularLinkedList() {
        head = tail = null;
    }

    // check empty
    public boolean isEmpty() {
        return head == null;
    }

    // add to head
    public void addToHead(int val) {
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        newNode.next = head;
        newNode.prev = tail;

        head.prev = newNode;
        tail.next = newNode;

        head = newNode;
    }

    // add to tail
    public void addToTail(int val) {
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        newNode.prev = tail;
        newNode.next = head;

        tail.next = newNode;
        head.prev = newNode;

        tail = newNode;
    }
    
    // delete head element
    public void deleteHead() {
    if (isEmpty()) {
        System.out.println("List is empty");
        return;
    }

    // only one node
    if (head == tail) {
        System.out.println(head.data + " deleted");
        head = tail = null;
        return;
    }

    System.out.println(head.data + " deleted");

    head = head.next;
    head.prev = tail;
    tail.next = head;
}
  // delete tail
  public void deleteTail() {
    if (isEmpty()) {
        System.out.println("List is empty");
        return;
    }

    // only one node
    if (head == tail) {
        System.out.println(tail.data + " deleted");
        head = tail = null;
        return;
    }

    System.out.println(tail.data + " deleted");

    tail = tail.prev;
    tail.next = head;
    head.prev = tail;
}


    // // display
    // public void display() {
    //     if (isEmpty()) {
    //         System.out.println("List is empty");
    //         return;
    //     }

    //     Node temp = head;
    //     do {
    //         System.out.print(temp.data + "<--->");
    //         temp = temp.next;
    //     } while (temp != head);

    //     System.out.println("(back to head)");
    // }
    
    Js
    // display from front 
    public void displayFront() {
    if (isEmpty()) {
        System.out.println("List is empty");
        return;
    }

    Node temp = head;
    do {
        System.out.print(temp.data + "<--->");
        temp = temp.next;
    } while (temp != head);

    System.out.println("(back to head)");
}

// display reverse
public void displayReverse() {
    if (isEmpty()) {
        System.out.println("List is empty");
        return;
    }

    Node temp = tail;
    do {
        System.out.print(temp.data + "<--->");
        temp = temp.prev;
    } while (temp != tail);

    System.out.println("(back to tail)");
}


}
