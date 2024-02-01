package ex1;

public class Demo {
    public static void main(String[] args) {
        VectorGeneric<Long> v = new VectorGeneric<Long>();
        // add random integers to vector
        for (int i = 0; i < 10; i++) {
            v.addElem(Math.round(Math.random() * 100));
        }

        // create iterator
        java.util.Iterator<Long> it = v.iterator();
    
        // print vector
    
        // create list iterator

        java.util.ListIterator<Long> lit = v.listIterator(2);

        while (lit.hasNext() || it.hasNext()) {
            if (lit.hasNext()) {
                System.out.println("lit: " + lit.next());
            }
            if (it.hasNext()) {
                System.out.println("it: " + it.next());
            }
        }
    }
}
