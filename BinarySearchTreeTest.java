public class BinarySearchTreeTest {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        //create a modify node

        /*tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(2));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));*/
        tree.insert();
        tree.insert();
        tree.insert();
        tree.insert();

        tree.display();
        System.out.print("hello");
        tree.remove(1);
        tree.remove(0);
        System.out.println(tree.search(1));
        /*tree.remove(5);
        tree.display();

        System.out.println(tree.search(0));
        System.out.println(tree.search(1));
        tree.remove(0); */
        
    }
}
