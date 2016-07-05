/* Analsis
using queue
*/

public class MovingAverage {
    Queue<Integer> queue;
    int mysize;
    int sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        mysize = size;
        sum = 0;
    }
    
    public double next(int val) {
        if(queue.size() == mysize){
            sum -= queue.remove();
        }
          
        sum += val;
        queue.add(val);
        
        return ((double)sum)/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
