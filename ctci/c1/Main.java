
public class Main
{
	public static void main(String[] args)
	{
		new Main().run();
	}
	
	public void run()
	{
		System.out.println("hello world");
		
		
		UniqueChars uc = new UniqueChars();
		Test ucTest = new Test(uc);
		ucTest.addTest("not unique and junk", "False");
		ucTest.addTest("abcdefghijklmnop1234567890 !@#$%^&*", "True");
		ucTest.runTests();
		
		ReverseString rs = new ReverseString();
		Test rsTest = new Test(rs);
		rsTest.addTest("Hello World", "dlroW olleH");
		rsTest.addTest("racecar", "racecar");
		rsTest.runTests();
		
		//String input = "abcd1234";
		//System.out.printf("in: %s\nout: %s\n", input, uc.run(input));
		
		
	}
	
}


