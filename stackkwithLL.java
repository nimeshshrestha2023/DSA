class stackkwithll{
    
static class Node{
    int data;
    Node next;
    public Node(int data)
    {
        this.data = data;
        next = null;
    }
}

static class Stack{
    public Node top;
    public Stack()
    {
        top = null;
    }
    
    // Empty case: 
    public boolean isEmpty()
    {
        return top == null;
    }
    //push
    public void push(int data)
    {
        Node newNode = new Node(data);
        if(isEmpty() == true)
        {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }
    
    //pop
    public  int pop()
    {
        if(isEmpty() == true)
        {
            System.out.println("Underflow: ");
            return -1;
        }
        int peek = top.data;
        top = top.next;
        return peek;
    }
    
    
    // peek
    public int peek()
    {
         if(isEmpty() == true)
        {
            System.out.println("Underflow: ");
            return -1;
        }
        return top.data;
        
    }
    
    
}
public static void main(String[] args)
    {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        
        while(!s.isEmpty())
        {
            System.out.println(s.peek());
            s.pop();
        }
    }
}