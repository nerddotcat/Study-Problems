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
		
		return false;
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


class Node
{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data = data;
	}
	
}