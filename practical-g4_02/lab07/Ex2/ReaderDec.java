public abstract class ReaderDec implements ReaderInterface {
    protected ReaderInterface wrappee;

    public ReaderDec(ReaderInterface wrappee){
        this.wrappee = wrappee;
    }

    public boolean hasNext(){
        return wrappee.hasNext();
    }

    public String next(){
        return wrappee.next();
    }
}
