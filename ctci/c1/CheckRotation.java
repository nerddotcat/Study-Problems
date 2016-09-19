

public class CheckRotation implements Testable
{
	
	/*
	 * Assume you have a method isSubstring which checks if one word is a substring of another.
	 * Given two strings, s i and s2,
	 * write code to check if s2 is a rotation of si using only one call to
	 * isSubstring (e.g.,"waterbottle"is a rota- tion of"erbottlewat").
	 *
	 */
	
	
	public String run(String input)
	{
		String[] strs = input.split(" ");
		if(strs[0].length() != strs[1].length())
			return "False";
		return ((strs[0].concat(strs[0])).indexOf(strs[1]) > -1)? "True": "False";
	}
	
	
}

