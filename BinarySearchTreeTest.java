import java.util.Scanner;

public class BinarySearchTreeTest {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree(); //creates a binary tree object
        boolean isDone = false; //menu continues going if false.
        int i = -1;

        do{
        printIntro();
        i = choice(i, tree);
        if(i == -2){
            isDone = true;
        }

        }while(isDone == false); 
    }
    public static int choice(int i, BinarySearchTree tree){ //starts the menu, and takes the binary search tree and returns an object to know whn to stop the menu
        int test = i;
        Scanner input = new Scanner(System.in); //
        String choice = input.next();
        choice = choice.toLowerCase();

        int intChoice;

        switch(choice){ //the switch for the menu
            case "A": //adds a assigns a UID with credentials to the search tree
            case "a": tree.insert();
            test = 0; //allows for delete, edit, print, and search to work if add has been issued at least once
            break;

            case "D": //deletes
            case "d": if(test == -1){ //will only delete if something has been added first
                System.out.println("The search is empty. There are no contacts to delete.");
            }
            else{
                System.out.println("Which entry would you like to delete?");
                intChoice = input.nextInt();
                tree.remove(intChoice);
            }
            break;

            case "E": //edit
            case "e": if(test == -1){ //will only edit
                System.out.println("The search is empty. There are no contacts to edit.");
            }
            else{
                System.out.println("Input the UID in which you would like to edit: ");
                intChoice = input.nextInt();
                System.out.println("Please input which field you want to edit:\n1: First name\n2: Last name\n3: City\n4: Number: \n5: Address\n6: Quit");
                int choiceTwo = input.nextInt();

                System.out.println("What is your input into this contact");
                choice = input.next();
                tree.modify(intChoice, choiceTwo, choice);
            }
            break;

            case "P": //print
            case "p": if(test == -1){
                System.out.println("The search is empty. There are no contacts to print.");
            }
            System.out.println("Which of the search methods would you like to use?\n1: In order\n2: Post order\n3: Pre order");
            intChoice = input.nextInt();
            tree.display(intChoice);
            break;

            case "S":
            case "s": if(test == -1){
                System.out.println("The search is empty. There are no contacts to search.");
            }
            System.out.println("Input UID for search:");
            intChoice = input.nextInt();
            tree.search(intChoice);
            break;

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
        System.out.println("What would you like to do?\nInput the following commands to interact with the database.\n");
        System.out.println("A: Add a user to the database");
        System.out.println("D: Delete a contact from the database");
        System.out.println("E: Edit a contact from the database");
        System.out.println("P: Print the UIDs of all users within the database");
        System.out.println("S: Search for a specific user by their UID.");
        System.out.println("Q: Quit from viewing the database");
    }
}
