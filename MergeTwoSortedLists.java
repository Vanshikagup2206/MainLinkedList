class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        //for maintaining merged list
        ListNode dummy = new ListNode(-1);
        //pointer for dummy
        ListNode tail = dummy;

        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                tail.next = p1;//attach p1
                p1 = p1.next;//move p1
            }else{
                tail.next = p2;//attach p2
                p2 = p2.next;//move p2
            }
            tail = tail.next;//move tail forward
        }
        //leftovers
        if (p1 != null) 
            tail.next = p1;
        else 
            tail.next = p2; 
        return dummy.next;   
    }
}