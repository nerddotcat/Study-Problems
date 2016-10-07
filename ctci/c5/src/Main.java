
public class Main
{
	public static void main(String[] args)
	{
		new Main().run();
	}
	
	public void run()
	{
		int a = 0b111000;
		int b = 0b000101;
		int c = setBit(a,0,1);
		System.out.printf("%s\n",Integer.toBinaryString(c));
		printBin(a,b,bitInsert(a,b,3,1));
		//System.out.printf("%s\n",Integer.toBinaryString(bitInsert(a,b,3,1)));
		
	}
	
	public void printBin(int a, int b, int c)
	{
		System.out.printf("%32s\n",Integer.toBinaryString(a));
		System.out.printf("%32s\n",Integer.toBinaryString(b));
		System.out.printf("--------------------------------\n");
		System.out.printf("%32s\n",Integer.toBinaryString(c));
	}
	
	/*
	 * Explainwhatthefollowingcodedoes:((n & (n-1)) == 0)
	 * 
	 * 100 - 1 = 011 & 100 -> 0
	 * 
	 * 101 - 1 = 100 & 101 -> 100
	 * 110 - 1 = 101 & 110 -> 100 
	 * 1100 - 1 = 1011 & 1100 -> 1000
	 * 
	 * check to see if the value is a power of two
	 */
	
	/*
	 * You are given two 32-bit numbers, Nand M, and two bit positions, l a n d j . Write 
	 * a method to insert M into Nsuch that M starts at bit j and ends at bit i. You can
	 * assume that the bits j through i have enough space to fit all of M.
	 */
	public int bitInsert(int n, int m, int i, int j)
	{
		int out = n;
		for(int k = 0; k < i-j; k++)
		{
			int bit = (m>>k) & 1;
			System.out.println(bit);
			out = setBit(out,j+k,bit);
		}
		
		return out;
	}
	
	public int setBit(int num, int pos, int val)
	{
		int position = 1 << pos;
		val = val << pos;
		num = num & (~position);
		return num | val;
	}
	
}
