package Trees;

public class MaxPathSum
{
    int maxSum=Integer.MIN_VALUE;
    private int helper(TreeNode root)
    {
        if(root==null)
            return 0;

        if(root.left==null && root.right==null)
        {
            maxSum=Math.max(maxSum,root.val);
            return root.val;
        }
        int leftSum=helper(root.left);
        int rightSum=helper(root.right);

        maxSum=Math.max(maxSum,leftSum+rightSum+root.val);
        int toReturn=Math.max(Math.max(leftSum,rightSum)+root.val,root.val);
        maxSum=Math.max(maxSum,toReturn);
        return toReturn;

    }
    public int maxPathSum(TreeNode root)
    {
        if(root==null)
            return 0;

        int sum=helper(root);
        return Math.max(sum,maxSum);
    }
}
