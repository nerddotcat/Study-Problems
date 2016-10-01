
public class Main
{
	
	public static void main(String[] args)
	{
		new Main().run();
	}
	
	public void run()
	{
		System.out.println("hello!");
		
		BinTree bt = new BinTree();
		
		bt.bstAdd(50);
		bt.bstAdd(25);
		bt.bstAdd(75);
		bt.bstAdd(100);
		bt.bstAdd(60);
		bt.bstAdd(110);
		System.out.println(bt);
		
		System.out.printf("is balanced? %s\n", bt.checkBalance());
		
	}
	
}
