/* Analysis
We can use iterator.next() when necessary
*/


// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> it;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    if(iterator.hasNext()){
	        next = iterator.next();
	    } 
	    else{
	        next = null;
	    }
	    it = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer pre = next;
	    if(it.hasNext()){
            next=it.next();
        }else{
            next=null;
        } 
        return pre;
	}

	@Override
	public boolean hasNext() {
	    if(next==null)
	        return false;
	    return true;
	}
}
