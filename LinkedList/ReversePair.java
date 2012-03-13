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
 
public class ReversePair {
    public static ListNode swapPairs(ListNode head) {
        if (head == null||head.next == null)  return head;
         ListNode current = head;
         ListNode previous = null;
         head = head.next;
         while (current != null && current.next != null){

             current = swap(current, current.next);
             if (previous == null){
                 previous = current.next;//link the pair.
                 
             }
             else{
                 previous.next = current;
                 previous = current.next;
             }
             current = previous.next;
             

         }
         return head;
        
    }
    private static ListNode swap(ListNode n1, ListNode n2){//Return the head of the pair
        ListNode temp = n2.next;
        n2.next = n1;
        n1.next = temp;
        return n2;
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
        h1 = ReversePair.swapPairs(h1);
        h1.printList();
    
    }
}