package LeetCode;

import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> temp=new ArrayList<>();
            temp.add(0,1);
            int j=1;
            int index=0;
            while(j<i)
            {
                temp.add(j,result.get(result.size()-1).get(index)+result.get(result.size()-1).get(index+1));
                j++;
                index++;
            }
            if(i>0)
            temp.add(i,1);
            result.add(temp);
        }
        return result;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        if(rowIndex<0)return list;
        list.add(1);
        for(int i=1;i<=rowIndex;i++)
        {
            List<Integer> newList=new ArrayList<>();
            newList.add(1);
            for(int j=0;j<list.size()-1;j++)
            {
                newList.add(list.get(j)+list.get(j+1));
            }
            newList.add(1);
            list=newList;
        }
        return list;
    }
}