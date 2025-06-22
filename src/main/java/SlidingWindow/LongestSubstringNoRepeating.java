package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeating
{
    public int lengthOfLongestSubstring(String s)
    {
        int stringLength=s.length();
        int firstCounter=0;
        int secondCounter=0;

        Map<Character,Integer> map=new HashMap<>();
        int maxLength=0;
        while(secondCounter<stringLength)
        {
            char ch=s.charAt(secondCounter);
            map.put(ch,1+map.getOrDefault(ch,0));

            while(map.get(ch)>1)
            {
                char firstChar=s.charAt(firstCounter);
                if(map.get(firstChar)==1)
                    map.remove(firstChar);

                else
                    map.put(firstChar,map.get(firstChar)-1);

                firstCounter++;
            }
            maxLength=Math.max(secondCounter-firstCounter+1,maxLength);
            secondCounter++;
        }
        return maxLength;
    }
}
