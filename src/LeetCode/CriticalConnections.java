package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnections {
    boolean marked [];
    int count;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for (List<Integer> edge : connections){
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i = 0; i < connections.size(); i++){
            marked = new boolean[n];
            count = 0;

            List<Integer> curEdge = connections.get(i);

            graph.get(curEdge.get(0)).remove(curEdge.get(1));
            graph.get(curEdge.get(1)).remove(curEdge.get(0));

            dfs(graph, 0);
            if (count != n){
                ret.add(curEdge);
            }

            graph.get(curEdge.get(0)).add(curEdge.get(1));
            graph.get(curEdge.get(1)).add(curEdge.get(0));
        }

        return ret;
    }

    public void dfs (ArrayList<ArrayList<Integer>> graph, int n){
        marked[n] = true;
        count++;
        for (int w : graph.get(n)){
            if (!marked[w]){
                dfs(graph, w);
            }
        }
    }
}
