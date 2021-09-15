class Solution{
    public Node insert(int InsertVal){
        if(head == null){
            head = new Node(insertVal, head);
            return head;
        }
        prev = head;
        cur = head.next;
        do{
            if(prev.val <= insertVal && insertVal <= cur.val){
                prev.next = new Node(insertVal, cur);
                return head;
            } else if (prev.val > cur.val){
                if(insertVal =< cur.val || insertVal >= prev.val){
                    prev.next = new Node(insertVal, cur);
                    return head;
                }
            }
            prev = cur;
            cur = cur.next;
        }while(prev != head);
        
        prev.next = new Node(insertVal,cur);
        return head;
    }
}