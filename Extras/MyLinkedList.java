class MyLinkedList {

    public static class Node {
        private int val;
        private Node next;
        Node(val){
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int length = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(0);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > length) return -1;
        for (int i = 0; i<index; i++) {
            Node current = head;
            current = current.next;
        }
        return current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node add = new Node(val);
        add.next = head.next;
        head.next = add;
        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
            if (temp.next == null) {
                temp.next = new Node(val);
            }
        }
        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node temp = head;
        for (int i = 0; i<index ;i++ ) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        length++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > length) return;
        Node temp = head;
        Node curr;
        for (int i = 0; i<index; i++) {
            curr = temp;
            temp = temp.next;
        }
        curr = temp.next;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */