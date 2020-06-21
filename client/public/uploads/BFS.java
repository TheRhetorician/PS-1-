// Java program to find minimum edge 
// between given two vertex of Graph 

import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Vector; 
import java.util.ArrayList;

class Test 
{ 
	// Method for finding minimum no. of edge 
	// using BFS 
	static int minEdgeBFS(Vector<Integer> edges[], int u, int v, int n) 
	{ 
		// visited[n] for keeping track of visited 
		// node in BFS 
		Vector<Boolean> visited = new Vector<Boolean>(n); 
		
		for (int i = 0; i < n; i++) { 
			visited.addElement(false); 
		} 
	
		// Initialize distances as 0 
		Vector<Integer> distance = new Vector<Integer>(n); 
		
		for (int i = 0; i < n; i++) { 
			distance.addElement(0); 
		} 
	
		// queue to do BFS. 
		Queue<Integer> Q = new LinkedList<>(); 
		distance.setElementAt(0, u); 
	
		Q.add(u); 
		visited.setElementAt(true, u); 
		while (!Q.isEmpty()) 
		{ 
			int x = Q.peek(); 
			Q.poll(); 
	
			for (int i=0; i<edges[x].size(); i++) 
			{ 
				if (visited.elementAt(edges[x].get(i))) 
					continue; 
	
				// update distance for i 
				distance.setElementAt(distance.get(x) + 1,edges[x].get(i)); 
				Q.add(edges[x].get(i)); 
				visited.setElementAt(true,edges[x].get(i)); 
			} 
		} 
		int dist = distance.get(v);
		return  dist;
	} 
	
	// method for addition of edge 
	static void addEdge(Vector <Integer> edges[], int u, int v) 
	{ 
	edges[u].add(v); 
	edges[v].add(u); 
	} 

	// Driver method 
	public static int bfs(int u, int v) 
	{ 
		// To store adjacency list of graph 
		int n = Graph.gn.size(); 
		//int n = 4;
		Vector<Integer> edges[] = new Vector[n]; 
		
		for (int i = 0; i < edges.length; i++) { 
			edges[i] = new Vector<>(); 
		} 
		for(int i=0;i<Graph.gn.size();i++)
		{
			int x = Graph.gn.get(i).label;
			for(int j=0;j<Graph.gn.get(i).edges.size();j++)
			{
				addEdge(edges, x, Graph.gn.get(i).edges.get(j).dest.label);
			}
		}
		/*int u = 3;
		int v = 1;
		addEdge(edges,0,2);
		addEdge(edges,2,3);
		addEdge(edges,0,1);*/

		int dist = minEdgeBFS(edges, u, v, n); 
		//System.out.println("dist"+dist);
		return dist;
		
	} 
} 