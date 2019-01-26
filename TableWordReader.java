import java.util.ArrayList;

// Takes words from the list and creates instances of "TableWord" class
// Words must be lowercase

public class TableWordReader {

	private ArrayList<String> wordsLowerCase = new ArrayList<>();
	private ArrayList<TableWord> tableWordArrayList = new ArrayList<>();
	private Lemmatisor lemmatisor = new Lemmatisor();

	//  Creates an ArrayList with specific words
	public TableWordReader(String words) {
		addInputWords(words);
		lemmatiseMainWords();
		lemmatiseSynonyms();
	}

	// Adds words input rather than reading them from a file
	public void addInputWords(String words) {
		String[] wordList = words.split(" ");
		for (String word : wordList) {
			wordsLowerCase.add(word.toLowerCase());
		}
		int x;
		for (int i = 0; i < wordsLowerCase.size(); i++) {
			x = i + 1;
			tableWordArrayList.add(new TableWord(x, wordsLowerCase.get(i)));
		}
	}

	public void printWords() {
		for (TableWord tableWord : tableWordArrayList ) {
			System.out.println("---");
			System.out.println(tableWord.getMainWord());
			tableWord.printSynonyms();
		}
	}

	public void lemmatiseMainWords() {
		for (int i = 0; i < tableWordArrayList.size(); i++) {
			tableWordArrayList.set(i, new TableWord(tableWordArrayList.get(i).getNumber(), lemmatisor.lemmatise(tableWordArrayList.get(i).getMainWord())));
		}
	}

	// Also adds the main word to the end of the synonyms
	public void lemmatiseSynonyms() {
		for (int i = 0; i < tableWordArrayList.size(); i++) {
			if (tableWordArrayList.get(i).hasSynonyms()) {
				ArrayList<String> synonyms = tableWordArrayList.get(i).getSynonyms();
				for (int x = 0; x < synonyms.size(); x++) {
					synonyms.set(x, lemmatisor.lemmatise(synonyms.get(x)));
				}
				synonyms.add(tableWordArrayList.get(i).getMainWord());
				tableWordArrayList.set(i, new TableWord(tableWordArrayList.get(i).getNumber(), tableWordArrayList.get(i).getMainWord(), synonyms));
			}
		}
	}

	public ArrayList<TableWord> getTableWordArrayList() {
		return tableWordArrayList;
	}
}
