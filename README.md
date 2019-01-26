# dictionary_searcher
Searches dictionary entries for words that you input.

Requires Stanford Natural Language Processing library. Also requires dictionary and thesaurus txt files. I didn't include them with the source code due to copyright.

How it works:

It takes two words that you input. Eg. "self identity"

It then searches the thesaurus and finds synonyms of those words. Eg. "[identity, speciality, self], [equality, identity]"

It then "lemmatises" the synonyms (converts them to their root form) using Stanford NLP.
Eg.
  It would convert "likes" to "like"
  It would convert "differences" to "difference"
  It would convert "running" to "run"
  It would convert "ran" to "run"
  
It then "lemmatises" each definition in the dictionary text file.

It then compares each lemmatised synonym of the input words with each lemmatised definition in the dictionary.

It prints the dictionary words that have the most matches.

The first output number corresponds to the number of input words the dictionary word has matched with. The second output number corresponds to the number of synonyms the dictionary word has matched with.

