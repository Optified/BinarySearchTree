public class BinarySearchTree {
    Node root;

    public void insert(Node node){
        root = insertHelper(root, node);
    }
    private Node insertHelper(Node root, Node node){
        int data = node.data;
        if(root == null){
            root = node;
            return root;
        }
        else if(data < root.data){
            root.left = insertHelper(root.left, node);
        }
        else{
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    public void display(){
        displayHelper(root);
    }
    private void displayHelper(Node root){ //inorder traversal
        if(root != null){
            displayHelper(root.left); //displays left side, which is less than the right side
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }
    public boolean search(int data){
        return searchHelper(root, data);
    }
    private boolean searchHelper(Node root, int data){
        if(root == null){
            return false;
        }
        else if(root.data == data){
            return true;
        }
        else if(root.data > data){
            return searchHelper(root.left, data);
        }
        else{
            return searchHelper(root.right, data);
        }
    }
    private void remove(int data){

    }
    public Node removeHelper(Node root, int data){
        return null; //placeholder
    }
    private int successor(Node root){
        return 0; //placeholder
    }
    private int predecessor(Node root){
        return 0; //placeholder
    }

}
