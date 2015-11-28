import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer cache = 0;
    boolean hasCache = false;
    Iterator<Integer> ite;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.cache = 0;
	    this.hasCache = false;
	    this.ite = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(hasCache)
			return cache;
		
		cache = ite.next();
		hasCache = true;
        return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(hasCache){
			hasCache = false;
			return cache;
		}else{
			return ite.next();
		}
	    
	}

	@Override
	public boolean hasNext() {
		if(hasCache){
			return true;
		}
		return ite.hasNext(); 
	}
	
    public static void main(String[] args){
		List<Integer> res = new ArrayList<Integer>();
		Iterator<Integer> it = res.iterator();
		res.add(1);
		res.add(2);
		res.add(3);
		PeekingIterator pi = new PeekingIterator(it);
		System.out.println(pi.next());
		System.out.println(pi.peek());
		System.out.println(pi.next());
		System.out.println(pi.next());
		System.out.println(pi.hasNext());

	}
}