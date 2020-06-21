import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

class Insert
{
	public static void insert(ArrayList<Node> gn)
	{
		ArrayList<Integer> occ = new ArrayList<Integer>();
		int frag = splitfile.fp.size();
		System.out.println(splitfile.fp.size());
		int i = 0;
		int flag = 0;
		int n = gn.size();
		Random rand = new Random();
		System.out.println(splitfile.fp);
		while(i<frag)
		{
			int x = rand.nextInt(n);
			int y = PopulateGraph.added.indexOf(x);
			if(y>=0)
			{
				if(occ.indexOf(x)<0)
				{

					/*int dist = 4;
					for(int k=0;k<occ.size();k++)
					{
						int v = PopulateGraph.added.indexOf(occ.get(k));
						int alfa = Test.bfs(x,v);
						if(alfa<dist)
						dist=alfa;
					}
					if(dist<4)
					{
						flag = 1;
						break;
					}*/
					for(int j=0;j<gn.get(y).edges.size();j++)
						if(occ.indexOf(gn.get(y).edges.get(j).dest.label)>=0)
						{
							flag = 1;
							break;
						}
						
					if(flag == 1)
					{
						flag = 0;
						continue;
					}
					gn.get(y).str = splitfile.fp.get(i);
					System.out.println(gn.get(y).label+" "+gn.get(y).str);
					i++;
					occ.add(x);
				}
			}
		}
	}
	public static void main(String args[])
	{
		PopulateGraph.fill();
		try
		{
			scraped.scraping();
			splitfile.filesp();
			insert(Graph.gn);
		}
		catch(Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
		for(int i=0; i<Graph.gn.size(); i++)
		{
			for(int j=0;j<Graph.gn.get(i).edges.size();j++)
				System.out.print(Graph.gn.get(i).label+"("+Graph.gn.get(i).str+")"+"->"+Graph.gn.get(i).edges.get(j).dest.label+"("+Graph.gn.get(i).edges.get(j).dest.str+") \t");
			System.out.println();
		}
	}
}