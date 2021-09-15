//Find a better way to do this by using cur instead of cur.next
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head.next;
        ListNode x = head;
        
        while(cur != null){
            if(cur.val<x.val){
                x.next = x.next.next;
                ListNode temp = head;
                if(cur.val<temp.val){
                    cur.next = temp;
                    head = cur;
                }else{
                    while(temp.next != null){
                        if(cur.val<temp.next.val){
                            cur.next = temp.next;
                            temp.next = cur;
                            break;
                        }
                        temp = temp.next;
                    }
                }
                cur = x.next;
                continue;
            }
            cur = cur.next;
            x = x.next;
        }
        return head;
    }
}