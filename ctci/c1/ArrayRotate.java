import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotate implements Testable
{
	
	
	/*
	 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
	 * write a method to rotate the image by 90 degrees. Can you do this in place?
	 * 
	 * 
	 * 
	 */

	public String run(String input)
	{
		Scanner sc = new Scanner(input);

		int size = sc.nextInt();
		int[][] vals = new int[size][size];

		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				vals[i][j] = sc.nextInt();
			}
		}
		
		//
		for (int i = 0; i < size / 2; i++)
		{
			for (int j = i; j < vals.length - 1 - i; j++)
			{
				int temp;
				int temp2;
				// swap tr
				temp = vals[j][vals.length - 1 - i];// right
				vals[j][vals.length - 1 - i] = vals[i][j];

				// swap rb
				temp2 = vals[vals.length - 1 - i][vals.length - 1 - j];
				vals[vals.length - 1 - i][vals.length - 1 - j] = temp;
				temp = temp2;

				// swap bl
				temp2 = vals[vals.length - 1 - j][i];
				vals[vals.length - 1 - j][i] = temp;
				temp = temp2;

				// swap lt
				vals[i][j] = temp;

			}

		}
		
		return sqString(vals);
	}

	public String sqString(int[][] ar)
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

	public void sqPrint(int[][] ar)
	{
		for (int i = 0; i < ar.length; i++)
		{
			System.out.println(Arrays.toString(ar[i]));
		}

	}

}
