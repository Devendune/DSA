package BinarySearch;

public class PeakMountainArray
{
    public int peakIndexInMountainArray(int[] nums)
    {
        int arrLength=nums.length;
        int start=0;
        int end=arrLength-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(mid-1>=0 && mid+1<arrLength)
            {
                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                    return mid;
            }

            else if(mid-1>=0)
            {
                if(nums[mid]>nums[mid-1])
                    return mid;
            }

            else if(mid+1<arrLength)
            {
                if(nums[mid]>nums[mid+1])
                    return mid;
            }

            if(nums[mid]>nums[mid+1])
                end=mid-1;

            if(nums[mid]<nums[mid+1])
                start=mid+1;
        }

        return -1;
    }
}
