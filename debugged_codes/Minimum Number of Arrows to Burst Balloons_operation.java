import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int minNumArrows = 1;
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2)
            {
                if(i1[0] < i2[0])
                    return -1;
                else if (i1[0] > i2[0])
                    return 1;
                return 0;
            }
        });

        int n = points.length;
        int[] candid = new int[2];
        candid[0] = points[0][0];
        candid[1] = points[0][1];
        for(int i = 1; i < n; i++)
        {
            int[] next = points[i];
            if(hasOverlap(candid,next))
            {
                int[] merged = mergeInterval(candid,next);
                candid[0] = merged[0];
                candid[1] = merged[1];
            }
            else
            {
                candid[0] = next[0];
                candid[1] = next[1];                
                minNumArrows++;
            }
        }

        return minNumArrows;
    }

    public boolean hasOverlap(int[] i1, int[] i2)
    {
        boolean hasOverlap = false;
        if(i1[0] <= i2[0] && i2[0] <= i1[1])
            hasOverlap = true;
        if(i2[0] <= i1[0] && i1[0] <= i2[1])
            hasOverlap = true;
        return hasOverlap;
    }

    public int[] mergeInterval(int[] i1, int[] i2)
    {
        int[] merged = new int[2];
        merged[0] = Math.max(i1[0],i2[0]);
        merged[1] = Math.min(i1[1],i2[1]);
        return merged;
    }
}