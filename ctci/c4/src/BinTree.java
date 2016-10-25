import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;



public class BinTree
{
	
	private Node root;
	
	public BinTree()
	{
		root = null;
	}
	
	public void randomAdd(int data)
	{
		SecureRandom sr = new SecureRandom();
		
		Node newNode = new Node(data);
		
		if(root == null)
		{
			root = newNode;
		}
		else
		{
			Node current = root;
			Boolean inserted = false;
			
			while(!inserted)
			{
				int temp = sr.nextInt(2);
				if(temp == 0)
				{
					if(current.left == null)
					{
						current.left = newNode;
						inserted = true;
					}
					else
					{
						current = current.left;
					}
				}
				else
				{
					if(current.right == null)
					{
						current.right = newNode;
						inserted = true;
					}
					else
					{
						current = current.right;
					}
				}
			}
			
		}
	}
	
	
	public void bstAdd(int data)
	{
		Node newNode = new Node(data);
		
		if(root == null)
		{
			root = newNode;
		}
		else
		{
			Node current = root;
			Boolean inserted = false;
			
			while(!inserted)
			{
				if(current.data > newNode.data)
				{
					if(current.left == null)
					{
						current.left = newNode;
						inserted = true;
					}
					else
					{
						current = current.left;
					}
				}
				else
				{
					if(current.right == null)
					{
						current.right = newNode;
						inserted = true;
					}
					else
					{
						current = current.right;
					}
				}
			}
			
		}
		
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	
	/*
	 * You are given a binary tree in which each node contains a value.
	 * Design an algorithm to print all paths which sum to a given value.
	 * The path does not need to start or end at the root or a leaf.
	 * 
	 */
	public void printPathsWithSum(int sum)
	{
		ArrayList<Node> path = new ArrayList<Node>();
		
		recPrintPathsWithSum(root,sum,path);
	}
	
	private void recPrintPathsWithSum(Node current, int sum,ArrayList<Node> path)
	{
		if(current == null)
		{
			return;
		}
		
		path.add(current);
		int total = 0;
		//check path for sum
		for(int i = 1; i <= path.size(); i++)
		{
			total += path.get(path.size()-i).data;
			if(total == sum)
			{
				printPath(path, path.size()-i);
			}
		}
		
		//recurse down tree
		
		recPrintPathsWithSum(current.left,sum,path);
		recPrintPathsWithSum(current.right,sum,path);
		
		//System.out.println(path);
		path.remove(path.size()-1);
		
		
	}
	
	private void printPath(ArrayList<Node> path, int dist)
	{
		StringBuilder out = new StringBuilder();
		out.append(path.get(dist).data);
		for(int i = dist+1; i < path.size(); i++)
		{
			out.append("->");
			out.append(path.get(i).data);
		}
		System.out.println(out.toString());
	}
	
	/*
	 * You have two very large binary trees: T1,
	 * with millions of nodes, and T2, with hundreds
	 * of nodes. Create an algorithm to decide if T2 is a subtree of T1.
	 * 
	 * NOTES: this is an inefficient way to do this
	 * 		a better way might be to store hashes based on a nodes children
	 * 
	 */
	public boolean hasSubTree(Node root2)
	{
		return recHasSubTrees(root, root2);
	}
	
	private boolean recHasSubTrees(Node cur1, Node root2)
	{
		if(cur1 == null)
		{
			return false;
		}
		
		
		boolean curSubTree = false;
		boolean left = false;
		boolean right = false;
		if(cur1.data == root2.data)
		{
			curSubTree = isSubtree(cur1, root2);
		}
		left = recHasSubTrees(cur1.left,root2);
		right = recHasSubTrees(cur1.right,root2);
		if(curSubTree || left || right)
		{
			return true;
		}
		
		return false;
		
	}
	
	/*
	 * recursively checks to see if we have a subtree
	 */
	private boolean isSubtree(Node cur1, Node cur2)
	{
		//its ok if both are null
		if(cur1 == null && cur2 == null)
		{
			return true;
		}
		//its not ok if only one is null
		if((cur1 == null && cur2 != null)||
			(cur1 != null && cur2 == null))
		{
			return false;
		}
		
		boolean currentEq = cur1.data == cur1.data;
		if(!currentEq)
		{
			return false;
		}
		boolean left = isSubtree(cur1.left,cur2.left);
		boolean right = isSubtree(cur1.right,cur2.right);
		return left && right;
	}
	
	/*
	 * The way i have implemented binary trees, using Node.data attribute
	 * as a unique id
	 * 
	 */
	private Node foundAncestor;
	public Node findCommonAncestor(int id1, int id2)
	{
		foundAncestor = null;
		recCommonAncestor(root,id1,id2);
		return foundAncestor;
	}
	
	private ArrayList<Integer> recCommonAncestor(Node current,int id1, int id2)
	{
		if(current == null)
		{
			return new ArrayList<Integer>();
		}
		//left,right,visit
		ArrayList<Integer> left = recCommonAncestor(current.left, id1, id2);
		ArrayList<Integer> right = recCommonAncestor(current.right, id1, id2);
		
		if( (left.contains(id1)||left.contains(id2)) && 
			(right.contains(id1)||right.contains(id2))
			)
		{
			if(foundAncestor == null)
			{
				foundAncestor = current;
			}
		}
		
		ArrayList<Integer> next = new ArrayList<Integer>(left);
		next.addAll(right);
		next.add(current.data);
		
		return next;
	}
	
	
	/*
	 * Implement a function to check if a binary tree is a binary search tree.
	 */
	public boolean isBST()
	{
		return recIsBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean recIsBst(Node n, int min, int max)
	{
		if(n == null)
		{
			return true;
		}
		
		boolean check = true;
		
		if( n.data < min || n.data >= max)
		{
			check = false;
		}
		
		boolean left = recIsBst(n.left,min,n.data);
		boolean right = recIsBst(n.right,n.data+1,max);
		
		return check && left && right;
	}
	
	public ArrayList<LinkedList<Node>> getDepthLists()
	{
		ArrayList<LinkedList<Node>> out = new ArrayList<LinkedList<Node>>();
		
		LinkedList<Node> toVisit = new LinkedList<>();
		toVisit.add(root);
		root.height = 0;
		
		
		while( !toVisit.isEmpty() )
		{
			Node current = toVisit.removeFirst();
			
			//add node
			if(out.size() < current.height + 1 )
			{
				out.add(new LinkedList<Node>());
			}
			out.get(current.height).addLast(current);
			
			//look at rest
			if(current.left != null)
			{
				current.left.height = current.height + 1;
				toVisit.addLast(current.left);
			}
			if(current.right != null)
			{
				current.right.height = current.height + 1;
				toVisit.addLast(current.right);
			}
		}
		
		
		return out;
	}
	
	public boolean checkBalance()
	{
		BalInfo b = new BalInfo();
		b.isBal = true;
		recCB(root,b);
		return b.isBal;
	}
	
	//i dont like this way of recording balance status
	private int recCB(Node current, BalInfo balInfo)
	{
		
		if(current == null)
		{
			return 0;
		}
		int rHeight = recCB(current.right, balInfo);
		int lHeight = recCB(current.left, balInfo);
		System.out.printf("%d : %d : %d\n", current.data, lHeight, rHeight);
		if(Math.abs(rHeight-lHeight) > 1)
		{
			//do something to note that it is not balanced
			balInfo.isBal = false;
		}
		
		return Math.max(lHeight, rHeight) + 1;
	}
	
	
	private void strTraverse(StringBuilder output, int level, Node current)
	{
		if(current == null)
		{
			return;
		}
		strTraverse(output,level+1,current.right);
		//visit
		output.append(nCopiesStr("  ", level));
		output.append(current.data);
		output.append("\n");
		strTraverse(output,level+1,current.left);
		
	}
	
	//i cant believe i am writing this :(
	private String nCopiesStr(String toCopy, int n)
	{
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < n; i++)
		{
			out.append(toCopy);
		}
		return out.toString();
	}
	
	public String toString()
	{
		StringBuilder out = new StringBuilder();
		strTraverse(out, 0, root);
		return out.toString();
	}
	
	
	
}

class BalInfo
{
	public boolean isBal = false;
}

class Node
{
	int height = -1;
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data = data;
	}
	
	public void reset()
	{
		height = -1;
	}
	
	public String toString()
	{
		return Integer.toString(data);
	}
	
}