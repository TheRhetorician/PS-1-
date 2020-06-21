import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

class scraped
{
	public static void downloadFile(URL url, String fileName) throws Exception 
	{
		try (InputStream in = url.openStream()) 
		{
			Files.copy(in, Paths.get(fileName));
		}
	}
	public static void scraping() throws Exception
	{
		URL url1 = new URL("http://localhost:3000/uploads/*.txt");
		String fileName = "try.txt";
		//URL url2 = new URL("http://localhost:3000/")
		// call to downloadFile() method
		downloadFile(url1,fileName);
	}
}