
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
		
		CheckPermutation cperm = new CheckPermutation();
		Test cpermTest = new Test(cperm);
		cpermTest.addTest("hello\nolleh", "True");
		cpermTest.addTest("abcdef\nabcdef", "True");
		cpermTest.addTest("abcdef\nabccef", "False");
		cpermTest.addTest("abccef\nabcdef", "False");
		cpermTest.addTest("1111111\n2222222222", "False");
		cpermTest.runTests();
		
		
		
	}
	
}


