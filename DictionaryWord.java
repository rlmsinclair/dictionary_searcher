import java.util.ArrayList;

public class DictionaryWord {

	String word;
	String[] description;
	int descriptionLength;

	// The description String[] starts with the main word
	public DictionaryWord(String word, String[] description, int descriptionLength) {
		this.word = word;
		this.description = description;
		this.descriptionLength = descriptionLength;
	}

	public String getWord() {
		return this.word;
	}

	public String[] getDescription() {
		return this.description;
	}



}
