import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryLlist = new ArrayList<String>();

    public void addItem(String item){
        groceryLlist.add(item);
    }

    public void printList(){
        System.out.println("Itmes in grocery list: " + groceryLlist.size());
        for (int i = 0; i<groceryLlist.size(); i++){
            System.out.println((i+1) + ". " + groceryLlist.get(i));
        }
    }

    public ArrayList<String> getGroceryLlist() {
        return groceryLlist;
    }

    private void modifyList(int pos, String newitem){
        groceryLlist.set(pos, newitem);
        System.out.println("Modification Complete");
    }
    public void modifyList(String current, String newItem){
        int pos = findItem(current);
        if (pos>=0){
            modifyList(pos,newItem);
        }
    }

    private void removeItem(int pos){
        String item = groceryLlist.get(pos);
        groceryLlist.remove(pos);
    }

    public void removeItem(String newItem){
        int pos = findItem(newItem);
        if (pos>=0){
            removeItem(pos);
        }
    }

    private int findItem(String search){
        //boolean exists = groceryLlist.contains(search);
        return groceryLlist.indexOf(search);
    }

    public boolean onFile(String search){
        int pos = findItem(search);
        if(pos>=0){
            return true;
        }
        return false;
    }
}
