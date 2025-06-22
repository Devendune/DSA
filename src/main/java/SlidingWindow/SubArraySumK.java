package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK
{
    public int subarraySum(int[] nums, int k)
    {
        Map<Integer,Integer> map=new HashMap<>();
        int numsLength=nums.length;
        int count=0;

        int sum=0;
        map.put(0,1);
        for(int counter=0;counter<numsLength;counter++)
        {
            int val=nums[counter];
            sum+=val;

            if(map.containsKey(sum-k)==true)
                count+=map.get(sum-k);

            map.put(sum,1+map.getOrDefault(sum,0));
        }
        return count;
    }
}
