import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph4 {
    final int V;
    final List<List<Integer>> adj;

    public Graph4(int V)
    {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    boolean isCyclicUtil(int i, boolean[] visited,
                         boolean[] recStack)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    void addEdge(int source, int dest) {
        int diff=source-dest;
        int n=V-1;
        if(diff==-1||diff==1||diff==n||diff==-n)
        {
            // Add an edge from src to dest.
            adj.get(source).add(dest);

            adj.get(dest).add(source);
        }
        else
        {
            System.out.println("Can not addEdge");
        }
    }

    boolean isCyclic()
    {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;

    }
}
