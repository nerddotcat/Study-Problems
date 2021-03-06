
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
		
		
		ArrayRotate ar = new ArrayRotate();
		Test arTest = new Test(ar);
		arTest.addTest("4\n" +
				"1 2 3 4\n" +
				"5 6 7 8\n" +
				"9 10 11 12\n" +
				"13 14 15 16\n",
				"13 9 5 1\n" +
				"14 10 6 2\n" +
				"15 11 7 3\n" +
				"16 12 8 4\n");
		arTest .runTests();
		
		ZeroRowCol zrc = new ZeroRowCol();
		Test zrcTest = new Test(zrc);
		zrcTest.addTest("4 4\n" +
				"1 2 3 4\n" +
				"5 0 7 8\n" +
				"9 10 11 12\n" +
				"13 14 15 16\n",
				"1 0 3 4\n" +
				"0 0 0 0\n" +
				"9 0 11 12\n" +
				"13 0 15 16\n");
		zrcTest.addTest("4 4\n" +
				"1 2 3 4\n" +
				"5 0 7 8\n" +
				"9 10 11 12\n" +
				"13 14 15 0\n",
				"1 0 3 0\n" +
				"0 0 0 0\n" +
				"9 0 11 0\n" +
				"0 0 0 0\n");
		zrcTest .runTests();
		
		CheckRotation cr = new CheckRotation();
		Test crTest = new Test(cr);
		crTest.addTest("waterbottle erbottlewat", "True");
		crTest.addTest("waterbottle erottlewaa", "False");
		crTest.addTest("2222 erbottlewa", "False");
		crTest.addTest("111 111111", "False");
		crTest.addTest("world orldw", "True");
		crTest.addTest("wakka Wakka", "False");
		crTest.runTests();
		
		
	}
	
}


