import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class Graph
{
	int idCounter = 0;
	
	HashMap<Integer,GNode> nodes = new HashMap<>();
	
	public Graph()
	{
		
	}
	
	/*
	 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
	 */
	public boolean directedPathExists(int idFrom, int idTo)
	{
		resetNodes();
		LinkedList<Integer> toVisit = new LinkedList<Integer>();
		toVisit.addLast(idFrom);
		
		
		while(!toVisit.isEmpty())
		{
			GNode current = nodes.get(toVisit.removeFirst());
			current.seen = true;
			
			//System.out.println("visiting: " + current.id);
			if(current.id == idTo)
			{
				return true;
			}
			
			for(Integer id : current.edges)
			{
				if(!nodes.get(id).seen)
				{
					toVisit.addLast(id);
				}
				
				nodes.get(id).seen = true;
			}
			
		}
		
		return false;
	}
	
	
	public void addNode(int id)
	{
		if(!nodes.containsKey(id))
		{
			nodes.put(id, new GNode(id));
		}
	}
	
	public void addDirectedEdge(int idFrom, int idTo)
	{
		addNode(idFrom);
		addNode(idTo);
		nodes.get(idFrom).addEdge(idTo);
	}
	
	public void addUndirectedEdge(int idFrom, int idTo)
	{
		addNode(idFrom);
		addNode(idTo);
		nodes.get(idFrom).addEdge(idTo);
		nodes.get(idTo).addEdge(idFrom);
	}
	
	public void resetNodes()
	{
		for( Integer id : nodes.keySet())
		{
			nodes.get(id).reset();
		}
	}
	
}

class GNode
{
	int id;
	
	boolean seen;
	boolean visited;
	int distance = -1;
	
	ArrayList<Integer> edges;
	
	public GNode(int id)
	{
		visited = false;
		this.id = id;
		this.edges = new ArrayList<>();
	}
	
	public void addEdge(Integer to)
	{
		edges.add(to);
	}
	
	public void reset()
	{
		distance = -1;
		visited = false;
		seen = false;
	}
}
