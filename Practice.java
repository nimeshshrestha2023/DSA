public class Practice{
	public static void main(String[] args)
	{
		circularLL ll = new circularLL();
 
		ll.addtoHead(5);
		ll.addtoHead(10);

		ll.addtoTail(100);
		ll.addtoTail(200);

		ll.addanyPosition(14,1);

		ll.deleteHead();
		ll.deleteTail();

		ll.deleteAnyPosition(0);

		ll.display();
	}
}


class Node{
	int data;
	Node next;
	public Node(int val)
	{
		data = val;
		next = null;
	}
}


class circularLL{
	Node head, tail;
	public circularLL()
	{
		head = tail = null;
	}

	// is Empty case: 
	public boolean isEmpty()
	{
		return head == null;

	}

	// add to head
	public void addtoHead(int val)
	{
		Node newNode = new Node(val);
		if(isEmpty() == true)
		{
			head = tail = newNode;
			return;
		}
		newNode.next = head;
		tail.next = newNode;
		head = newNode;
	}

	// add to tail
	public void addtoTail(int val)
	{
		Node newNode = new Node(val);
		if(isEmpty())
		{
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		newNode.next  = head;
		tail = newNode;
	}

	// add at specific position
	public void addanyPosition(int data, int pos)
	{
		if(pos < 0)
		{
			System.out.println("Invalid position");
			return;
		}

		// Single node 
		if(head == tail)
		{
			System.out.println(head.data+" deleted");
			head = tail = null;
			return;
		}

		// if position to head location
		if(pos == 0 )
		{
			addtoHead(data);
			return;
		}


		Node newNode = new Node(data);
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
		
		newNode.next = temp.next;
		temp.next = newNode;
		tail.next = head;
	}

	// delete head
	public void deleteHead()
	{
		if(isEmpty())
		{
			System.out.println("List is empty: ");
			return;
		}

		// single node 
		if(head == tail)
		{
			System.out.println(head.data+" deleted ");
			head = tail = null;
			return;
		}

		Node temp  = head;
		head = head.next;
		tail.next = head;

		temp.next = null; // optional in Java

	}
	// DeleteTail node
	 public void deleteTail() {
        if (head == null) {
            // List is empty
            return;
        }

        if (head == tail) {
            // Only one node in the list
            head = null;
            tail = null;
            return;
        }

        // Traverse to find the second-to-last node
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        // 'current' is now the new tail (second-to-last node)
        // Update its next pointer to point to the head
        current.next = head;

        // Update the list's tail pointer
        tail = current;
        
        // The old tail node (which was 'current.next' before the update)
        // is now unreferenced and ready for garbage collection.
    }

	// delete node at specific position in circular singly linked list
public void deleteAnyPosition(int pos)
{
    if (pos < 0)
    {
        System.out.println("Invalid position");
        return;
    }

    // empty list
    if (head == null)
    {
        System.out.println("List is empty");
        return;
    }

    // single node
    if (head == tail)
    {
        head = tail = null;
		return;
    }

    // delete head
    if (pos == 0)
    {
        deleteHead();
		return;
    }

    // delete at specific position
    Node temp = head;
    for (int i = 0; i < pos - 1; i++)
    {
        temp = temp.next;
        
    }

    Node delNode = temp.next;
    temp.next = delNode.next;

    tail.next = head;
    delNode.next = null; // optional in Java
}


	// display
	public void display()
	{
		if(isEmpty() == true)
		{
			System.out.println("List is empty: ");
			return;
		}
		Node currNode = head;
		while(true)
		{
			System.out.print(currNode.data + "<-->");
			currNode = currNode.next;
			if(currNode == head){
				break;
			}
		}
		System.out.println("null");
	}
}
