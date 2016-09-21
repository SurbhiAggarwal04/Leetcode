package LeetCode;


import java.util.ArrayList;
import java.util.List;



 
  class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }

public class DataStreamAsDisjointIntervals {

    /** Initialize your data structure here. */
   
	private ArrayList<Interval> list;
    public DataStreamAsDisjointIntervals() {
        list=new ArrayList<Interval>();
    }
    
    public void addNum(int val) {
        Interval interval=new Interval(val,val);
        if(list.size()==0)
        {
            list.add(interval);
        }
        else
        {
            if(list.get(0).start>val)
            {
                if(list.get(0).start-1==val)
                {
                    interval=list.get(0);
                    interval.start=val;
                    list.set(0,interval);
                }
                else
                list.add(0,interval);
            }
            else if(list.get(list.size()-1).end<val)
            {
                
               if(list.get(list.size()-1).end+1==val)
                {
                    interval=list.get(list.size()-1);
                    interval.end=val;
                    list.set(list.size()-1,interval);
                }
                else
                list.add(interval);
            }
            else
            {
                boolean found=false;
                for(int i=0;i<list.size();i++)
                {
                    if(val>=list.get(i).start && val<=list.get(i).end)break;
                    
                    if(!found && val<(list.get(i).start)-1)
                    {
                        //interval.start=val;
                        //interval.end=val;
                        found=true;
                        list.add(i,interval);
                        i++;
                       // break;
                    }
                    else
                    {
                        
                        if(val==(list.get(i).start)-1)
                        {
                            interval=list.get(i);
                            interval.start=val;
                            list.set(i,interval);
                            found=true;
                        }
                       
                          if(val==(list.get(i).end)+1)
                        {
                            interval=list.get(i);
                            interval.end=val;
                            list.set(i,interval);
                            found=true;
                        }
                         
                   
                    /*if(i<list.size()-1 && list.get(i).end==list.get(i+1).start)
                    {
                        interval.start=list.get(i).start;
                        interval.end=list.get(i+1).end;
                        list.remove(i+1);
                        list.set(i,interval);
                    }
                       if(found)
                        break;*/
                    }
                    
                        if(i!=0 && list.get(i).start==list.get(i-1).end)
                    {
                        interval.start=list.get(i-1).start;
                        interval.end=list.get(i).end;
                        //list.remove(i-1);
                        list.remove(i);
                        list.set(i-1,interval);
                    }
                    //if(found)break;
                }
            }
        }
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */