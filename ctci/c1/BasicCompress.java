
public class BasicCompress implements Testable
{

	public String run(String input)
	{
		StringBuilder sb = new StringBuilder();
		
		int count = 0;
		char lastChar = '\0';
		
		for (int i = 0; i < input.length(); i++)
		{
			char curChar = input.charAt(i);
			
			if(curChar != lastChar)
			{
				if(count > 0)
				{
					sb.append(lastChar);
					sb.append(count);
				}
				count = 1;
			}
			else
			{
				count++;
			}
			
			lastChar = curChar;
		}
		
		if(count > 0)
		{
			sb.append(lastChar);
			sb.append(count);
		}
		
		String candidate = sb.toString();
		if(candidate.length() >= input.length())
		{
			candidate = input;
		}
		
		return candidate;
	}
	
}
