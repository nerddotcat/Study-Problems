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
		
		
		
	}
	
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
