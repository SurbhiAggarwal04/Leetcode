package LeetCode;

/*
 * By finding the greatest common divisor
 */
public class WaterAndJug {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x==z || y==z)return true;
        if(z==0)return true;
        if(z>x+y)return false;
        int difference=Math.abs(x-y);
        int max=x;
        int min=x;
        if(y>max)
        {
            max=y;
        }
        if(y<min)min=y;
        while(min!=0)
        {
            int r=max%min;
            max=min;
            min=r;
        }
        if(z%max==0)return true;
        return false;
      
    }
}
