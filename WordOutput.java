public class WordOutput {

	String word;
	int frequency;
	int differentWordsMatched;

	public WordOutput(String word, int frequency, int differentWordsMatched) {
		this.word = word;
		this.frequency = frequency;
		this.differentWordsMatched = differentWordsMatched;
	}

	public int getFrequency() {
		return this.frequency;
	}

	public int getDifferentWordsMatched() {
		return this.differentWordsMatched;
	}

	public String getWord() {
		return this.word;
	}
}
