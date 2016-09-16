import java.util.ArrayList;



public class Test
{
	ArrayList<ArrayList<String>> testCases = new ArrayList<ArrayList<String>>();
	Testable testClass;
	
	public Test(Testable tc)
	{
		this.testClass = tc;
	}
	
	public void addTest(String in, String out)
	{
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(in);
		temp.add(out);
		testCases.add(temp);
	}
	
	public void runTests()
	{
		int successNum = 0;
		int failNum = 0;
		System.out.printf("running %d tests...\n", testCases.size());
		
		for(int i = 0; i < testCases.size(); i++)
		{
			String out = testClass.run(testCases.get(i).get(0));
			
			if( out.equals(testCases.get(i).get(1)))
			{
				//test passed
				successNum++;
				System.out.printf("%s > %s : passed\n", testCases.get(i).get(0), out);
			}
			else
			{
				//test failed
				failNum++;
				System.out.printf("%s > %s : failed\n", testCases.get(i).get(0), out);
			}
			
		}
		
		System.out.printf("%s passed\n%s failed\n", successNum, failNum);
		
	}
	
	
	
}


