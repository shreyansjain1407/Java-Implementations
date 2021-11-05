import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //Tree sets are data structures that are sets which are sorted by default and implement navigable interface
        //This essentially means that we can get the first and last value and then ceil or trough value, and we can
        //also find the elements higher or lower than a given element.
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);
        treeSet.add(7);
        treeSet.add(8);
        treeSet.add(9);
        treeSet.add(10);
        System.out.println(treeSet.contains(10));
        System.out.println(treeSet.higher(5));
        System.out.println(treeSet.lower(8));
        System.out.println(treeSet);

    }
}
