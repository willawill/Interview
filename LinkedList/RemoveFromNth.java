import java.lang.*;
// Definition for singly-linked list.
  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
     public void printList(){
        StringBuffer bf = new StringBuffer();
        bf.append(val);
        while(next != null){
            bf.append(next.val);
            next = next.next;
        }
        System.out.println(bf.toString());
     }
 }
 
public class RemoveFromNth {
    

     public static ListNode remove(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0) return head;
        int temp = n;
        ListNode p1,p2;
        p1 = head;
        p2 = head;
        
        while (temp > 0 ){
            p2 = p2.next;
            temp--;
        }
        ListNode previous = null;
        while (p2 != null){
            previous = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        previous.next = p1.next;
        return head;
    }
    public static void main(String[] args){
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
         ListNode h4 = new ListNode(4);
         ListNode h5 = new ListNode(5);
         h1.next = h2;
         h2.next = h3;
         h3.next = h4;
         h4.next = h5;
        h1 = RemoveFromNth.remove(h1,2);
        h1.printList();
    
    }
}