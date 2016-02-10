import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<Interval>(intervals);
        list.add(newInterval);
        Collections.sort(list, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        Interval temp = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(intersect(temp, list.get(i))){
                temp = merge(temp, list.get(i));
                continue;
            }else{
                res.add(temp);
                temp = list.get(i);
            }
        }
        
        res.add(temp);
        return res;
    }
    
    private boolean intersect(Interval i1, Interval i2){
        return (i2.start <= i1.end);
    }
    
    private Interval merge(Interval i1, Interval i2){
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
    
    public static void main(String[] args){
    	
    }
}
