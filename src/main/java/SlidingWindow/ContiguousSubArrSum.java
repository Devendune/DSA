package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class ContiguousSubArrSum
{
    public boolean checkSubarraySum(int[] nums, int k)
    {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        int numsLength=nums.length;

        int sum=0;
        for(int counter=0;counter<numsLength;counter++)
        {
            int val=nums[counter];
            sum+=val;
            if(map.containsKey(sum%k)==true)
            {
                int value=map.get(sum%k);
                if(counter-value>=2)
                    return true;
            }

            else
                map.put(sum%k,counter);
        }


        return false;
    }
}
