
public class Node
{
	public int data;
	public Node next;
	
	public Node(int data)
	{
		this.data = data;
	}
	
	public void appendToTail(int data)
	{
		Node newNode = new Node(data);
		
		Node current = this;
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = newNode;
	}
	
	
	public static void printList(Node start)
	{
		String out = "";
		Node current = start;
		while( current != null)
		{
			out += current.data + " -> ";
			current = current.next;
			
		}
		System.out.println(out);
	}
}
