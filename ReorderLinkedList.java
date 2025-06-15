
/**
	1. Find middle of a Linked List
	2. Reverse a Linked List
	3. Join two Linked Lists with nodes from both lists alternating b/w each other.
 */

 class Solution {
     public void reorderList(ListNode head) {
         if (head.next == null) return; 

         ListNode secondHead = findSecondHalf(head);
         ListNode firstHead = head; 
         secondHead = reverseLinkedList(secondHead);

         // Join 2 linked lists with nodes alternating b/w each other. 
         while (secondHead != null) {
             ListNode firstNode = firstHead; 
             ListNode secondNode = secondHead; 
             firstHead = firstHead.next; 
             secondHead = secondHead.next; 

             firstNode.next = secondNode; 
             secondNode.next = firstHead; 
         }

         return; 
     }

     // Finds the second half of linked list. 
     public ListNode findSecondHalf(ListNode head) {
         ListNode prev = null;
         ListNode slow = head; 
         ListNode fast = head; 

         while (fast != null && fast.next != null) {
             prev = slow;
             slow = slow.next; 
             fast = fast.next.next; 
         }

         if (fast != null) {
             prev = slow; 
             slow = slow.next; 
         }

         // Dividing the linked list into 2 halves.
         prev.next = null; 
         return slow; 
     }

     // Reverse Linked List
     public ListNode reverseLinkedList(ListNode head) {
         if (head == null) return head; 

         ListNode prev = null; 
         ListNode curr = head; 
         ListNode next = curr.next; 

         while (curr != null) {
             curr.next = prev; 
             prev = curr; 
             curr = next; 
             if (next != null) next = next.next; 
         }

         return prev; 
     }
 }