import javax.swing.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String >();
        addInOrder(placesToVisit,"Delhi");
        addInOrder(placesToVisit,"Delhi");
        addInOrder(placesToVisit,"Faridabad");
        addInOrder(placesToVisit,"Jaipur");
        addInOrder(placesToVisit,"Agra");
        addInOrder(placesToVisit,"Ajmer");
        addInOrder(placesToVisit,"Alwar");
        addInOrder(placesToVisit,"Udaipur");

        //printList(placesToVisit);

        addInOrder(placesToVisit,"Mumbai");
//        printList(placesToVisit);
//
//        placesToVisit.remove(4);
//        printList(placesToVisit);
//        addInOrder(placesToVisit,"Delhi");

        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList){
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()){
            System.out.print("Now visiting " + i.next() + " -> ");
        }
        System.out.println("All places visited. ***");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()){
            int comparision = stringListIterator.next().compareTo(newCity);
            if (comparision == 0){
                //Do not add the city to the list
                System.out.println("City already exists in the list.");
                return false;
            } else if (comparision > 0) {
                //New city should appear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> linkedList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = linkedList.listIterator();
        if (linkedList.isEmpty()) {
            System.out.println("The list that you've sent is empty");
            return;
        } else {
            System.out.println("Now visiting "+ listIterator.next());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0 -> {
                    System.out.println("Vacation Over");
                    quit = true;
                }
                case 1 -> {
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Visiting :" + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                }
                case 2 -> {
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the beginning of the list");
                        goingForward = true;
                    }
                }
                case 3 -> printMenu();
            }
        }
    }

    public static void printMenu(){
        System.out.println("Available options: ");
        System.out.println("""
                Press 0 to quit.
                Press 1 to visit next city.\s
                Press 2 to visit the previous city.
                Press 3 to print menu again.
                """);
    }
}
