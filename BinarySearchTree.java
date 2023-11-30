import java.util.Scanner;
import java.util.ArrayList;


public class BinarySearchTree {
    Node root;
    //ArrayList<Integer> numbers = new ArrayList<>();



    public void insert(){ //asks user for data, and then recursively adds it into the binary search tree

        Scanner hello = new Scanner(System.in);
        String input;

        System.out.println("Please input a UNIQUE POSITIVE number that you have not inputted before: ");
        input = hello.next();
        int num = Integer.parseInt(input);
 /*        numbers.add(0);
        boolean isUnique = false;

        while(isUnique == false){
            int numberTest = 0;
            if(num == numbers.get(numberTest) || num < 0){
                System.out.println("You just input either a non unique, or non positive number. Please try again.");
                input = hello.next();
                num = Integer.parseInt(input);
            }
            else if(numberTest == numbers.size()){
                isUnique = true;
            }
            else{
                numberTest++;
            }
        }

        numbers.add(num);*/
        Node node = new Node(num);

        System.out.println("Please input a First Name:");
        input = hello.next();
        node.setFirstName(input);
        
        System.out.println("Please input a Last Name:");
        input = hello.next();
        node.setLastName(input);

        System.out.println("Please enter a City:");
        input = hello.next();
        node.setCity(input);

        System.out.println("Please enter a Number:");
        input = hello.next();
        node.setNumber(input);

        System.out.println("Please enter an Address:");
        input = hello.next();
        node.setAddress(input);

        root = insertHelper(root, node); 

    }
    private Node insertHelper(Node root, Node node){
        int key = node.key;
        if(root == null){
            root = node;
            return root;
        }
        else if(key < root.key){
            root.left = insertHelper(root.left, node);
        }
        else{
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    public void display(int input){
        if(input == 1){
            displayHelperInOrder(root);
        }
        else if(input == 2){
            displayHelperPostOrder(root);
        }
        else if(input == 3){
            displayHelperPreOrder(root);
        }
        else{
            System.out.println("An error as occured. There was a chance that you entered an invalid input. Please try again.");
        }
    }
    private void displayHelperInOrder(Node root){ //inorder traversal
        if(root != null){
            displayHelperInOrder(root.left); //displays left side, which is less than the right side
            System.out.println(root.key);
            displayHelperInOrder(root.right);
        }
    }
    private void displayHelperPostOrder(Node root){
        if(root != null){
            displayHelperPostOrder(root.left);
            displayHelperPostOrder(root.right);
            System.out.println(root.key);
        }
    }
    private void displayHelperPreOrder(Node root){
        if(root != null){
            System.out.println(root.key);
            displayHelperPreOrder(root.left);
            displayHelperPreOrder(root.right);
        }
    }
    public boolean search(int key){
        return searchHelper(root, key);
    }
    private boolean searchHelper(Node root, int key){
        if(root == null){ //cant search anything if tree is empty
            return false;
        }
        else if(root.key == key){ //if a search is found
            System.out.println(root.toString());
            return true;
        }
        else if(root.key > key){ //if root is greater than the key, it'll search on the left
            return searchHelper(root.left, key);
        }
        else{ //if key is greater than the key, then it'll go right.
            return searchHelper(root.right, key);
        }
    }
    public void modify(int key, int changeNum, String change){ //Takes the key, and recursively finds the key, and changes
        root = modifyHelper(root, key, changeNum, change);
    }
    private Node modifyHelper(Node root, int key, int changeNum, String change){
        if(root == null){
            return null;
        }

        if(key < root.key){ //will take the left nod eif the key being search is less than the key value of the root
            root.left = modifyHelper(root.left, key, changeNum, change);
        }
        else if(key > root.key){ //will take the right node if the key being searched for is greater than the key value of the root
            root.right = modifyHelper(root.right, key, changeNum, change);
        }
        else{ //root is found. will run a switch case to decide which part of data should be changed
            switch(changeNum){
                case 1: root.setFirstName(change);
                break;

                case 2: root.setFirstName(change);
                break;

                case 3: root.setFirstName(change);
                break;

                case 4: root.setFirstName(change);
                break;

                case 5: root.setFirstName(change);
                break;
            }
        }
        return root;
    }

    public void remove(int key){
        if(search(key)){
            removeHelper(root, key);
        }
        else{ //if data is false
            System.out.println(key + " could not be found");
        }
    }
    public Node removeHelper(Node root, int key){
        if(root == null){
            return root;
        }
        else if(key < root.key){
            root.left = removeHelper(root.left, key);
        }
        else if(key > root.key){
            root.right = removeHelper(root.right, key);
        }
        else{
            if(root.left == null && root.right == null){ //if the node is a leaf (no left or right child)
                root = null;
            }
            else if(root.right != null){ //the right node will be removed
                root.key = successor(root);
                root.right = removeHelper(root.right, root.key);
            }
            else{
                root.key = predecessor(root);
                root.left = removeHelper(root.left, root.key);
            }
        }
        return root;
    }
    private int successor(Node root){ //find least value below the right child of the root.
        root = root.right; //root first takes the right side, and then keeps going down left. the farthest left will replace the node that's being removed
        while(root.left != null){
            root = root.left;
        }
        return root.key;
    }
    private int predecessor(Node root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.key;
    }

}
