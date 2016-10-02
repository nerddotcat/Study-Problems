
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
		
		Graph g = new Graph();
		g.addDirectedEdge(1, 2);
		g.addDirectedEdge(2, 3);
		g.addDirectedEdge(2, 4);
		g.addDirectedEdge(4, 5);
		g.addDirectedEdge(6, 3);
		g.addDirectedEdge(3, 1);
		
		System.out.printf("Path from 1 to 5: %s\n",g.directedPathExists(1, 5));
		System.out.printf("Path from 1 to 6: %s\n",g.directedPathExists(1, 6));
		System.out.printf("Path from 6 to 1: %s\n",g.directedPathExists(6, 1));
		System.out.printf("Path to/from 6 and 1: %s\n",g.directedPathExists(1, 6)||g.directedPathExists(6, 1));
		
	}
	
}
