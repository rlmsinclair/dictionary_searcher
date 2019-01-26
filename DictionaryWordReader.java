import java.util.ArrayList;

public class DictionaryWordReader {

	private ArrayList<String> dictionaryLines;
	private TextReader textReader;
	private ArrayList<DictionaryWord> dictionaryWordArrayList = new ArrayList<>();
	private Lemmatisor lemmatisor = new Lemmatisor();

	public DictionaryWordReader() {
		addLines();
		addDictionaryWords();
		lemmatiseDictionaryDescriptions();
	}

	public void addLines() {
		try {
			textReader = new TextReader("dictionary.txt");
			dictionaryLines = textReader.getArrayList();
			for (int i = 0; i < dictionaryLines.size(); i++) {
				if (dictionaryLines.get(i).equals("")) {
					dictionaryLines.remove(i);
				}
				if (dictionaryLines.get(i).length() < 3) {
					dictionaryLines.remove(i);
				}

			}
		}
		catch (Exception e) {}
	}

	public void printLines() {
		for (int i = 0; i < dictionaryLines.size(); i++) {
			System.out.println(dictionaryLines.get(i));
		}
	}

	public void addDictionaryWords() {
		for (int i = 0; i < dictionaryLines.size(); i++) {
			dictionaryWordArrayList.add(new DictionaryWord(dictionaryLines.get(i).split(" ")[0], dictionaryLines.get(i).split(" "), dictionaryLines.get(i).split(" ").length));
		}
	}

	public void printDictionaryWords() {
		for (DictionaryWord dictionaryWord : dictionaryWordArrayList) {
			System.out.println(dictionaryWord.getWord());
		}
	}

	public void lemmatiseDictionaryDescriptions() {
		int failcounter = 0;
		for (int i = 0; i < dictionaryWordArrayList.size(); i++) {
			String[] description = new String[dictionaryWordArrayList.get(i).getDescription().length];
			for (int x = 0; x < dictionaryWordArrayList.get(i).getDescription().length; x++) {
				try {
					description[x] = lemmatisor.lemmatise(dictionaryWordArrayList.get(i).getDescription()[x]);
				}
				catch (Exception e) {
					failcounter++;
				}
			}
			dictionaryWordArrayList.set(i, new DictionaryWord(dictionaryWordArrayList.get(i).getWord(), description, description.length));
		}
		System.out.println(failcounter + " words couldn't be lemmatised");
	}

	public void printDictionaryDescriptions() {
		for (int i = 0; i < dictionaryWordArrayList.size(); i++) {
			System.out.println("\n--------\n");
			System.out.println(dictionaryWordArrayList.get(i).getWord());
			for (int x = 0; x < dictionaryWordArrayList.get(i).getDescription().length; x++) {
				System.out.println(dictionaryWordArrayList.get(i).getDescription()[x]);
			}
		}
	}

	public ArrayList<DictionaryWord> getDictionaryWordArrayList() {
		return dictionaryWordArrayList;
	}

}
