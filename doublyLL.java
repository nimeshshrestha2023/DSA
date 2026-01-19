import java.util.Scanner;

public class doublyLL{
    public static void main(String[] args) {
        
        doublyLinkedList dll = new doublyLinkedList();

        dll.addToHead(5);
        dll.addToHead(10);
        dll.addtoTail(15);

        dll.addanyPosition(2, 0);

        dll.deleteHead();
        dll.deleteTail();

        System.out.println("Element at index: "+dll.search(5));

       

        dll.display();
    }
}
class Node{
    int data;
    Node prev;
    Node next;

    public Node(int val)
    {
        data = val;
        prev = next = null;
    }
}

class doublyLinkedList{
    Node head;
    Node tail;

    public doublyLinkedList()
    {
        head = tail = null;
    }

    // Empty list case: 
    public boolean isEmpty()
    {
        return head == null;
    }

    // Add elements to head
    public void addToHead(int val)
    {
        Node newNode = new Node(val);
        if(isEmpty())
        {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }


    // Add elements to tail
    public void addtoTail(int val)
    {
        Node newNode = new Node(val);
        if(isEmpty())
        {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Add elements to any position: 
    public void addanyPosition(int data, int pos)
    {
        if(pos < 0)
        {
            System.out.println("Invalid position: ");
            return;
        } 

        if(pos == 0)
        {
            addToHead(data);
            return;
        }

        Node temp = head;
        for(int i=0;i<pos-1;i++)
        {
            if(temp == null)
            {
                System.out.println("Position out of range: ");
                return;
            }
            temp = temp.next;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;

        // Common Logic: 
        // newNode.next = temp;
        // temp.prev = newNode;
        // head.next = newNode;
        // newNode.prev = head;

    }

    //Insert at any position: (Alternative)
    public void addAnyPosition(int data, int pos)
    {
        if(pos<0)
        {
            System.out.println("Invalid Position: ");
            return;
        }
        if(pos == 0)
        {
        addToHead(data);
        return;
        }
        Node temp = head;
        int index = 0;
        while(temp != null && index < pos-1)
        {
            temp = temp.next;
            index++;
        }
        // if position is beyond list size
        if(temp == null)
        {
            System.out.println("Position out of range: ");
            return;
        }
        // if inserted at tail
        if(temp.next == null)
        {
            addToTail(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // delete Head

    public void deleteHead()
    {
        if(isEmpty())
        {
            System.out.println("Empty list cannot be deleted: ");
            return;
        }

        // only one node
        if(head == tail)
        {
            System.out.println(head.data +" deleted: ");
            head = tail = null;
        }

        Node temp = head;
        head = head.next;
        if(head != null)
        {
            temp.next = null;
            head.prev = null;
        }
    }

    // Delete elements at tail
    public void deleteTail()
    {
        if(isEmpty())
        {
            System.out.println("Empty list cannot be deleted: ");
            return;
        }

        // if only one node
        if(head == tail)
        {
            System.out.println(tail.data +" deleted: ");
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        if(tail != null)
        {
            tail.next = null;
            temp.prev = null;
        }
    }

    // Search elements
    public int search(int key)
    {
        Node temp  = head;
        int idx = 0;
        while(temp != null)
        {
            if(temp.data == key)
            {
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return idx;

    }

    // sorting 
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




    // display list
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("List is empty: ");
            return;
        }

        Node currNode  = head;
        while(currNode != null)
        {
            System.out.print(currNode.data +"<--->");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
}
