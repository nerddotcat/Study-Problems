import java.util.ArrayList;
import java.util.Stack;


public class SetOfStacks
{
	
	/*
	 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
	 * Therefore, in real life, we would likely start a new stack when the previous stack
	 * exceeds somethreshold. Implement a data structureSetOf Stacks that mimics this.
	 * SetOf Stacks should be composed of several stacks and should create a newstackoncethe
	 * previous oneexceedscapacity. SetOfStacks.push() and SetOfStacks.pop()
	 * 
	 */
	
	private ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	private int maxSize;
	
	
	public SetOfStacks(int maxSize)
	{
		if(maxSize < 1)
			maxSize = 1;
		this.maxSize = maxSize;
	}
	
	
	public void push(int value)
	{
		if(stacks.size() == 0)
		{
			stacks.add(new Stack());
		}
		
		if(stacks.get(stacks.size()-1).size() >= maxSize)
		{
			stacks.add(new Stack());
		}
		stacks.get(stacks.size()-1).push(value);
			
		
		
	}
	
	
	public Integer pop()
	{
		if(stacks.size() == 0)
		{
			return null;
		}
		
		Integer out = stacks.get(stacks.size()-1).pop();
		
		if( stacks.get(stacks.size()-1).size() == 0 )
		{
			stacks.remove(stacks.size()-1);
		}
		return out;
	}
	
	public Integer peek()
	{
		if(stacks.size() == 0)
		{
			return null;
		}
		return stacks.get(stacks.size()-1).peek();
	}
	
	public int getNumStacks()
	{
		return stacks.size();
	}
	
	public String toString()
	{
		StringBuilder out = new StringBuilder();
		out.append("Set of stacks:\n");
		for (int i = 0; i < stacks.size(); i++)
		{
			out.append(i+": ");
			out.append(stacks.get(i).toString());
			out.append("\n");
		}
		
		
		return out.toString();
	}
	
}
