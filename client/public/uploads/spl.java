import java.io.*;
import java.util.*;

class splitfile
{
    static ArrayList<String> fp = new ArrayList<String>();

	public static void filesp() throws Exception
	{
	    Scanner sc = new Scanner(System.in);
	    System.out.println("ENTER THE NUMBER OF KILOBYTES YOU REQUIRE PER FRAGEMENT");
	    int x = sc.nextInt();
	    RandomAccessFile raf = new RandomAccessFile("try.txt", "r");
	    long bytesPerSplit = x*1024;
	    long sourceSize = raf.length();
	    long numSplits = sourceSize/bytesPerSplit; //from user input, extract it from args
	    long remainingBytes = sourceSize - (numSplits*bytesPerSplit);
	    int maxReadBufferSize = 50000* 1024; //5KB
	    for(int destIx=1; destIx <= numSplits; destIx++) 
	    {
	        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split"+destIx+".txt"));
	        fp.add("split"+destIx+".txt");
	        if(bytesPerSplit > maxReadBufferSize) 
	        {
	            long numReads = bytesPerSplit/maxReadBufferSize;
	            long numRemainingRead = bytesPerSplit % maxReadBufferSize;
	            for(int i=0; i<numReads; i++) 
	            {
	                readWrite(raf, bw, maxReadBufferSize);
	            }
	            if(numRemainingRead > 0) 
	            {
	                readWrite(raf, bw, numRemainingRead);
	            }
	        }
	        else 
	        {
	            readWrite(raf, bw, bytesPerSplit);
	        }
	        bw.close();
	    }
	    if(remainingBytes > 0) 
	    {
	        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split"+(numSplits+1)+".txt"));
	        readWrite(raf, bw, remainingBytes);
	        fp.add("split"+(numSplits+1)+".txt");
	        bw.close();
	    }
	        raf.close();
	}

	static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException 
	{
	    byte[] buf = new byte[(int) numBytes];
	    int val = raf.read(buf);
	    if(val != -1) 
	    {
	        bw.write(buf);
	    }
	}
}