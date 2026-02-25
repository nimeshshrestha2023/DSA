public class stackwithArray {
    public static void main(String[] args) {
        Stack s = new Stack(5);

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
     

        System.out.println("Top element: " + s.peek());
        System.out.println("Popped: " + s.pop());
    }
}

class Stack {
    int maxSize;
    int[] stackArray;
    int top;

    // Constructor
    Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }
    
    // empty case: 
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    // full case: 
    public boolean isFull()
    {
        return top == maxSize  - 1;
    }

    // Push operation
   public  void push(int value) {
        if (isFull() == true) {
            System.out.println("Stack Overflow");
        } else {
            stackArray[++top] = value;
            System.out.println(value + " pushed into stack");
        }
    }

    // Pop operation
   public  int pop() {
        if (isEmpty() == true) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    // Peek operation
    public int peek() {
        if (isEmpty() == true) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }
}



