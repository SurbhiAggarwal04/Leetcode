package LeetCode;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
public class NonDominatableEntity {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        if((line=br.readLine())==null)System.out.println(0);
        else
        {
        int noOfEntities=Integer.parseInt(line);
        int[][] input=new int[noOfEntities][2];
        int i=0;
        
        while((line=br.readLine())!=null && i<noOfEntities)
            {
            String array[]=line.split(" ");
            input[i][0]=Integer.parseInt(array[0]);
            input[i][1]=Integer.parseInt(array[1]);
            i++;
        }
        
        Arrays.sort(input,new Comparator<int[]>()
            {
            public int compare(int[] a,int[] b)
                {
                return b[0]-a[0];
            }
        });
        
        int max=-1;
        int count=0;
        i=0;
        for(;i<input.length;i++)
            {
            if(input[i][1]>max)
                {
                count++;
                max=input[i][1];
            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        System.out.println(count);
        }
    }
}
