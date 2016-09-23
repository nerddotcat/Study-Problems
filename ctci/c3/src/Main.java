
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
