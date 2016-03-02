package FB;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i));
            i++;
        }
        while(i < intervals.size() && newInterval.end >= intervals.get(i).start){
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                                        Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        res.add(newInterval);
        while(i < intervals.size()){
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}
