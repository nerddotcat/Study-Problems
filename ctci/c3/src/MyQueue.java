import java.util.Stack;


public class MyQueue
{
	/*
	 * Implement a MyQueue class which implements a queue using two stacks.
	 * 
	 */
	
	Stack<Integer> first;
	Stack<Integer> second;
	
	public MyQueue()
	{
		first = new Stack<Integer>();
		second = new Stack<Integer>();
	}
	
	public void enqueue(int value)
	{
		first.push(value);
	}
	
	public int dequeue()
	{
		Integer out = null;
		
		//move everything to the second queue
		moveToStack(first,second);
		out = second.pop();
		moveToStack(second,first);
	
		
		return out;
	}
	
	//move everything from s1 into s2
	private void moveToStack(Stack<Integer> s1, Stack<Integer> s2)
	{
		int to = s1.size();
		for (int i = 0; i < to; i++)
		{
			s2.push(s1.pop());
		}
	}
	
	public String toString()
	{
		return String.format("----\n%s\n%s\n",first.toString(),second.toString());
	}
	
	
}
