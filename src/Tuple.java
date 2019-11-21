import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Tuple {

    private List<String> words;
    private int tupleSize;

    public Tuple() {
        this.words = new ArrayList<String>();
        this.tupleSize = 0;
    }

    public Tuple(int tupleSize) {
        this.words = new ArrayList<String>();
        this.tupleSize = tupleSize;
    }

    public Tuple(List<String> words, int tupleSize) {
        this.words = words;
        this.tupleSize = tupleSize;
    }

    public void addWord(String word) {
        this.words.add(word);
    }

    public List<String> getWords() {
        return this.words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public int getTupleSize() {
        return this.tupleSize;
    }

    public void setTupleSize(int tupleSize) {
        this.tupleSize = tupleSize;
    }

    @Override
    public String toString() {
        return String.join(", ", this.words);
    }

    /**
     *
     * @param tuple
     * @param synonymsMap
     * @return
     */
    public Boolean equals(Tuple tuple, Map<String, HashSet<String>> synonymsMap) {
        List<String> originalWordList = this.getWords();
        List<String> suspectWordList = tuple.getWords();

        for (int i = 0; i < this.tupleSize; i++) {
            String originalWord = originalWordList.get(i);
            String suspectWord = suspectWordList.get(i);

            if (!originalWord.equals(suspectWord)) {
                if(!synonymsMap.containsKey(originalWord)) {
                    return Boolean.FALSE;
                }
                HashSet<String> originalSynonyms = synonymsMap.get(originalWord);
                if (!originalSynonyms.contains(suspectWord)) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }
}
