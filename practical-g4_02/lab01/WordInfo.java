import java.util.ArrayList;

public class WordInfo {
    
    private String word;
    private int wordLength;
    private int[] coords;
    private Direction dir;
    private boolean found;
    private boolean placed;

    public WordInfo(String word) {
        this.word = word;
        this.wordLength = word.length();
        this.coords = null;
        this.dir = null;
        this.found = false;
        this.placed = false;
    }


    private String coordsString(){
        return String.format("%d,%d", this.coords[0]+1, this.coords[1]+1);
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordLength() {
        return this.wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public int[] getCoords() {
        return this.coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public Direction getDir() {
        return this.dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public boolean getFound() {
        return this.found;
    }
    
    public void setFound(Boolean found){
        this.found = found;
    }

    public boolean getPlaced() {
        return this.placed;
    }
    
    public void setPlaced(Boolean placed){
        this.placed = placed;
    }

    public void found(){
        this.found = true;
    }

    public static ArrayList<WordInfo> listChecker(ArrayList<WordInfo> wordList){
        ArrayList<WordInfo> new_wordList = new ArrayList<>(wordList);
        for (WordInfo wordI : wordList) {
            for (WordInfo wordJ : wordList) {
                if(!wordI.equals(wordJ) && wordI.getWord().contains(wordJ.getWord())){
                    new_wordList.remove(wordJ);
                }

            }
        }
        return new_wordList;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
         
        WordInfo c = (WordInfo) o;
         
        return c.getWord().equals(this.word);
    }

    @Override
    public String toString() {
        return String.format("%-13s %5s %7s %s\n", this.word.toLowerCase(), this.wordLength, coordsString(), this.dir);
    }

}
