import java.util.Scanner;

public class BinarySearchTreeTest {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
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
                System.out.println("The search is empty. There are no contacts to delete.");
            }
            else{
                System.out.println("Which entry would you like to delete?");
                intChoice = input.nextInt();
                tree.remove(intChoice);
            }
            break;

            case "E": //edit
            case "e": if(test == -1){
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
            tree.display();
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
