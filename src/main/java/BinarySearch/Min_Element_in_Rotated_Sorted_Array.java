package BinarySearch;

public class Min_Element_in_Rotated_Sorted_Array
{
    public int findMin(int[] nums)
    {
        int numsLength=nums.length;
        int start=0;
        int end=numsLength-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(end-start+1==2)
            {
                if(nums[start]<nums[end])
                    return nums[start];

                return nums[end];
            }
            if(start==end)
                return nums[mid];

            if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1])
                return nums[mid];

            if(nums[mid]<nums[end])
                end=mid-1;

            else if(nums[mid]>nums[start])
                start=mid+1;
        }
        return -1;
    }
}
