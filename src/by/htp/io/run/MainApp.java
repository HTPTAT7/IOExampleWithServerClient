package by.htp.io.run;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class MainApp {

	public static void main(String[] args) {
		InputStream is = null;

		try {
			File f = new File("resources/sample.txt");
			if (!f.exists()) {
				System.out.println("create new file");
				f.createNewFile();
			}
			// Why not read previous data ??
			try (OutputStream os = new FileOutputStream(f, true)) {
				is = new FileInputStream(f);
				int available = is.available();
				System.out.println("bytes available: " + available);
				
				byte[] data = new byte[available];
				is.read(data);
				System.out.println(new String(data));
				
				String s = "Hello Person!";
				os.write(s.getBytes());
				
				os.write("\n".getBytes());
			} // try 2
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
				} // try 3
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // try 1
		catch (IOException e) {
			e.printStackTrace();
		}
	} // main
} // class
