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
        if(root == null){ //cant search anything if tree is empty
            return false;
        }
        else if(root.data == data){ //if our search is our root
            return true;
        }
        else if(root.data > data){ //if data is greater than the data, it'll search on the right 
            return searchHelper(root.left, data);
        }
        else{
            return searchHelper(root.right, data);
        }
    }
    public void remove(int data){
        if(search(data)){
            removeHelper(root, data);
        }
        else{
            System.out.println(data + " could not be found");
        }
    }
    public Node removeHelper(Node root, int data){
        if(root == null){
            return root;
        }
        else if(data < root.data){
            root.left = removeHelper(root.left, data);
        }
        else if(data > root.data){
            root.right = removeHelper(root.right, data);
        }
        else{
            if(root.left == null && root.right == null){ //if the node is a leaf (no left or right child)
                root = null;
            }
            else if(root.right != null){ //the right node will be removed
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else{
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }
    private int successor(Node root){ //find least value below the right child of the root.
        root = root.right; //root first takes the right side, and then keeps going down left. the farthest left will replace the node that's being removed
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
    private int predecessor(Node root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }

}
