import java.util.*;
import java.io.*;


class Node
{
	int label;
	String str;
	ArrayList<Edge> edges;

	public Node()
	{
		label = 0;
		str = "";
		edges = new ArrayList<Edge>();
	}
	public void setLabel(int label)
	{
		this.label = label;
	}
	public void setFile(String str)
	{
		this.str = str;
	}
	public void addEdge(Edge e)
	{
		this.edges.add(e);
	}

	public static void main(String args[])
	{
		Node n = new Node();
        n.setLabel(1);
        Node b = new Node();
        b.setLabel(2);
        Edge e = new Edge();
        e.setDestination(b);
        e.setWeight(3);
        n.addEdge(e);

        System.out.println(n.edges.get(0).dest.label);
         
	}
}