import java.text.Normalizer;

public class VowelFilter extends ReaderDec{

    public VowelFilter(ReaderInterface wrappee) {
        super(wrappee);
    }

    @Override
    public String next() {
        String line = wrappee.next();
        // remove acccents to also work on í and etc...
        line = Normalizer.normalize(line, Normalizer.Form.NFD);
        line = line.replaceAll("[^\\p{ASCII}]", "");
        String regex = "[aeiouAEIOU]";

        line = line.replaceAll(regex, "");
        
        if (line.length() == 0) {
            return next(); // Avoid returning empty words / lines
        }
        return line;
    }
}
