import java.util.ArrayList;
import java.util.*;
import java.lang.*;

// Takes a two words as inputs
// Then compares synonyms of those "TableWords" with descriptions from "DictionaryWords"
// Calculates the "Dictionary Word" with the best match

public class Comparator {

	ArrayList<Integer> factors = new ArrayList<>();
	DictionaryWordReader dictionaryWordReader;
	TableWordReader tableWordReader;
	ArrayList<TableWord> tableWordArrayList = new ArrayList<>();
	ArrayList<DictionaryWord> dictionaryWordArrayList = new ArrayList<>();
	ArrayList<WordOutput> wordOutputs = new ArrayList<>();
	int highestMatchCount = 1;
	boolean dictionaryWordReaderCreated = false;
	boolean tableWordReaderWithInputWordsCreated = false;

	public void createDictionaryWordReader() {
		if (!dictionaryWordReaderCreated) {
			dictionaryWordReader = new DictionaryWordReader();
			dictionaryWordReaderCreated = true;
		}
	}

	public void createTableWordReaderWithInputWords(String words) {
			tableWordReader = new TableWordReader(words);
			tableWordArrayList = tableWordReader.getTableWordArrayList();
			tableWordReaderWithInputWordsCreated = true;
	}

	public void initialise(String words) {

		compare();
		printOutput();

	}

	// Some words might not have synonyms
	public void compare() {
		dictionaryWordArrayList = dictionaryWordReader.getDictionaryWordArrayList();
		for (int i = 0; i < factors.size(); i++) {
			tableWordArrayList.add(tableWordReader.getTableWordArrayList().get(factors.get(i)-1));
		}

		for (int a = 0; a < dictionaryWordArrayList.size(); a++) {
			int matchCounter = 0;
			Set<Integer> differentWordsMatchedCount = new HashSet<>();
			for (int b = 0; b < dictionaryWordArrayList.get(a).getDescription().length; b++) {
				for (int c = 0; c < tableWordArrayList.size(); c++) {
					for (int d = 0; d < tableWordArrayList.get(c).getSynonyms().size(); d++) {
						if (tableWordArrayList.get(c).getSynonyms().get(d).equals(dictionaryWordArrayList.get(a).getDescription()[b])) {
							matchCounter++;
							differentWordsMatchedCount.add(c);
							if (matchCounter > highestMatchCount) {
								highestMatchCount = matchCounter;
							}
						}
					}
				}
			}
			if (matchCounter > 0) {
				wordOutputs.add(new WordOutput(dictionaryWordArrayList.get(a).getWord(), matchCounter, differentWordsMatchedCount.size()));
				differentWordsMatchedCount.clear();
			}
		}
	}
	// could be better
	public void printOutput() {
		int y = 0;
		int x = 0;
		while(x < highestMatchCount) {
			while(y < wordOutputs.size()) {
				if (wordOutputs.get(y).getDifferentWordsMatched() == x) {
					System.out.println(wordOutputs.get(y).getWord() + " : " + wordOutputs.get(y).getDifferentWordsMatched() + " : " + wordOutputs.get(y).getFrequency());
					wordOutputs.remove(wordOutputs.get(y));
					x = 0;
					y = 0;
				}
				y++;

			}
			x++;
			y = 0;
		}
		System.out.println("Searching dictionary entries for: ");
		for (TableWord tableWord : tableWordArrayList) {
			System.out.println(tableWord.getSynonyms());
		}
	}


}
