import java.util.ArrayList;
import java.util.List;

public class Corpus {

    private String text;
    private List<Tuple> tupleList;

    public Corpus() {
        this.text = null;
        this.tupleList = new ArrayList<Tuple>();
    }

    public Corpus(String text, Integer tupleSize) {
        this.text = text;
        this.tupleList = extractTuplesFromText(text, tupleSize);
    }

    public Corpus(String text, List<Tuple> tupleList) {
        this.text = text;
        this.tupleList = tupleList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Tuple> getTupleList() {
        return tupleList;
    }

    public void setTupleList(List<Tuple> tupleList) {
        this.tupleList = tupleList;
    }

    /**
     *
     * @param text
     * @param tupleSize
     * @return
     */
    public List<Tuple> extractTuplesFromText(String text, int tupleSize) {
        List<Tuple> tupleList = new ArrayList<Tuple>();
        text = text.replaceAll("[^a-zA-Z0-9 ]", "").trim().replaceAll("\\s+", " ");
        String[] splitWords = text.split(" ");
        if (splitWords.length < tupleSize) {
            return tupleList;
        }

        for (int i=0; i<= splitWords.length - tupleSize; i++) {
            Tuple tuple = new Tuple(tupleSize);
            for (int j=i; j<i+tupleSize; j++) {
                tuple.addWord(splitWords[j]);
            }
            tupleList.add(tuple);
        }
        return tupleList;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
