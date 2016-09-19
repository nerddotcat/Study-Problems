
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
		
		
		Replace rep = new Replace();
		Test repTest = new Test(rep);
		repTest.addTest("Hello World", "Hello%20World");
		repTest.addTest("racecar", "racecar");
		repTest.addTest("  a b c d", "%20%20a%20b%20c%20d");
		repTest.runTests();
		
		BasicCompress bs = new BasicCompress();
		Test bcTest = new Test(bs);
		bcTest.addTest("aabcccccaaa", "a2b1c5a3");
		bcTest.addTest("racecar", "racecar");
		bcTest.addTest("", "");
		bcTest.addTest("aaaaaaaaaa", "a10");
		bcTest.runTests();
		
	}
	
}


