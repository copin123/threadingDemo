import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileWriterServie {
	String fileLocation = "/tmp/testFile";
	File myFile = new File(fileLocation);

	public void appendToFile(String text) throws IOException{
		synchronized(myFile) {
			FileWriter writer = new FileWriter(myFile, true);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(text);
			bw.close();
		}
		
	}
	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
}
