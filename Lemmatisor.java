import edu.stanford.nlp.simple.Sentence;

public class Lemmatisor {

	String text;

	public String lemmatise(String text) {
		Sentence sentence = new Sentence(text);
		return sentence.lemmas().get(0);
	}

	public void test(String text) {
		Lemmatisor lemmatisor = new Lemmatisor();
		System.out.println(lemmatisor.lemmatise(text));
	}

}
