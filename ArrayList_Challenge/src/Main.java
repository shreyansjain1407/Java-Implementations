import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {
        System.out.println("Welcome to your mobile phone.");
        boolean quit = false;
        int choice;
        printMenu();
        while(!quit){
            System.out.println("Please enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 -> printMenu();
                case 1 -> mobilePhone.printContactList();
                case 2 -> addContact();
                case 3 -> updateContact();
                case 4 -> removeContact();
                case 5 -> searchContact();
                case 6 -> quit = true;
            }
        }
    }

    private static void searchContact() {
        System.out.println("Please enter the contact you wish to search: ");
        String search = scanner.nextLine();
        Contact exists = mobilePhone.queryContact(search);
        if (exists == null){
            System.out.println("No contact with the name " + search + " exists.");
            return;
        }
        mobilePhone.search(exists);


    }

    private static void removeContact() {
        System.out.println("Please enter the contact you wish to remove: ");
        String remove = scanner.nextLine();
        Contact exists = mobilePhone.queryContact(remove);
        if (exists == null){
            System.out.println("No contact with the name " + remove + " exists.");
            return;
        }
        mobilePhone.removeContact(exists);
        System.out.println("The contact " + remove + " has been removed.");
    }

    private static void updateContact() {
        System.out.println("Please enter the contact you wish to update: ");
        String update = scanner.nextLine();
        Contact exists = mobilePhone.queryContact(update);
        if (exists == null){
            System.out.println("No contact with the name " + update + " exists.");
            return;
        }
        System.out.println("Please enter the name you wish to update");
        String name = scanner.nextLine();
        System.out.println("Please enter the number that you wish to update");
        int number = scanner.nextInt();
        scanner.nextLine();
        mobilePhone.updateContact(exists, Contact.createContact(name,number));
    }

    private static void addContact() {
        System.out.println("PLease enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter contact phone");
        int number = scanner.nextInt();
        if(mobilePhone.addContact(Contact.createContact(name,number))){
            System.out.println("New contact added");
        }else {
            System.out.println("Contact already exists");
        }
    }

    private static void printMenu() {
        System.out.println("Phone Menu: ");
        System.out.println("0: Print Menu");
        System.out.println("1: Print the contact list");
        System.out.println("2: Add a contact");
        System.out.println("3: Update a contact");
        System.out.println("4: Remove a contact");
        System.out.println("5: Search for a contact");
        System.out.println("6: Exit");
    }


}
