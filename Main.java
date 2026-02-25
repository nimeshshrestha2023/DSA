// class Node {
//     int data;
//     Node left;
//     Node right;

//     public Node(int val, Node left, Node right) {
//         this.data = data;
//         this.left = left;
//         this.right = right;
//     }

//     public Node(int data) {
//         this.data = data;
//         this.left = null;
//         this.right = null;
//     }
// }

// class BST {
//     Node root;

//     public BST() {
//         root = null; // initially the list is empty, thus root = null;
//     }

//     // if the list is empty:
//     public boolean isEmpty() {
//         return root == null;
//     }

//     public void visit(Node p) // here, p 's work is to point toward new Node
//     {
//         System.out.print(p.data);
//     }

//     public void insert(int val) {
//         Node p = root, prev = null; // Here, prev's work is to point towards parent node

//         while (p != null) {
//             prev = p;
//             if (p.data < val) {
//                 p = p.right;

//             } else {
//                 p = p.left;
//             }
//             if (root == null) // if the tree is empty
//             {
//                 root = new Node(val);
//             } else if (prev.data < val) {
//                 prev.right = new Node(val);
//             } else {
//                 prev.left = new Node(val);
//             }

//         }

//     }
//     public void BFSTraversal()
//     {
//         Queue1 q = new Queue1();
//         if(root!=null)
//         {
//             q.enqueue(root);
//             while (!q.isEmpty()) {
//                 Node p = q.dequeue();
//                 if(p.left!=null)
//                 {
//                     q.enqueue(p.right);
//                 }
//                 visit(p);
                
//             }
//         }

//     }
//     public void inorder(Node p)
//     {
//         if(p != null)
//         {
//             inorder(p.left);
//             visit(p);
//             inorder(p.right);
//         }
//     }

//     public void preorder(Node p)
//     {
//         if(p!=null)
//         {
//             visit(p);
//             preorder(p.left);
//             preorder(p.right);
//         }
//     }

//     public static void main(String[] args) {
//         BST t = new BST();

//         t.insert(15);
//         t.insert(10);
//         t.insert(2);
//         t.insert(21);
//         t.visit(t.root.left);

//     }
// }










// Java Program to Implement
// Binary Search Tree

class Node {
    int key;
    Node left, right;

    public Node(int val) {
        key = val;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insertion operation
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Deletion operation
    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Search operation
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (root.key < key)
            return searchRec(root.right, key);
        return searchRec(root.left, key);
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
        System.out.println("\n");
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    void preorder() {
        preorderRec(root);
        System.out.println("\n");
        
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    void postorder() {
        postorderRec(root);
        System.out.println("\n");
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

}

// Driver Class
public class Main{
      // Main Function
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Inserting elements
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal:");
        tree.inorder();

        // Deleting elements
        tree.delete(20);
        tree.delete(30);

        System.out.println("Inorder traversal after deletion:");
        tree.inorder();

        // Searching for an element
      
        // Traversals
        System.out.println("Preorder traversal:");
        tree.preorder();

        System.out.println("Postorder traversal:");
        tree.postorder();
    }
}