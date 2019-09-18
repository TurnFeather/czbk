import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Test2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("E:/14065","enen/abc.txt");
		FileOutputStream fis = new FileOutputStream(file);
		fis.write("Hello World".getBytes());
	}

}
