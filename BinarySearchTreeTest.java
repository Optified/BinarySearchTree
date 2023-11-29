import java.util.Scanner;

public class BinarySearchTreeTest {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        /*tree.insert();
        tree.insert();
        tree.insert();
        tree.insert();

        tree.display();
        System.out.print("hello");
        tree.remove(1);
        tree.remove(0);
        System.out.println(tree.search(1));*/
        boolean isDone = false;
        int i = -1;

        do{
        printIntro();
        i = choice(i, tree);
        if(i == -2){
            isDone = true;
        }

        }while(isDone == false); 
    }
    public static int choice(int i, BinarySearchTree tree){
        int test = i;
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        choice = choice.toLowerCase();

        int intChoice;

        switch(choice){
            case "A": //add
            case "a": tree.insert();
            test = 0;
            break;

            case "D": //delete
            case "d": if(test == -1){
                System.out.println("The phonebook is empty. There are no contacts to delete.");
            }
            else{
                System.out.println("Which entry would you like to delete?");
                intChoice = input.nextInt();
                tree.remove(intChoice);
            }
            break;

            case "E": //edit
            case "e": if(test == -1){
                System.out.println("The phonebook is empty. There are no contacts to edit.");
            }
            break;

            case "P": //print
            case "p": if(test == -1){
                System.out.println("The phonebook is empty. There are no contacts to print.");
            }
            tree.display();
            break;

            case "S":
            case "s": if(test == -1){
                System.out.println("The phonebook is empty. There are no contacts to search.");
            }
            //tree.search(); placeholder

            case "Q": //quit
            case "q": test = -2;
            break;
        }
        if(!choice.equals("a") && !choice.equals("d") && !choice.equals("e") && !choice.equals("p") && !choice.equals("s") && !choice.equals("q")){
            System.out.println("Invalid input. Please input a proper input.");
        }
        return test;
    }
    public static void printIntro(){
        System.out.println("What would you like to do?\nInput the following commands to interact with the phonebook.\n");
        System.out.println("A: Add a contact to the phonebook");
        System.out.println("D: Delete a contact from the phonebook");
        System.out.println("E: Edit a contact from the phonebook");
        System.out.println("P: Print the current contacts within the phonebook");
        System.out.println("Q: Quit from viewing the phonebook");
    }
}
