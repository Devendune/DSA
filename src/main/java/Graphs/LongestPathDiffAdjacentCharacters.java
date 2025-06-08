package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LongestPathDiffAdjacentCharacters
{
    int globalMax=0;
    public int dfs(List<List<Integer>>adjList, int source, String s, boolean[] visited, int[] matrix)
    {
        visited[source]=true;
        char sourceChar=s.charAt(source);
        int max=0;
        int total=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int val:adjList.get(source))
        {
            if(visited[val]==false)
            {
                char ch=s.charAt(val);
                if(ch!=sourceChar)
                {
                    // System.out.println("The node before the recursion call is "+val);
                    int answer=dfs(adjList,val,s,visited,matrix);
                    //System.out.println("The answer we received is "+answer);
                    pq.add(answer);
                }
            }
        }
        int val1=0;
        int val2=0;
        if(pq.size()>=2)
        {
            val1=pq.poll();
            val2=pq.poll();
        }
        else if(pq.size()>=1)
            val1=pq.poll();

        globalMax=Math.max(1+val1+val2,globalMax);
        int toReturn=1+Math.max(val1,val2);
        // System.out.println("Setting value for "+source+" as "+max);
        return toReturn;
    }
    public int longestPath(int[] parent, String s)
    {
        List<List<Integer>>adjList=new ArrayList<>();

        int n=parent.length;
        int longest=0;
        int[]matrix=new int[n];

        for(int counter=0;counter<n;counter++)
        {
            List<Integer>list=new ArrayList<>();
            adjList.add(list);
        }
        for(int counter=0;counter<n;counter++)
        {
            int value=parent[counter];
            if(value!=-1)
            {
                adjList.get(value).add(counter);
                adjList.get(counter).add(value);
            }
        }

        boolean[] visited=new boolean[n];
        for(int counter=0;counter<n;counter++)
        {
            if(visited[counter]==false)
            {
                matrix[counter]=-1;
                int value=dfs(adjList,counter,s,visited,matrix);
                longest=Math.max(longest,globalMax);
                //System.out.println("The unvisited value is "+counter+" The value is "+value);
            }
        }
        return longest;
    }
}
