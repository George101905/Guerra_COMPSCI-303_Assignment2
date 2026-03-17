import java.util.*;
public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Pick Single Linked List or Stack:");
            System.out.println("1) Stack");
            System.out.println("2) Single Linked List");
            System.out.print("Choose program: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                Stack stack = new Stack();
            
                try{
                    System.out.println("Is stack empty? " + stack.isEmpty());

                    stack.push(10);
                    stack.push(20);
                    stack.push(30);

                    System.out.println("Popped: " + stack.pop());
                    System.out.println("Top element: " + stack.peek());
                    System.out.println("Average :" + stack.average());
                    System.out.println("Stack size: " + stack.size());
                } catch (Exception E){
                    System.out.println("Error: Stack operation failed.");
                }
            } else if (choice == 2) {
                SingleLinkedList<Integer> list = new SingleLinkedList<>();
                runListMenu(list, scanner);
            } else {
                System.out.println("Invalid choice.");
            }
        } catch(Exception E) {
            System.out.println("Error: Please enter a valid number");
        }
        scanner.close();
    }

    public static void runListMenu(SingleLinkedList<Integer> list, Scanner scanner){
        while(true) {
            try {
                System.out.println("\n--- LINKED LIST MENU ---");
                System.out.println("1) Add First");
                System.out.println("2) Add Last");
                System.out.println("3) Remove First");
                System.out.println("4) Remove Last");
                System.out.println("5) Get First");
                System.out.println("6) Get Last");
                System.out.println("7) Insert by Index");
                System.out.println("8) Remove at Index");
                System.out.println("9) Find");
                System.out.println("0) Quit");
                System.out.println("Please enter your choice: ");

                int choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        System.out.print("Enter value: ");
                        list.addFirst(scanner.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter value: ");
                        list.addLast(scanner.nextInt());
                        break;
                    case 3:
                        System.out.println("Removed: " + list.removeFirst());
                        break;
                    case 4:
                        System.out.println("Removed: " + list.removeLast());
                        break;
                    case 5:
                        System.out.println("First: " + list.getFirst());
                        break;
                    case 6:
                        System.out.println("Last: " + list.getLast());
                        break;
                    case 7:
                        System.out.print("Enter an index: ");
                        int idx = scanner.nextInt();
                        System.out.print("Enter a value: ");
                        int val = scanner.nextInt();
                        list.insert(idx,val);
                        break;
                    case 8:
                        System.out.print("Enter an index: ");
                        int reidx = scanner.nextInt();
                        if(!list.remove(reidx)) {
                            System.out.println("Invalid index.");
                        }
                        break;
                    case 9:
                        System.out.print("Enter a value: ");
                        int findVal = scanner.nextInt();
                        int result = list.find(findVal);
                        if(result == listSize(list)){
                            System.out.println("Value not found.");
                        } else {
                            System.out.println("Index: " + result);
                        }
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error:Invalid input or operation.");
                scanner.nextLine();
            }
        }
    }

    public static int listSize(SingleLinkedList<Integer> list) {
        int count = 0;
        try {
            while (true) { 
                list.getLast();
                break;
            }
        } catch (Exception e) {
            return 0;
        }
        return count;
    }
}
