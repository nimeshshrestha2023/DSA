public class singlyLL {
    public static void main(String[] args) {

        singlyLinkedList sll = new singlyLinkedList();
        sll.addtoHead(5);
        sll.addtoTail(10);
        sll.addanyPosition(3, 2);

        sll.deleteHead();
        sll.deleteTail();

        System.out.println(sll.search(4));

        sll.addanyPosition(1000, 0);
        
        sll.sort();

        sll.display();


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

class singlyLinkedList {
    Node head, tail;

    public singlyLinkedList() {
        head = tail = null;
    }

    // Empty list case :
    public boolean isEmpty() {
        return head == null;
    }

    // add to head(insert head)
    public void addtoHead(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // add to tail (insert tail)
    public void addtoTail(int val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // delete head

    public void deleteHead() {
        if (isEmpty()) {
            System.out.println("Empty list cannot be deleted: ");
            return;
        }
        // if only one node
        else if (head == tail) {
            System.out.println(head.data + " deleted");
            head = tail = null;
        } else {
            System.out.println(head.data + " deleted: ");
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
    }

    // delete tail
    public void deleteTail() {
        if (isEmpty()) {
            System.out.println("Emtpy list cannot be deleted: ");
            return;

        } else if (head == tail) {
            System.out.println(tail.data + " deleted: ");
            head = tail = null;
        } else {
            Node currNode = head;
            while (currNode.next != tail) {
                currNode = currNode.next;
            }
            System.out.println(tail.data + " deleted: ");
            tail = currNode;
            tail.next = null;
        }

    }
       // delete any position
   public void deleteAnyPosition(int pos) {
    if (pos < 0) {
        System.out.println("Invalid position");
        return;
    }

    // Empty list
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    // Delete head
    if (pos == 0) {
        Node temp = head;
        head = head.next;
        temp.next = null;

        System.out.println("Deleted successfully");
        return;
    }

    Node temp = head;
    for (int i = 0; i < pos - 1; i++) {
        if (temp.next == null) {
            System.out.println("Position out of range");
            return;
        }
        temp = temp.next;
    }

    Node temp1 = temp.next;
    temp.next = temp1.next;
    temp1.next = null;

   

    System.out.println("Deleted successfully");
}

    // Add element in any position

    public void addanyPosition(int data, int pos) {
        if (pos < 0) {
            System.out.println("Invalid position: ");
            return;
        }
        // Insert at head
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
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

    }

    // searching
    public int search(int key) {
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.data == key) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    // sort linked list using Bubble Sort
    public void sort() {
        if (isEmpty() || head.next == null) {
            return; // already sorted
        }

        boolean swapped;
        do {
            swapped = false;
            Node currNode = head;

            while (currNode.next != null) {
                if (currNode.data > currNode.next.data) {
                    // swap data
                    int temp = currNode.data;
                    currNode.data = currNode.next.data;
                    currNode.next.data = temp;

                    swapped = true;
                }
                currNode = currNode.next;
            }
        } while (swapped);
    }

    // display
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty: ");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "<--->");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

}


--------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public class Main{
    public static void main(String[] args){
        SinglyLL sll = new SinglyLL();
        
        sll.insertHead(25);
        sll.insertHead(15);
        sll.insertHead(5);
        
        sll.insertAnyPosition(1,0);
        
        sll.deleteHead();
        sll.deleteTail();
        
        sll.deleteAnyPosition(1);
        
        sll.display();
    }
}


class Node{
    int data;
    Node next;
    public Node(int val){
        data = val;
        next = null;
    }
}

class SinglyLL{
    Node head, tail;
    public SinglyLL(){
        head = tail = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void insertHead(int val){
        Node newNode = new Node(val);
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    
    public void insertTail(int val){
        Node newNode = new Node(val);
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    
    public void insertAnyPosition(int data, int pos){
        Node newNode = new Node(data);
        if(pos < 0){
            System.out.println("Invalid Position");
            return;
        }
        
        if(pos == 0){
            insertHead(data);
            return;
        }
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
        
        Node temp = head;
        for(int i=0;i<pos-1;i++){
            if(temp == null){
                System.out.println("Position out of range: ");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public void deleteHead(){
        if(isEmpty()){
            System.out.println("List is empty: ");
            return;
        }
        Node temp = head;
        head = head.next;
        
        temp.next = null; // optional
    }
    
    public void deleteTail(){
        if(isEmpty()){
            System.out.println("List is empty: ");
            return;
        }
        
        Node temp = head;
        while(temp.next != tail){
            if(temp == null){
                System.out.println("Position out of range: ");
                return;
            }
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }
    
    public void deleteAnyPosition(int pos){
        if(pos < 0){
         System.out.println("Invalid Position!");
         return;
        }
        if(isEmpty()){
            System.out.println("List is empty: ");
            return;
        }
        
        if(pos == 0){
            deleteHead();
            return;
        }
        Node temp =  head;
        for(int i=0;i<pos-1;i++){
            if(temp == null){
                System.out.println("Position out of range: ");
                return;
            }
            temp = temp.next;
        }
        Node temp1= temp.next;
        temp.next = temp1.next;
    }
    
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"<--->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
