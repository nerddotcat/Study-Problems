import java.util.Arrays;



public class Lcs
{
	
	public static void main(String[] args)
	{
		new Lcs().run();
	}
	
	
	public void run()
	{
		
		System.out.println(lcs("hello world","h11e1111l222l333o4444 53w555o1234r1234l1235d444"));
		
		
	}
	
	public String lcs(String a, String b)
	{
		
		
		int[][] lengths = new int[a.length()+1][b.length()+1];
		int[][] paths = new int[a.length()+1][b.length()+1];
		
		
		//generate lookup table
		for( int i = 1; i <= a.length(); i++)
		{
			for(int j = 1; j <= b.length(); j++)
			{
				
				if(a.charAt(i-1) == b.charAt(j-1))
				{
					lengths[i][j] = lengths[i-1][j-1] + 1;
					paths[i][j] = 1;
				}
				else
				{
					lengths[i][j] = Math.max(lengths[i-1][j], lengths[i][j-1]);
					if(lengths[i-1][j] > lengths[i][j-1])
					{
						paths[i][j] = 2;
					}
					if(lengths[i-1][j] < lengths[i][j-1])
					{
						paths[i][j] = 3;
					}
					if(lengths[i-1][j] == lengths[i][j-1])
					{
						paths[i][j] = 4;
					}
					
				}
			}
		}
		/*
		gridPrint(paths);
		System.out.println("---------");
		gridPrint(lengths);
		*/
		StringBuilder path = new StringBuilder();
		int curRow = a.length();
		int curCol = b.length();
		
		while( curRow > 0 && curCol > 0)
		{
			
			if(paths[curRow][curCol] == 1)
			{
				//System.out.println(a.charAt(curRow-1));
				path.append(a.charAt(curRow-1));
				curRow--;
				curCol--;
			}
			else if(paths[curRow][curCol] == 2)
			{
				curRow--;
			}
			else
			{
				curCol--;
			}
		}
		
		
		return path.reverse().toString();
	}
	
	public void gridPrint(int[][] ar)
	{
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.printf("%d, ",ar[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
}



