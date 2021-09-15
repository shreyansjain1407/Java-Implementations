import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Shreyans", 100.01);
        Customer anotherCustomer = customer;
        anotherCustomer.setBalance(1000);
        System.out.println("Balance for customer "+customer.getName()+" is "+customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(30);
        intList.add(40);

        for (int i = 0; i<intList.size(); i++){
            System.out.println(intList.get(i));;
        }

        intList.add(1,20);
        for (int i = 0; i<intList.size(); i++){
            System.out.println(intList.get(i));;
        }
    }
}
