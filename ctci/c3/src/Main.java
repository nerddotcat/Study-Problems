import java.util.Stack;


public class Main
{

	public static void main(String[] args)
	{
		new Main().run();
	}
	
	public void run()
	{
		
		SetOfStacks st = new SetOfStacks(3);
		for (int i = 0; i < 10; i++)
		{
			st.push(i);
			System.out.println(st.toString());
		}
		
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.toString());
		
		
		int tohSize = 5;
		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> b = new Stack<Integer>();
		Stack<Integer> c = new Stack<Integer>();
		for (int i = 0; i < tohSize; i++)
		{
			a.add(tohSize-i);
		}
		System.out.println("Starting");
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		tohSolve(a.size(),a,b,c);
		System.out.println("Ending");
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		
		MyQueue q = new MyQueue();
		for (int i = 0; i < 5; i++)
		{
			q.enqueue(i);
		}
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		
	}
	
	/*
	 * In the classic problem of the Towers of Hanoi, you have 3 towers and Ndisks of different
	 * sizes which can slide onto any tower.Thepuzzlestartswithdiskssorted in ascending order of
	 * size from top to bottom (i.e., each disk sits on top of an even larger one).
	 */
	public void tohSolve(int height, Stack current, Stack buffer, Stack goal)
	{
		if(height > 0)
		{
			//move everything except bottom to buffer
			tohSolve(height-1, current, goal, buffer);
			
			//move bottom to goal
			goal.push(current.pop());
			
			//move buffer to goal
			tohSolve(height -1, buffer, current, goal);
			
		}
		
	}
	
	
	/*
	 * How would you design a stack which, in addition to push and pop,
	 * also hasa function min which returns the minimum element? Push,
	 * pop and min should all operate in O(1) time
	 * 
	 * - keep another stack that also stores the min value
	 * 
	 */
	
	
	
	/*
	 * Describe how you could use a single array to implement three stack.
	 * 
	 * - can statically or dynamically allocate space in array
	 * 
	 */
	
	
}
