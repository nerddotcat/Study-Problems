import java.util.Scanner;

public class ZeroRowCol implements Testable
{

	public String run(String input)
	{
		Scanner sc = new Scanner(input);

		int rowSize = sc.nextInt();
		int colSize = sc.nextInt();
		int[][] vals = new int[rowSize][colSize];
		int[][] out = new int[rowSize][colSize];
		for (int i = 0; i < rowSize; i++)
		{
			for (int j = 0; j < colSize; j++)
			{
				vals[i][j] = sc.nextInt();
				out[i][j] = vals[i][j];
			}
		}

		for (int i = 0; i < rowSize; i++)
		{
			for (int j = 0; j < colSize; j++)
			{
				if (vals[i][j] == 0)
				{
					zeroRowCol(out, i, j);
				}
			}
		}

		return arString(out);
	}

	public void zeroRowCol(int[][] ar, int row, int col)
	{

		for (int i = 0; i < ar[row].length; i++)
		{
			ar[row][i] = 0;
		}
		for (int i = 0; i < ar.length; i++)
		{
			ar[i][col] = 0;
		}

	}

	public String arString(int[][] ar)
	{
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < ar.length; i++)
		{
			for (int k = 0; k < ar.length; k++)
			{

				out.append(ar[i][k]);
				if (k != ar.length - 1)
					out.append(" ");
			}
			out.append("\n");
		}
		return out.toString();
	}

}
