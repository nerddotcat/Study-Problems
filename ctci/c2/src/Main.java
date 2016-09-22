
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
		
		System.out.printf("c: %d - %d\n", current.data,val);
		
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
	
}
