
public class ReverseString implements Testable
{
	
	/*
	 * 1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null- terminated string.
	 * 
	 * Well it's not c or c++ but it would be done in pretty much the same way
	 * 
	 */
	
	public String run(String input)
	{
		char[] out = input.toCharArray();
		
		for(int i = 0; i < out.length/2; i++)
		{
			char temp = out[i];
			out[i] = out[out.length-1-i];
			out[out.length-1-i] = temp;
		}
		
		return new String(out);
	}
	
	
}
