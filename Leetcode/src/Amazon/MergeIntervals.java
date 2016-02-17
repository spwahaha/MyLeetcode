package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	
	
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                int diff = i1.start - i2.start;
                if(diff < 0){
                    return -1;
                }else if(diff == 0){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        Interval temp = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(intersect(temp, intervals.get(i))){
                temp = merge(temp, intervals.get(i));
            }else{
                res.add(temp);
                temp = intervals.get(i);
            }
        }
        res.add(temp);
        return res;
    }
    
    private boolean intersect(Interval i1, Interval i2){
        return i1.end >= i2.start;
    }
    
    private Interval merge(Interval i1, Interval i2){
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
}
