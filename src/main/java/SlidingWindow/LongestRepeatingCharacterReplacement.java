package SlidingWindow;

public class LongestRepeatingCharacterReplacement
{
    public int characterReplacement(String s, int k)
    {
        /*
        The logic basically is that we need to replace k characters in the string now the question comes which
        character to replace so we can replace the character with high frequency or low frequency right

        we choose a character with low freq to be replaced why would we choose a char with high frequency to be
        replaced ??

        Is there sufficient k characters present in the string??
        */
        int firstCounter=0;
        int secondCounter=0;
        int stringLength=s.length();
        int[] freqTable=new int[26];
        int maxFreq=0;
        int maxLength=0;

        while(secondCounter<stringLength)
        {
            char ch=s.charAt(secondCounter);
            freqTable[ch-'A']++;
            maxFreq=Math.max(freqTable[ch-'A'],maxFreq);

            int windowLength=secondCounter-firstCounter+1;
            while(secondCounter-firstCounter+1-maxFreq>k)
            {
                char firstChar=s.charAt(firstCounter);
                freqTable[firstChar-'A']--;
                firstCounter++;
            }
            maxLength=Math.max(secondCounter-firstCounter+1,maxLength);
            secondCounter++;
        }
        return maxLength;
    }
}
