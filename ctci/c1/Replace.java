
public class Replace implements Testable
{
	/*
	 * Write a method to replace all spaces in a string with'%20'.
	 * You may assume that the string has sufficient space at the 
	 * end of the string to hold the additional characters, and that
	 * you are given the "true" length of the string. (Note: if imple-
	 * menting in Java, please use a character array so that you can
	 * perform this operation in place.)
	 * 
	 * 
	 * 
	 */
	
	
	/* 
	 * the end of input should not be a space
	 * 
	 * (non-Javadoc)
	 * @see Testable#run(java.lang.String)
	 */
	public String run(String input)
	{
		//transform into char array because of 
		// the constraints of the problem
		
		//count spaces
		int numSpaces = 0;
		for (int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == ' ')
				numSpaces++;
		}
		
		char[] chars = new char[input.length() + (numSpaces*2)];
		for (int i = 0; i < input.length(); i++)
		{
			chars[i] = input.charAt(i);
		}
		
		int endPointer = chars.length-1;
		int strPointer = input.length()-1;
		
		while(strPointer >= 0)
		{
			char curChar = chars[strPointer];
			
			if( curChar == ' ')
			{
				chars[endPointer] = '0';
				chars[endPointer-1] = '2';
				chars[endPointer-2] = '%';
				endPointer-=3;
			}
			else
			{
				chars[endPointer] = chars[strPointer];
				endPointer-=1;
			}
			
			strPointer--;
		}
		
		return new String(chars);
	}
	
	
}
