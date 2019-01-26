// Version 3
// Lets you input two or more words, and returns a word in the dictionary that has the most matches
// Also contains improvements for checking similes against dictionary entries
// The first number is the number of input words the dictionary word matched with
// The second number is the total number of synonyms the dictionary word matched with

public class Main {
	public static void main(String[] args) {
		Toolbox myToolbox = new Toolbox();

		System.out.println("Loading words from dictionary and thesaurus...\nThis will take a while.");
		Comparator comparator = new Comparator();
			while (true) {
				comparator.createDictionaryWordReader();
				String input = myToolbox.readStringFromCmd();
				comparator.createTableWordReaderWithInputWords(input);
				comparator.initialise(input);
				System.out.println("You entered: \"" + input + "\"\n---------");
			}

	}
}