import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        while (!quit){
            System.out.println("Please input your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> printInstructions();
                case 1 -> groceryList.printList();
                case 2 -> addItem();
                case 3 -> modifyItem();
                case 4 -> removeItem();
                case 5 -> searchItem();
                case 6 -> processArrayList();
                case 7 -> quit = true;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("Please enter one of the following: ");
        System.out.println("0");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
    }

    public static void addItem(){
        System.out.println("Please enter the Item that you would like to add");
        groceryList.addItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.println("Please enter current item: ");
        String item = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Please enter replacement item: ");
        String newitwm = scanner.nextLine();
        groceryList.modifyList(item, newitwm);
    }

    public static void removeItem(){
        System.out.println("Please enter item : ");
        String item = scanner.nextLine();
        //scanner.nextLine();
        groceryList.removeItem(item);
    }

    public static void searchItem(){
        System.out.println("Enter the item you want to search: ");
        String search = scanner.nextLine();
        groceryList.onFile(search);
    }

    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String >();
        newArray.addAll(groceryList.getGroceryLlist());

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryLlist());
        String[] myArray = new String[groceryList.getGroceryLlist().size()];
        myArray = groceryList.getGroceryLlist().toArray(myArray);
    }
}
