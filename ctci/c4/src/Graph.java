import java.util.ArrayList;
import java.util.HashMap;


public class Graph
{
	int idCounter = 0;
	
	HashMap<Integer,GNode> nodes = new HashMap<>();
	
	public Graph()
	{
		
	}
	
	
	public void addNode(int id)
	{
		if(!nodes.containsKey(id))
		{
			nodes.put(id, new GNode(id));
		}
	}
	
	public void addUndirectedEdge(int idFrom, int idTo)
	{
		addNode(idFrom);
		addNode(idTo);
		nodes.get(idFrom).addEdge(idTo);
		nodes.get(idTo).addEdge(idFrom);
	}
	
}

class GNode
{
	int id;
	
	boolean visited;
	int distance = 0;
	
	ArrayList<Integer> edges;
	
	public GNode(int id)
	{
		this.id = id;
		this.edges = new ArrayList<>();
	}
	
	public void addEdge(Integer to)
	{
		edges.add(to);
	}
	
}
