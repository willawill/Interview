/*
This isn't the same version with the one from CareerCUp.
  3-4-5 
+ 1-7-0  Padding afterward.
--------
4-1-6
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        int s1 = size(l1);
        int s2 = size(l2);
        int diff = Math.abs(s1-s2);
        if (s1 >=s2)
            l2 = padding(l2,diff);//Java is passing by value. make a copy of the parameter. 
        else
            l1 = padding(l1,diff);
        
  
        int carry = 0;
        int value = 0;
        ListNode result = null;
        ListNode tail = null;
        while (l1 != null && l2 != null){
            if (carry != 0){
                value = value + carry;
            }
            value += l1.val + l2.val;
            if (value >= 10){
                carry = value/10;
                value = value%10;
            }
            else{
                carry = 0;
            }
            
            ListNode temp =  new ListNode(value);
            if (tail != null)
                tail.next = temp;
            else
                tail = temp;
            if (result == null){
                result = temp;
            }
            
            l1 = l1.next;
            l2 = l2.next;
            value =0;
            tail = temp;
        }
        if (carry != 0){
            ListNode temp =  new ListNode(carry);
            tail.next = temp;
            tail = temp;
        }
        return result;
       
    }

    private int size(ListNode l){
        int s = 0;
        while (l!=null){
            s++;
            l = l.next;
        }
        return s;
    }
    private ListNode padding(ListNode l,int pad){
        ListNode tail = l;
        while(tail.next != null){
            tail = tail.next;
        }//Find the tail. dont set it as while(tail != null). it goes to the null pointer.
        while(pad > 0){
            
            ListNode temp = new ListNode(0);
            tail.next = temp;
            tail = temp;
            pad--;
        }
        return l;
        
    }
}