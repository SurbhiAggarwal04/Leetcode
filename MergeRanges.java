package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeRanges {
	
public static void main(String[] args) {
	List<int[]> list=new ArrayList<>();
	list.add(new int[]{5,5});
	list.add(new int[]{6,10});
	list.add(new int[]{2,3});
	list.add(new int[]{3,3});
	list.add(new int[]{2,5});
	
	
	Collections.sort(list, new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if(o1[1]!=o2[1])
			return o1[1]-o2[1];
			else
				return o1[0]-o2[0];
		}
		
	});
	for(int i=0;i<list.size();i++)
	{
		System.out.println(list.get(i)[0]+" "+list.get(i)[1]);
	}
	System.out.println("after merge");
	merge(list);
}
public static void merge(List<int[]> list)
{
	int i=0;
	
	while(i<list.size()-1)
	{
		int[] first=list.get(i);
		int second[]=list.get(i+1);
		if(first[1]<second[0])i++;
		else
		{
			System.out.println("inside");
			if(first[0]>=second[0])
			{
				list.remove(i);
			}
			else
			{
				System.out.println("new inside");
				list.remove(i+1);
				list.remove(i);
				list.add(i,new int[]{first[0],second[1]});
				
				
				
			}
		}
		System.out.println("new");
		for(int j=0;j<list.size();j++)
		{
			System.out.println(list.get(j)[0]+" "+list.get(j)[1]);
		}
		//break;
	}
}
}
