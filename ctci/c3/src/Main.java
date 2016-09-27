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
		
		Stack<Integer> sts = new Stack<>();
		sts.push(50);
		sts.push(60);
		sts.push(10);
		sts.push(70);
		sts.push(30);
		sts.push(40);
		sts.push(100);
		sts.push(1);
		System.out.println(sts.toString());
		stackSort(sts);
		System.out.println(sts.toString());
	}
	
	/*
	 * Write a program to sort a stack in ascending order (with biggest items on top).
	 * You may use at most one additional stack to hold items, but you may not copy the
	 * elements into any other data structure (suchasan array).
	 * The stack supports the following operations: push, pop, peek, and isEmpty.
	 * 
	 * n^2 terrible sorting algorithm, fun!
	 */
	public void stackSort(Stack<Integer> st)
	{
		Stack<Integer> temp = new Stack<Integer>();
		
		int sorted = 0;
		int total = st.size();
		while(sorted < st.size())
		{
			int current = st.pop();
			int smallest = current;
			
			for (int i = 1; i < total - sorted; i++)
			{
				current = st.pop();
				if(current < smallest)
				{
					temp.push(smallest);
					smallest = current;
				}
				else
					temp.push(current);
			}
			
			st.push(smallest);
			sorted++;
			//move everything back
			while(!temp.isEmpty())
			{
				st.push(temp.pop());
			}
		}
		
		
	}
	
	
	/*
	 * In the classic problem of the Towers of Hanoi, you have 3 towers and Ndisks of different
	 * sizes which can slide onto any tower.Thepuzzlestartswithdiskssorted in ascending order of
	 * size from top to bottom (i.e., each disk sits on top of an even larger one).
	 */
	public void tohSolve(int height, Stack<Integer> current, Stack<Integer> buffer, Stack<Integer> goal)
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
