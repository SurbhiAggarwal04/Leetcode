package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;




    public  class RoyalNames implements Comparator<String>
        {
        
        private Map<Character,Integer> romanToIntMap=new HashMap<>();
        
        public RoyalNames()
            {
            super();
            romanToIntMap.put('I',1);
            romanToIntMap.put('V',5);
            romanToIntMap.put('X',10);
            romanToIntMap.put('L',50);
        }
        @Override
         public int compare(String nameOne,String nameTwo)
             {
             String[] name1Array=nameOne.split(" ");
             String[] name2Array=nameTwo.split(" ");
             if(name1Array[0].compareTo(name2Array[0])==0)
                 {
                 int romanValueOfFirst=convert(name1Array[1]);
                 int romanValueOfSecond=convert(name2Array[1]);
                 if(romanValueOfFirst==romanValueOfSecond)return 0;
                 if(romanValueOfFirst>romanValueOfSecond)return 1;
                 return -1;
             }
             else
                 {
                 return name1Array[0].compareTo(name2Array[0]);
             }
         }
        
        private int convert(String romanValue)
            {
            char[] array=romanValue.toCharArray();
            int result=0;
            int temp=0;
            for(int i=array.length-1;i>=0;i--)
                {
                int value=romanToIntMap.get(array[i]);
                if(value>=temp)
                    {
                    temp=value;
                    result+=value;
                }
                else
                    result-=value;
            }
            return result;
        }
        static String[] getSortedList(String[] names) {
            
            RoyalNames comparator =new RoyalNames();
               TreeSet<String> nameSet=new TreeSet<>(comparator);
               for(int i=0;i<names.length;i++)
                   {
                   nameSet.add(names[i]);
               }
               String[] result=new String[names.length];
               nameSet.toArray(result);
               return result;
           }

    }
    
