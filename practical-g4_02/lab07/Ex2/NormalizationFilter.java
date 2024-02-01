import java.text.Normalizer;

public class NormalizationFilter extends ReaderDec {
    
    public NormalizationFilter(ReaderInterface wrappee) {
        super(wrappee);
    }
    
    @Override
    public String next() {
        String line = wrappee.next();
        // remove acccents
        line = Normalizer.normalize(line, Normalizer.Form.NFD);
        line = line.replaceAll("[^\\p{ASCII}]", "");
        // remove punctuation
        line = line.replaceAll("[^a-zA-Z0-9 ]", "");
        return line;
    }
}
