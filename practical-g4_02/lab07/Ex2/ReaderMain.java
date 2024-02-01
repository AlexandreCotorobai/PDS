public class ReaderMain {
    
    public static void main(String[] args) {
        ReaderInterface reader = new TextReader("test.txt");
        int line = 1;
        while (reader.hasNext()) {
            System.out.println("Line " + line + ": " + reader.next());
            line++;
        }

        reader = new TermFilter(new TextReader("test.txt"));
        int word = 1;
        while (reader.hasNext()) {
            System.out.println("Word " + word + ": " + reader.next());
            word++;
        }

        reader = new TermFilter(new NormalizationFilter(new TextReader("test.txt")));
        int word2 = 1;
        while (reader.hasNext()) {
            System.out.println("Word " + word2 + ": " + reader.next());
            word2++;
        }

        reader = new VowelFilter(new TextReader("test.txt"));
        int line2 = 1;
        while (reader.hasNext()) {
            System.out.println("Line " + line2 + ": " + reader.next());
            line2++;
        }

        reader = new CapitalizationFilter(new TermFilter(new TextReader("test.txt")));
        int word3 = 1;
        while (reader.hasNext()) {
            System.out.println("Line " + word3 + ": " + reader.next());
            word3++;
        }

    }
}
