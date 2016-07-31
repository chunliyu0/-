/* Analysis
(1) Take care of the cases when there are empty list in the middle
*/

public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> vec2d;
    int i;
    int j;
    
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        i = 0;
        j = 0;
    }

    @Override
    public Integer next() {
        Integer ret = (Integer)(vec2d.get(i).get(j));
        
        if(j < vec2d.get(i).size()-1)
            j++;
        else{
            j = 0;
            i++;
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        if(vec2d.size()==0 || (i == vec2d.size()))
            return false;
        if(vec2d.get(i).size()==0){
            i ++ ;
            return hasNext();
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
