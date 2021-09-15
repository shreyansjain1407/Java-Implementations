import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Printing using a lambda expression");
            System.out.println("XYZ");
            System.out.println("Wiiiiiiiiiiiiiiiiiiiiii");
        }).start();

        Employee john = new Employee("John Doe", 21);
        Employee guggi = new Employee("Kshitij Bhatia", 23);
        Employee barfi = new Employee("Rohit Gupta", 23);

        List<Employee> list = new ArrayList<>();
        list.add(john);
        list.add(guggi);
        list.add(barfi);

        //Regular way to sort the names in the list
//        Collections.sort(list, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        Collections.sort(list, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));

        for (Employee e : list){
            System.out.println(e.getName());
        }
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}