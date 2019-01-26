import java.io.File;
import java.io.PrintStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileOutputStream;


public class TextReader {

	private BufferedReader reader;
	private ArrayList<String> wordArray = new ArrayList<>();

	// Constructor initialises buffered reader
	public TextReader(String filename) throws Exception {
		try {
			this.reader = new BufferedReader(new FileReader(new File(filename)));
		}
		catch (Exception e) {}
		addWords();
	}

	// Add words to the ArrayList
	public void addWords() {
		while (fileIsReady()) {
			String line = getLine();
			wordArray.add(line);
		}
	}

	// Return the next line from the file
	public String getLine() {
		try {
			return this.reader.readLine();
		}
		catch (Exception e) {
			System.out.println("Could not read next line, no file found");
			return null;
		}
	}

	// Check if the file is ready
	public Boolean fileIsReady() {
		try {
			return this.reader.ready();
		}
		catch (Exception e) {
			System.out.println("Could not determine if file is ready, no file found");
			return false;
		}
	}

	public ArrayList<String> getArrayList() {
		return wordArray;
	}
}

