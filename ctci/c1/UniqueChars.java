
import java.util.Scanner;

public class UniqueChars implements Testable
{
	/*
	 * Implement an algorithm to determine if a string has all unique characters.
	 * What if you cannot use additional data structures?
	 * 
	 */
	private StringBuffer output;
	private String input;
	
	public UniqueChars()
	{
			output = new StringBuffer();
	}
	
	
	public String run(String input)
	{
		boolean isUnique = true;
		//create a buffer to count number of each chars seen
		int[] charCounts = new int[256];
		
		//scan string, create counts
		for(int i = 0; i < input.length(); i++ )
		{
			int current = input.charAt(i);
			charCounts[current]++;
			if(charCounts[current] > 1)
			{
				isUnique = false;
			}
			
		}
		
		
		return (isUnique)?"True":"False";
	}

	
}


