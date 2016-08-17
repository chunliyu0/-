/* Analysis I - combine the two list to one */

public class ZigzagIterator {
    List<Integer> list;
    int idx;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        idx = 0;
        list = new ArrayList<Integer>();
        int i;
        for(i = 0; i < v1.size() && i < v2.size(); i++){
            list.add(v1.get(i));
            list.add(v2.get(i));
        }
        if(i < v1.size())
            do{
                list.add(v1.get(i));
                i++;
            }while(i < v1.size());
        else if(i < v2.size())
             do{
                list.add(v2.get(i));
                i++;
            }while(i < v2.size());
    }

    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        if(idx < list.size())
            return true;
        return false;
    }
}

/* Analysis II 
(1) Put the lists into a queue, the lists are FIFO.
(1) Using the iterator to get the next altomatically so that we don't need to track the idx.
*/
public class ZigzagIterator {
    Queue<Iterator> que;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        que = new LinkedList<Iterator>();
        if(v1!=null && v1.size()!=0) que.add(v1.iterator());
        if(v2!=null && v2.size()!=0) que.add(v2.iterator());
    }

    public int next() {
        Iterator it = que.remove();
        int ret = (int)it.next();
        if(it.hasNext())que.add(it);
        return ret;
    }

    public boolean hasNext() {
        return !que.isEmpty();
    }
}


/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
