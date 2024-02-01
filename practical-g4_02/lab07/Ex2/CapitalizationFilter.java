public class CapitalizationFilter extends ReaderDec {

    public CapitalizationFilter(ReaderInterface wrappee) {
        super(wrappee);
    }
    
    @Override
    public String next() {
        String line = wrappee.next();
        line = line.substring(0, 1).toUpperCase() + line.substring(1);
        return line;
    }
}
