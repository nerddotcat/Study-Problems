import java.util.HashMap;


public class CheckPermutation implements Testable
{
	/*
	 * Given two strings, write a method to decide if one is a permutation of the other.
	 * 
	 * New lines are used to separate strings with this solution.
	 * 
	 */
	
	/*
	 * Input is newline separated strings
	 * checks to see if strings are permutations of each other
	 * 
	 * returns string "True" or "False" depending if strings are permutations
	 * 
	 * (non-Javadoc)
	 * @see Testable#run(java.lang.String)
	 */
	public String run(String input)
	{
		//goofy way to do this
		String[] leftRight = input.split("\n");
		String left = leftRight[0];
		String right = leftRight[1];
		
		
		
		if(left.length() != right.length())
		{
			return "False";
		}
		
		HashMap<Character, Integer> leftMap = new HashMap<>();
		HashMap<Character, Integer> rightMap = new HashMap<>();
		
		for(int i = 0; i < left.length(); i++)
		{
			//left side
			Character current = left.charAt(i);
			if(leftMap.containsKey(current))
			{
				leftMap.put(current,leftMap.get(current)+1);
			}
			else
			{
				leftMap.put(current,1);
			}
			
			//right side
			current = right.charAt(i);
			if(rightMap.containsKey(current))
			{
				rightMap.put(current,rightMap.get(current)+1);
			}
			else
			{
				rightMap.put(current,1);
			}
		}
		
		//check to see if both key sets are the same
		
		for( Character key : leftMap.keySet())
		{
			if( !(rightMap.containsKey(key) && rightMap.get(key) == leftMap.get(key)) )
			{
				return "False";
			}
		}
		
		for( Character key : rightMap.keySet())
		{
			if( !(leftMap.containsKey(key) && leftMap.get(key) == rightMap.get(key)) )
			{
				return "False";
			}
		}
		
		return "True";
	}
	
	
	

}
