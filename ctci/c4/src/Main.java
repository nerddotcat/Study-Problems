public class Main
{
	
	/*
	 * now complete!
	 * 
	 */
	
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

		System.out.printf("Path from 1 to 5: %s\n", g.directedPathExists(1, 5));
		System.out.printf("Path from 1 to 6: %s\n", g.directedPathExists(1, 6));
		System.out.printf("Path from 6 to 1: %s\n", g.directedPathExists(6, 1));
		System.out.printf("Path to/from 6 and 1: %s\n",
				g.directedPathExists(1, 6) || g.directedPathExists(6, 1));
		
		
		BinTree bt2 = new BinTree();
		int[] ar = {1,2,3,4,5,6,7,8,9,10};
		arrayToBST(bt2,ar,0,ar.length);
		System.out.println(bt2);
		
		System.out.println(bt2.getDepthLists());
		System.out.println(bt2.isBST());
		bt2.randomAdd(100);
		System.out.println(bt2);
		System.out.println(bt2.isBST());
		
		System.out.println(bt2.findCommonAncestor(7, 100));
		
		BinTree bt3 = new BinTree();
		bt3.bstAdd(9);
		bt3.bstAdd(8);
		bt3.bstAdd(10);
		bt3.bstAdd(7);
		System.out.println(bt3);
		System.out.println(bt2.hasSubTree(bt3.getRoot()));
		
		
		bt2.printPathsWithSum(9);
	}
	
	
	/*
	 * Write an algorithm to find the'next'node (i.e., in-order successor) of a given node in a binary search tree.
	 * You may assume that each node has a link to its parent.
	 * 
	 * left, visit, right
	 * 
	 * dont feel like updating all the binary tree code right now:
	 * to find a successor
	 * if node -> right not null
	 * 		node -> right -> left until null
	 * else if parent == null
	 * 		node -> right -> left until null
	 * else
	 * 		node -> parent -> right -> left until null
	 * 
	 */
	
	/*
	 * Given a sorted (increasingorder) array with unique integer elements,
	 * write an algorithm to createa binary search tree with minimal height.
	 */
	public void arrayToBST(BinTree bt, int[] ar, int low, int high)
	{
		if(low >= high)
		{
			return;
		}
		int middle = (low+high)/2;
		bt.bstAdd(ar[middle]);
		arrayToBST(bt,ar,low,middle);
		arrayToBST(bt,ar,middle+1,high);
	}
	
}
