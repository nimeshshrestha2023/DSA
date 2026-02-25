// import java.util.Stack;

// public class infixtopostfix {
    
//     // Function to return precedence of operators
//     static int prec(char c) {
//         if (c == '^')
//             return 3;
//         else if (c == '/' || c == '*')
//             return 2;
//         else if (c == '+' || c == '-')
//             return 1;
//         else
//             return -1;
//     }

//     // Function to check if operator is right-associative
//     static boolean isRightAssociative(char c) {
//         return c == '^';
//     }

//     public static String infixToPostfix(String s) {
//         Stack<Character> st = new Stack<>();
//         StringBuilder res = new StringBuilder();

//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);

//             // If operand, add to result
//             if ((c >= 'a' && c <= 'z') ||(c >= 'A' && c <= 'Z') ||
//                 (c >= '0' && c <= '9'))
//                 res.append(c);

//             // If '(', push to stack
//             else if (c == '(')
//                 st.push('(');

//             // If ')', pop until '( '
//             else if (c == ')') {
//                 while (!st.isEmpty() && st.peek() != '(') {
//                     res.append(st.pop());
//                 }
//                 st.pop();
//             }

//             // If operator
//             else {
//                 while (!st.isEmpty() && st.peek() != '(' &&
//                        (prec(st.peek()) > prec(c) ||
//                        (prec(st.peek()) == prec(c) && !isRightAssociative(c)))) {
//                     res.append(st.pop());
//                 }
//                 st.push(c);
//             }
//         }

//         // Pop remaining operators
//         while (!st.isEmpty()) {
//             res.append(st.pop());
//         }

//         return res.toString();
//     }

//     public static void main(String[] args) {
//         String exp = "(a+b)*c-(d-e)*(f+g)";
//         System.out.println(infixToPostfix(exp));
//     }
// }



import java.util.Scanner;
import java.util.Stack;

class InfixPostfixConversion {

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else
            return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the infix expression: ");
        String infix = sc.nextLine();

        String postfix = "";
        Stack<Character> stack = new Stack<>();

        char[] arr = infix.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            // Left parenthesis
            if (ch == '(') {
                stack.push(ch);
            }
            // Operator
            else if (isOperator(ch)) {

                while (!stack.isEmpty()
                        && isOperator(stack.peek())
                        && (precedence(stack.peek()) >= precedence(ch)))
                {

                    postfix += stack.pop();
                }
                stack.push(ch);
            }
            // Right parenthesis
            else if (ch == ')') {
                while (stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop(); // remove '('
            }
            // Operand
            else {
                postfix += ch;
            }
        }

        // Remaining operators
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        System.out.println("Postfix expression: " + postfix);
    }
}


