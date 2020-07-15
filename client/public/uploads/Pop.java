import java.util.*;
import java.io.*;

class PopulateGraph
{
	static ArrayList<Integer> added = new ArrayList<Integer>();
	static ArrayList<String> combadd = new ArrayList<String>();
	public static void fill()
	{
		int edgecount = 0;
		int nodecount = 0;
		Random rand = new Random();
		int counter = 0;
		while(counter<100)
		{
			int x = rand.nextInt(100);
			if(added.indexOf(x)<0)
			{
				Node n = new Node();
				n.setLabel(x);
				added.add(x);
				counter++;
				Graph.gn.add(n);
				nodecount++;
			}
		}
		counter = 0;
		//add edges
		while(counter<105)
		{
			int x = rand.nextInt(100);
			if(added.indexOf(x)>=0)
			{
				int i = added.indexOf(x);
				int y =  rand.nextInt(100);
				if(combadd.indexOf(x+","+y)<0 && combadd.indexOf(y+","+x)<0 && added.indexOf(y)>=0 && x!=y)
				{
					int w = rand.nextInt(100);
					//Node a1 = Graph.gn.get(i);
					//Node a2 = Graph.gn.get(added.indexOf(y));
					Edge e1 = new Edge();
					Edge e2 = new Edge();
					e1.setDestination(Graph.gn.get(added.indexOf(y)));
					e1.setWeight(w);
					e2.setDestination(Graph.gn.get(i));
					e2.setWeight(w);
					Graph.gn.get(i).addEdge(e1);
					Graph.gn.get(added.indexOf(y)).addEdge(e2);
					combadd.add(x+","+y);
					counter++;
					edgecount++;
				}
			}
		}
	}
}

class Graph
{
	static ArrayList<Node> gn = new ArrayList<Node>();
}