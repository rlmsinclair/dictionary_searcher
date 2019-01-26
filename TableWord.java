import java.util.ArrayList;

public class TableWord {

	private int number;
	private String mainWord;
	private boolean hasSynonyms = false;
	private ArrayList<String> synonyms = new ArrayList<>();
	private TextReader textReader;
	private ArrayList<String> thesaurusArray;

	public TableWord(int number, String mainWord) {
		this.mainWord = mainWord;
		this.number = number;
		addSynonyms();
	}

	// Overloaded constructor to change synonyms
	public TableWord(int number, String mainWord, ArrayList<String> synonyms) {
		this.mainWord = mainWord;
		this.number = number;
		this.synonyms = synonyms;
	}

	public void addSynonyms() {

		try {
			textReader = new TextReader("thesaurus.txt");
			thesaurusArray = textReader.getArrayList();
			for (int i = 0; i < thesaurusArray.size(); i++) {
				if (thesaurusArray.get(i).equals(mainWord)) {
					hasSynonyms = true;
					int x = 1;
					while (true) {
						if (!thesaurusArray.get(i+x).contains("      ")) {
							break;
						}
						else {
							String synonym = thesaurusArray.get(i + x).split(" ")[8];
							synonyms.add(synonym);
							x++;
						}
					}
				}
			}

		}
		catch (Exception e) {}

	}

	public ArrayList<String> getSynonyms() {
		return synonyms;
	}

	public int getNumber() {
		return this.number;
	}

	public String getMainWord() {
		return this.mainWord;
	}

	public boolean hasSynonyms() {
		return hasSynonyms;
	}

	public void printSynonyms() {
		for (int i = 0; i < synonyms.size(); i++) {
			System.out.println(synonyms.get(i));
		}
	}

}
