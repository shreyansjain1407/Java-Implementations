import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> myContacts;

    public MobilePhone() {
        this.myContacts = new ArrayList<Contact>();
    }

    public void printContactList(){
        System.out.println("Following is your contact list");
        for (int i = 0; i < this.myContacts.size(); i++){
            System.out.println((i+1) + ": " + this.myContacts.get(i).getName());
        }
    }

    public boolean addContact(Contact contact){
        if (index(contact.getName())>=0){
            System.out.println("The contact name already exists.");
            return false;
        }

        this.myContacts.add(contact);
        return true;
    }

    public void removeContact(Contact contact){
        this.myContacts.remove(contact);
    }

    public void search(Contact contact){
        System.out.println("The phone number of this contact is: " + contact.getNumber());
    }

    public void updateContact(Contact old, Contact update){
        int pos = index(old);
        myContacts.set(pos,update);
    }

    public Contact queryContact(String name){
        int pos = index(name);
        if (pos >= 0){
            return this.myContacts.get(pos);
        }
        return null;
    }

    private int index(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int index(String name){
        for (int i = 0; i<this.myContacts.size(); i++){
            if (name.equals(this.myContacts.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

}
