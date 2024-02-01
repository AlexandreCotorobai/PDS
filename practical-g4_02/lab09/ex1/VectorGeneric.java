package ex1;

public class VectorGeneric<T> implements java.lang.Iterable<T>{
	private T[] vec;
	private int nElem;
	private final static int ALLOC = 50;
	private int dimVec = ALLOC;

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}

	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem >= dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem);
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem - i - 1 > 0) // not last element
					System.arraycopy(vec, i + 1, vec, i, nElem - i - 1);
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}

	public T getElem(int i) {
		return (T) vec[i];
	}

	// IX.1 - Iterator

	public java.util.Iterator<T> iterator() {
		return new VectorIterator<T>(vec, nElem);
	}

	public java.util.ListIterator<T> lisIterator() {
		return new VectorListIterator<T>(vec, nElem);
	}

	public java.util.ListIterator<T> listIterator(int index) {
		return new VectorListIterator<T>(vec, nElem, index);
	}

	/**
	 * InnerVectorGeneric
	 */
	class VectorIterator<E> implements java.util.Iterator<E> {
		private E[] vec;
		private int nElem;
		private int current = 0;
	
		public VectorIterator(E[] vec2, int nElem) {
			this.vec = vec2;
			this.nElem = nElem;
		}
	
		public boolean hasNext() {
			return current < nElem;
		}
	
		public E next() {
			return vec[current++];
		}
	
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	class VectorListIterator<E> implements java.util.ListIterator<E> {
		private E[] vec;
		private int nElem;
		private int current = 0;
	
		public VectorListIterator(E[] vec2, int nElem, int current) {
			this.vec = vec2;
			this.nElem = nElem;
			this.current = current;
		}
	
		public VectorListIterator(E[] vec2, int nElem) {
			this(vec2, nElem, 0);
		}
		
	
		public boolean hasNext() {
			return current < nElem;
		}
	
		public E next() {
			return vec[current++];
		}
	
		public void remove() {
			throw new UnsupportedOperationException();
		}
	
		public boolean hasPrevious() {
			return current > 0;
		}
	
		public E previous() {
			return vec[current--];
		}
	
		public int nextIndex() {
			return current + 1;
		}
	
		public int previousIndex() {
			return current - 1;
		}
	
		public void set(E e) {
			vec[current] = e;
		}
	
		public void add(E e) {
			throw new UnsupportedOperationException();
		}
	}
}
