import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main
{
	
	public static void main(String[] args)
	{
		new Main().run();
	}
	
	public void run()
	{
		
		Node head = new Node(1);
		
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(2);
		head.appendToTail(5);
		head.appendToTail(5);
		head.appendToTail(1);
		head.appendToTail(5);
		
		Node.printList(head);
		removeDupes(head);
		Node.printList(head);
		
		Node a = kthToLast(head, 1);
		if(a != null)
			System.out.println(a.data);
		a = kthToLast(head, 0);
		if(a != null)
			System.out.println(a.data);
		a = kthToLast(head, 3);
		if(a != null)
			System.out.println(a.data);
		
		a = kthToLast(head, 1);
		middleRemove(a);
		
		Node.printList(head);
		
		head.appendToTail(6);
		head.appendToTail(7);
		head.appendToTail(20);
		head.appendToTail(50);
		head.appendToTail(30);
		head.appendToTail(15);
		head.appendToTail(55);
		Node.printList(head);
		
		head = partition(head,kthToLast(head, 4));
		Node.printList(head);
		
		Node left = new Node(1);
		left.appendToTail(0);
		left.appendToTail(2);
		left.appendToTail(5);
		
		Node right = new Node(5);
		right.appendToTail(0);
		
		System.out.println(sum(left,right));
		
		
		Node p = new Node(1);
		p.appendToTail(5);
		p.appendToTail(6);
		p.appendToTail(5);
		p.appendToTail(1);
		Node.printList(p);
		System.out.println(isPalindrome(p));
		
		Node q = new Node(1);
		q.appendToTail(3);
		q.appendToTail(3);
		q.appendToTail(7);
		Node.printList(q);
		System.out.println(isPalindrome(q));
		
		Node r = new Node(1);
		r.appendToTail(2);
		r.appendToTail(3);
		r.appendToTail(4);
		r.appendToTail(5);
		//create loop
		kthToLast(r, 0).next = kthToLast(r,3);
		System.out.println(findLoop(r).data);
		
		
	}
	
	
	public Node findLoop(Node head)
	{
		Node found = null;
		
		Node cur = head;
		HashMap<Node,Node> seen = new HashMap<Node,Node>();
		while(cur != null)
		{
			
			if(seen.containsKey(cur.next))
			{
				return cur.next;
			}
			else
			{
				seen.put(cur, cur);
			}
			
			cur = cur.next;
		}
		
		
		return found;
	}
	
	/*
	 * Implement a function to check if a linked list is a palindrome. 
	 */
	
	public boolean isPalindrome(Node head)
	{
		Queue<Integer> forward = new LinkedList<Integer>();
		Stack<Integer> reverse = new Stack<Integer>();
		
		Node current = head;
		while(current != null)
		{
			forward.add(current.data);
			reverse.push(current.data);
			current = current.next;
		}
		
		int decimal = 1;
		int result = 0;
		while(!forward.isEmpty())
		{
			if(forward.poll() !=  reverse.pop())
			{
				return false;
			}
		}
		
		
		return true;
	}
	
	
	/*
	 * You have two numbers represented by a linked list, where each node contains a single digit.
	 * The digits are stored in reverse order, such that the Ts digit is at the head of the list.
	 * Write a function that adds the two numbers and returns the sum as a linked list.
	 * 
	 */
	public int sum(Node a, Node b)
	{
		
		return getVal(a) + getVal(b);
	}
	
	//returns decimal representaton of linked list
	public int getVal(Node head)
	{
		Stack<Integer> vals = new <Integer>Stack();
		
		Node current = head;
		while(current != null)
		{
			vals.push(current.data);
			current = current.next;
		}
		
		int decimal = 1;
		int result = 0;
		while(!vals.empty())
		{
			result += vals.pop() * decimal;
			decimal *= 10;
		}
		
		return result;
	}
	
	/*
	 * Write code to partition a linked list around a value x,
	 * such that all nodes less than x come before all nodes greater than or equal to x.
	 * 
	 */
	public Node partition(Node head, Node middle)
	{
		
		
		Node cur = head;
		Node lowerHead = null;
		Node higherHead = null;
		while(cur != null)
		{
			Node next = cur.next;
			
			if(cur != middle)
			{
				if(cur.data <= middle.data)
				{
					if(lowerHead == null)
					{
						lowerHead = cur;
						cur.next = null;
					}
					else
					{
						cur.next=lowerHead;
						lowerHead = cur;
					}
				}
				else
				{
					if(higherHead == null)
					{
						higherHead = cur;
						cur.next = null;
					}
					else
					{
						cur.next=higherHead;
						higherHead = cur;
					}
				}
				
			}
			
			cur = next;
		}//end while loop
		
		if( lowerHead == null )
		{
			lowerHead = middle;
			
		}
		else
		{
			kthToLast(lowerHead,0).next = middle;	
		}
		
		middle.next = higherHead;
		
		
		return lowerHead;
	}
	
	/*
	 * Implement an algorithm to delete a node in the middle of a singly linked list,
	 * given only access to that node.
	 * 
	 */
	public void middleRemove(Node node)
	{
		
		node.data = node.next.data;
		node.next = node.next.next;
		
	}
	
	/*
	 * 	Write code to remove duplicates from an unsorted linked list.
	 *	FOLLOW UP
	 *	How would you solve this problem if a temporary buffer is not allowed?
	 */
	public void removeDupes(Node head)
	{
		Node current = head;
		
		while(current != null)
		{
			recRemove(current,current.data);
			current = current.next;
		}
		
	}
	
	public void recRemove(Node current, int val)
	{
		
		if(current == null)
		{
			return;
		}
		
		//System.out.printf("c: %d - %d\n", current.data,val);
		
		if(current.next != null && current.next.data == val)
		{
			current.next = current.next.next;
			recRemove(current,val);
		}
		else
		{
			recRemove(current.next,val);
		}
		
	}
	
	public Node kthToLast(Node head,int pos)
	{
		//Node found = null;
		Stack<Node> found = new Stack<Node>();
		recKthToLast(head, found, pos);
		return found.peek();		
	}
	
	public int recKthToLast(Node current, Stack<Node> stack, int pos)
	{
		if(current == null)
		{
			return -1;
		}
		
		int sum = recKthToLast(current.next, stack, pos) + 1;
		//System.out.println(" sum " + sum);
		//System.out.println(" pos "+ pos);
		
		if(sum <= pos)
		{
			stack.push(current);
		}
		return sum;
	}
	
}
