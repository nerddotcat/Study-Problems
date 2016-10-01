import java.util.Collections;



public class BinTree
{
	
	Node root;
	
	public BinTree()
	{
		root = null;
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
	
	//TODO: finish this
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
	
}